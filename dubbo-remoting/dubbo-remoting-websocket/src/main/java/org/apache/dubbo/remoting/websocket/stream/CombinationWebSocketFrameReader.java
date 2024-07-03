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
import io.netty.handler.codec.http2.Http2HeadersDecoder;

public class CombinationWebSocketFrameReader extends DefaultWebSocketConnectionHolder implements WebSocketFrameReader {

    private WebSocketFrameListener frameListener;

    private final Http2HeadersDecoder headersDecoder;

    public CombinationWebSocketFrameReader(Http2HeadersDecoder headersDecoder) {
        this.headersDecoder = headersDecoder;
    }

    @Override
    public void frameListener(WebSocketFrameListener listener) {
        this.frameListener = listener;
    }

    @Override
    public WebSocketFrameListener frameListener() {
        return frameListener;
    }

    @Override
    public void readFrame(ChannelHandlerContext ctx, ByteBuf input) {
        int streamId = input.readInt();
        try {
            int headerLength = input.readInt();
            ByteBuf header = input.readSlice(headerLength);
            Http2Headers headers = headersDecoder.decodeHeaders(streamId, header);
            frameListener.onHeadersRead(ctx, streamId, headers, false);

            int payloadLength = input.readInt();
            ByteBuf data = input.readRetainedSlice(payloadLength);
            boolean readable = input.isReadable();
            frameListener.onDataRead(ctx, streamId, data, !readable);

            if (readable) {
                Http2Headers trailers = headersDecoder.decodeHeaders(streamId, input);
                frameListener.onHeadersRead(ctx, streamId, trailers, true);
            }
        } catch (Exception e) {
            throw new WebSocketStreamException(streamId, 500, "websocket decode header failed", e);
        } finally{
            input.release();
        }
    }
}
