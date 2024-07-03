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
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http2.Http2Headers;

import static org.apache.dubbo.remoting.websocket.WebSocketConstants.WEBSOCKET_COMBINATION_SUPPORT_KEY;

public class CompositeWebSocketFrameReader extends DefaultWebSocketConnectionHolder implements WebSocketFrameReader {

    private final DefaultWebSocketFrameReader defaultReader;

    private final CombinationWebSocketFrameReader combinationReader;

    public CompositeWebSocketFrameReader(
            DefaultWebSocketFrameReader defaultReader, CombinationWebSocketFrameReader combinationReader) {
        this.defaultReader = defaultReader;
        this.combinationReader = combinationReader;
    }

    @Override
    public void connection(WebSocketConnection connection) {
        super.connection(connection);
        defaultReader.connection(connection);
        combinationReader.connection(connection);
    }

    @Override
    public void frameListener(WebSocketFrameListener listener) {
        defaultReader.frameListener(listener);
        combinationReader.frameListener(new CombinationFrameListener(listener));
    }

    @Override
    public WebSocketFrameListener frameListener() {
        return defaultReader.frameListener();
    }

    @Override
    public void readFrame(ChannelHandlerContext ctx, ByteBuf input) {
        boolean combination = input.readBoolean();
        if (combination) {
            combinationReader.readFrame(ctx, input);
            return;
        }
        defaultReader.readFrame(ctx, input);
    }

    private final class CombinationFrameListener implements WebSocketFrameListener {

        private final WebSocketFrameListener frameListener;

        private CombinationFrameListener(WebSocketFrameListener frameListener) {
            this.frameListener = frameListener;
        }

        @Override
        public void onDataRead(ChannelHandlerContext ctx, int streamId, ByteBuf data, boolean endOfStream) {
            connection().stream(streamId).attr(WEBSOCKET_COMBINATION_SUPPORT_KEY, true);
            frameListener.onDataRead(ctx, streamId, data, endOfStream);
        }

        @Override
        public void onHeadersRead(ChannelHandlerContext ctx, int streamId, Http2Headers headers, boolean endOfStream) {
            frameListener.onHeadersRead(ctx, streamId, headers, endOfStream);
        }

        @Override
        public void onRstStreamRead(ChannelHandlerContext ctx, int streamId, long errorCode) {
            frameListener.onRstStreamRead(ctx, streamId, errorCode);
        }
    }
}
