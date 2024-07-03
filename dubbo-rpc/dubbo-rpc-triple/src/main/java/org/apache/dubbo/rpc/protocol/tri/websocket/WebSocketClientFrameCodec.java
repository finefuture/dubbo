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
package org.apache.dubbo.rpc.protocol.tri.websocket;

import org.apache.dubbo.remoting.websocket.stream.WebSocketDataFrame;
import org.apache.dubbo.remoting.websocket.stream.WebSocketHeaderFrame;
import org.apache.dubbo.remoting.websocket.stream.WebSocketResetFrame;
import org.apache.dubbo.remoting.websocket.stream.WebSocketStreamException;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http2.DefaultHttp2DataFrame;
import io.netty.handler.codec.http2.DefaultHttp2HeadersFrame;
import io.netty.handler.codec.http2.DefaultHttp2ResetFrame;
import io.netty.handler.codec.http2.Http2DataFrame;
import io.netty.handler.codec.http2.Http2HeadersFrame;

@Sharable
public class WebSocketClientFrameCodec extends ChannelDuplexHandler {

    public static final WebSocketClientFrameCodec INSTANCE = new WebSocketClientFrameCodec();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof WebSocketHeaderFrame) {
            WebSocketHeaderFrame headerFrame = (WebSocketHeaderFrame) msg;
            super.channelRead(ctx, new DefaultHttp2HeadersFrame(headerFrame.getHeaders(), headerFrame.isEndOfStream()));
        } else if (msg instanceof WebSocketDataFrame) {
            WebSocketDataFrame dataFrame = (WebSocketDataFrame) msg;
            super.channelRead(ctx, new DefaultHttp2DataFrame(dataFrame.getData(), dataFrame.isEndOfStream()));
        } else {
            super.channelRead(ctx, msg);
        }
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof Http2HeadersFrame) {
            Http2HeadersFrame headersFrame = (Http2HeadersFrame) msg;
            super.write(ctx, new WebSocketHeaderFrame(headersFrame.headers(), headersFrame.isEndStream()), promise);
        } else if (msg instanceof Http2DataFrame) {
            Http2DataFrame dataFrame = (Http2DataFrame) msg;
            super.write(ctx, new WebSocketDataFrame(dataFrame.content(), dataFrame.isEndStream()), promise);
        } else {
            super.write(ctx, msg, promise);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketResetFrame) {
            super.userEventTriggered(ctx, new DefaultHttp2ResetFrame(((WebSocketResetFrame) evt).errorCode()));
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        if (cause instanceof WebSocketStreamException) {
            WebSocketStreamException e = (WebSocketStreamException) cause;
            ctx.fireUserEventTriggered(new DefaultHttp2ResetFrame(e.getStatusCode()));
            return;
        }
        super.exceptionCaught(ctx, cause);
    }
}
