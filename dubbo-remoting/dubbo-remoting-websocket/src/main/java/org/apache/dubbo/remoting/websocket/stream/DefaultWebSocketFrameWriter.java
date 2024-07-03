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
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2HeadersEncoder;

public class DefaultWebSocketFrameWriter extends AbstractWebSocketFrameWriter {

    private final Http2HeadersEncoder headersEncoder;

    public DefaultWebSocketFrameWriter(Http2HeadersEncoder headersEncoder) {
        this.headersEncoder = headersEncoder;
    }

    @Override
    public ChannelFuture writeHeaders(
            ChannelHandlerContext ctx,
            int streamId,
            Http2Headers headers,
            boolean endOfStream,
            ChannelPromise promise) {
        try {
            ByteBuf buf = ctx.alloc().buffer();
            writeFrameHeaderInternal(buf, WebSocketFrameType.HEADERS, streamId);
            buf.writeBoolean(endOfStream);
            headersEncoder.encodeHeaders(streamId, headers, buf);
            return write(ctx, buf, streamId, endOfStream, promise);
        } catch (Http2Exception e) {
            return promise.setFailure(e);
        }
    }

    @Override
    public ChannelFuture writeData(
            ChannelHandlerContext ctx, int streamId, ByteBuf data, boolean endOfStream, ChannelPromise promise) {
        try {
            ByteBuf buf = ctx.alloc().buffer();
            writeFrameHeaderInternal(buf, WebSocketFrameType.DATA, streamId);
            buf.writeBoolean(endOfStream);
            buf.writeBytes(data);
            return write(ctx, buf, streamId, endOfStream, promise);
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    private ChannelFuture write(
            ChannelHandlerContext ctx, ByteBuf buf, int streamId, boolean endOfStream, ChannelPromise promise) {
        ChannelFuture future = ctx.write(new BinaryWebSocketFrame(buf), promise);
        if (endOfStream) {
            connection().closeStreamLocal(connection().stream(streamId), future);
        }
        return future;
    }
}
