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
package org.apache.dubbo.remoting.websocket.netty4;

import org.apache.dubbo.remoting.http12.HttpHeaders;
import org.apache.dubbo.remoting.http12.h2.Http2Header;
import org.apache.dubbo.remoting.http12.h2.Http2InputMessage;
import org.apache.dubbo.remoting.http12.h2.Http2InputMessageFrame;
import org.apache.dubbo.remoting.http12.h2.Http2MetadataFrame;
import org.apache.dubbo.remoting.http12.h2.Http2OutputMessage;
import org.apache.dubbo.remoting.websocket.stream.WebSocketDataFrame;
import org.apache.dubbo.remoting.websocket.stream.WebSocketHeaderFrame;
import org.apache.dubbo.remoting.websocket.stream.WebSocketResetFrame;
import org.apache.dubbo.remoting.websocket.stream.WebSocketStreamFrame;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.DefaultHttp2ResetFrame;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.Http2ResetFrame;

public class NettyWebSocketStreamFrameCodec extends ChannelDuplexHandler {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof WebSocketDataFrame) {
            Http2InputMessage http2InputMessage = onDataFrame((WebSocketDataFrame) msg);
            super.channelRead(ctx, http2InputMessage);
        } else if (msg instanceof WebSocketHeaderFrame) {
            Http2Header http2MetadataFrame = onHeaderFrame((WebSocketHeaderFrame) msg);
            super.channelRead(ctx, http2MetadataFrame);
        } else {
            super.channelRead(ctx, msg);
        }
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof Http2OutputMessage) {
            WebSocketStreamFrame dataFrame = encodeDataFrame((Http2OutputMessage) msg);
            super.write(ctx, dataFrame, promise);
        } else if (msg instanceof Http2Header) {
            WebSocketStreamFrame headerFrame = encodeHeaderFrame((Http2Header) msg);
            super.write(ctx, headerFrame, promise);
        } else {
            super.write(ctx, msg, promise);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketResetFrame) {
            Http2ResetFrame resetFrame = onResetFrame((WebSocketResetFrame) evt);
            super.userEventTriggered(ctx, resetFrame);
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    private Http2InputMessageFrame onDataFrame(WebSocketDataFrame dataFrame) {
        ByteBuf data = dataFrame.getData();
        Http2InputMessageFrame message =
                new Http2InputMessageFrame(new ByteBufInputStream(data, true), dataFrame.isEndOfStream());
        message.setId(dataFrame.stream().id());
        return message;
    }

    private Http2Header onHeaderFrame(WebSocketHeaderFrame headerFrame) {
        Http2Headers headers = headerFrame.getHeaders();
        HttpHeaders httpHeaders = new HttpHeaders();
        for (Map.Entry<CharSequence, CharSequence> header : headers) {
            httpHeaders.set(header.getKey().toString(), header.getValue().toString());
        }
        return new Http2MetadataFrame(headerFrame.stream().id(), httpHeaders, headerFrame.isEndOfStream());
    }

    private Http2ResetFrame onResetFrame(WebSocketResetFrame resetFrame) {
        return new DefaultHttp2ResetFrame(resetFrame.errorCode());
    }

    private WebSocketStreamFrame encodeDataFrame(Http2OutputMessage outputMessage) {
        OutputStream body = outputMessage.getBody();
        if (body == null) {
            return new WebSocketDataFrame(outputMessage.isEndStream());
        }
        if (body instanceof ByteBufOutputStream) {
            ByteBuf buf = ((ByteBufOutputStream) body).buffer();
            return new WebSocketDataFrame(buf, outputMessage.isEndStream());
        }
        throw new IllegalArgumentException("Http2OutputMessage body must be ByteBufOutputStream");
    }

    private WebSocketStreamFrame encodeHeaderFrame(Http2Header http2Header) {
        HttpHeaders headers = http2Header.headers();
        DefaultHttp2Headers http2Headers = new DefaultHttp2Headers(false);
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String name = entry.getKey();
            List<String> value = entry.getValue();
            http2Headers.set(name, value);
        }
        return new WebSocketHeaderFrame(http2Headers, http2Header.isEndStream());
    }
}
