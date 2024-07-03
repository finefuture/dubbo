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
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2HeadersEncoder;

import static org.apache.dubbo.remoting.websocket.WebSocketConstants.WEBSOCKET_COMBINATION_SUPPORT_KEY;
import static org.apache.dubbo.remoting.websocket.WebSocketConstants.WEBSOCKET_COMBINATION_WRITER_KEY;

public class CompositeWebSocketFrameWriter extends AbstractWebSocketFrameWriter {

    private final DefaultWebSocketFrameWriter defaultWriter;

    private final CombinationWebSocketFrameWriter combinationWriter;

    public CompositeWebSocketFrameWriter(
            CompositeDefaultWebSocketFrameWriter defaultWriter, CombinationWebSocketFrameWriter combinationWriter) {
        this.defaultWriter = defaultWriter;
        this.combinationWriter = combinationWriter;
    }

    @Override
    public void connection(WebSocketConnection connection) {
        super.connection(connection);
        defaultWriter.connection(connection);
        combinationWriter.connection(connection);
    }

    @Override
    public ChannelFuture writeHeaders(
            ChannelHandlerContext ctx,
            int streamId,
            Http2Headers headers,
            boolean endOfStream,
            ChannelPromise promise) {
        WebSocketFrameWriter frameWriter = bindToStream(streamId);
        return frameWriter.writeHeaders(ctx, streamId, headers, endOfStream, promise);
    }

    @Override
    public ChannelFuture writeData(
            ChannelHandlerContext ctx, int streamId, ByteBuf data, boolean endOfStream, ChannelPromise promise) {
        WebSocketFrameWriter frameWriter = streamWriter(streamId);
        return frameWriter.writeData(ctx, streamId, data, endOfStream, promise);
    }

    private WebSocketFrameWriter bindToStream(int streamId) {
        WebSocketStream stream = connection().stream(streamId);
        WebSocketFrameWriter frameWriter = stream.attr(WEBSOCKET_COMBINATION_WRITER_KEY);
        if (frameWriter != null) {
            return frameWriter;
        }
        Boolean combination = stream.attr(WEBSOCKET_COMBINATION_SUPPORT_KEY);
        if (Boolean.TRUE.equals(combination)) {
            stream.attr(WEBSOCKET_COMBINATION_WRITER_KEY, combinationWriter);
            return combinationWriter;
        }
        stream.attr(WEBSOCKET_COMBINATION_WRITER_KEY, defaultWriter);
        return defaultWriter;
    }

    private WebSocketFrameWriter streamWriter(int streamId) {
        WebSocketStream stream = connection().stream(streamId);
        return stream.attr(WEBSOCKET_COMBINATION_WRITER_KEY);
    }

    public static class CompositeDefaultWebSocketFrameWriter extends DefaultWebSocketFrameWriter {

        public CompositeDefaultWebSocketFrameWriter(Http2HeadersEncoder headersEncoder) {
            super(headersEncoder);
        }

        @Override
        protected final void writeFrameHeaderInternal(ByteBuf out, byte type, int streamId) {
            out.writeBoolean(false);
            out.writeInt(streamId);
            out.writeByte(type);
        }
    }
}
