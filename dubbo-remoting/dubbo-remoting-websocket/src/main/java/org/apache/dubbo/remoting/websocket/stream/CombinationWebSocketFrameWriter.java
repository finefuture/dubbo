/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.remoting.websocket.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;

public class CombinationWebSocketFrameWriter extends AbstractWebSocketFrameWriter {

    private final IntObjectMap<Http2Headers> paddingHeaders = new IntObjectHashMap<>();

    private final IntObjectMap<Http2Headers> paddingTrailers = new IntObjectHashMap<>();

    private final IntObjectMap<CompositeByteBuf> paddingData = new IntObjectHashMap<>();

    private final Http2HeadersEncoder headersEncoder;

    public CombinationWebSocketFrameWriter(Http2HeadersEncoder headersEncoder) {
        this.headersEncoder = headersEncoder;
    }

    @Override
    public ChannelFuture writeHeaders(
            ChannelHandlerContext ctx,
            int streamId,
            Http2Headers headers,
            boolean endOfStream,
            ChannelPromise promise) {
        if (endOfStream) {
            paddingTrailers.put(streamId, headers);
            ChannelFuture future = write(ctx, streamId, promise);
            connection().closeStreamLocal(connection().stream(streamId), future);
            return future;
        }
        paddingHeaders.put(streamId, headers);
        return promise.setSuccess();
    }

    @Override
    public ChannelFuture writeData(
            ChannelHandlerContext ctx, int streamId, ByteBuf data, boolean endOfStream, ChannelPromise promise) {
        paddingData
                .computeIfAbsent(streamId, id -> ctx.alloc().compositeBuffer())
                .addComponent(true, data);
        if (endOfStream) {
            ChannelFuture future = write(ctx, streamId, promise);
            connection().closeStreamLocal(connection().stream(streamId), future);
            return future;
        }
        return promise.setSuccess();
    }

    private ChannelFuture write(ChannelHandlerContext ctx, int streamId, ChannelPromise promise) {
        ByteBuf buf = ctx.alloc().buffer();
        CompositeByteBuf padding = paddingData.remove(streamId);
        try {
            writeCombinationHeaderInternal(buf, streamId);

            int writerIndex = buf.writerIndex();
            buf.writerIndex(writerIndex + 4);
            Http2Headers http2Headers = paddingHeaders.remove(streamId);
            if (http2Headers != null) {
                encodeHeader(buf, streamId, http2Headers);
            }
            buf.setInt(writerIndex, buf.writerIndex() - writerIndex - 4);

            if (padding != null) {
                buf.writeInt(padding.readableBytes());
                buf.writeBytes(padding);
            } else {
                buf.writeInt(0);
            }

            Http2Headers trailers = paddingTrailers.remove(streamId);
            if (trailers != null) {
                encodeHeader(buf, streamId, trailers);
            }
            return ctx.write(new BinaryWebSocketFrame(buf), promise);
        } catch (Exception e) {
            buf.release();
            return promise.setFailure(e);
        } finally {
            if (padding != null) {
                padding.release();
            }
        }
    }

    private void writeCombinationHeaderInternal(ByteBuf out, int streamId) {
        out.writeBoolean(true);
        out.writeInt(streamId);
    }

    private void encodeHeader(ByteBuf out, int streamId, Http2Headers headers) throws Http2Exception {
        headersEncoder.encodeHeaders(streamId, headers, out);
    }
}
