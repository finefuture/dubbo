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
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2HeadersDecoder;

import static org.apache.dubbo.remoting.websocket.stream.WebSocketFrameType.DATA;
import static org.apache.dubbo.remoting.websocket.stream.WebSocketFrameType.HEADERS;
import static org.apache.dubbo.remoting.websocket.stream.WebSocketFrameType.RST_STREAM;

public class DefaultWebSocketFrameReader extends DefaultWebSocketConnectionHolder implements WebSocketFrameReader {

    private WebSocketFrameListener frameListener;

    private final Http2HeadersDecoder headersDecoder;

    public DefaultWebSocketFrameReader(Http2HeadersDecoder headersDecoder) {
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
        byte frameType = input.readByte();
        switch (frameType) {
            case DATA:
                readData(ctx, streamId, input);
                break;
            case HEADERS:
                readHeader(ctx, streamId, input);
                break;
            case RST_STREAM:
                readRstStream(ctx, streamId, input);
                break;
            default:
                throw new WebSocketStreamException(streamId, 500, "Unknown frame type");
        }
    }

    private void readData(ChannelHandlerContext ctx, int streamId, ByteBuf input) {
        boolean endOfStream = input.readBoolean();
        frameListener.onDataRead(ctx, streamId, input, endOfStream);
    }

    private void readHeader(ChannelHandlerContext ctx, int streamId, ByteBuf input) {
        try {
            boolean endOfStream = input.readBoolean();
            Http2Headers headers = headersDecoder.decodeHeaders(streamId, input);
            frameListener.onHeadersRead(ctx, streamId, headers, endOfStream);
        } catch (Http2Exception e) {
            throw new WebSocketStreamException(streamId, 500, "websocket decode header failed", e);
        } finally {
            input.release();
        }
    }

    private void readRstStream(ChannelHandlerContext ctx, int streamId, ByteBuf input) {
        try {
            long errorCode = input.readUnsignedInt();
            frameListener.onRstStreamRead(ctx, streamId, errorCode);
        } finally {
            input.release();
        }
    }
}
