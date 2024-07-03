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

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;

public class WebSocketMultiplexHandler extends WebSocketChannelDuplexHandler {

    static final ChannelFutureListener CHILD_CHANNEL_REGISTRATION_LISTENER = WebSocketMultiplexHandler::registerDone;

    private final ChannelHandler inboundStreamHandler;

    private ChannelHandlerContext ctx;

    private int idCount;

    public WebSocketMultiplexHandler(ChannelHandler inboundStreamHandler) {
        this.inboundStreamHandler = inboundStreamHandler;
    }

    @Override
    protected void handlerAdded0(ChannelHandlerContext ctx) {
        if (ctx.executor() != ctx.channel().eventLoop()) {
            throw new IllegalStateException("EventExecutor must be EventLoop of Channel");
        }
        this.ctx = ctx;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof WebSocketStreamFrame) {
            WebSocketStreamFrame streamFrame = (WebSocketStreamFrame) msg;
            DefaultWebSocketConnection.DefaultWebSocketStream stream =
                    (DefaultWebSocketConnection.DefaultWebSocketStream) streamFrame.stream();

            WebSocketStreamChannel channel = stream.channel();
            if (msg instanceof WebSocketResetFrame) {
                channel.pipeline().fireUserEventTriggered(msg);
            } else {
                channel.pipeline().fireChannelRead(streamFrame);
            }
            return;
        }

        ctx.fireChannelRead(msg);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketFrameStreamEvent) {
            WebSocketFrameStreamEvent event = (WebSocketFrameStreamEvent) evt;
            WebSocketStream stream = event.getStream();
            switch (event.getType()) {
                case ACTIVATE:
                    WebSocketStreamChannel webSocketChannel = newInboundStream(stream);
                    ChannelFuture future = ctx.channel().eventLoop().register(webSocketChannel);
                    if (future.isDone()) {
                        registerDone(future);
                    } else {
                        future.addListener(CHILD_CHANNEL_REGISTRATION_LISTENER);
                    }
                    break;
                case CLOSED:
                    WebSocketStreamChannel channel = stream.channel();
                    if (channel != null) {
                        channel.close();
                    }
                    break;
                default:
                    break;
            }
        }
        super.userEventTriggered(ctx, evt);
    }

    static void registerDone(ChannelFuture future) {
        if (!future.isSuccess()) {
            Channel childChannel = future.channel();
            if (childChannel.isRegistered()) {
                childChannel.close();
            } else {
                childChannel.unsafe().closeForcibly();
            }
        }
    }

    WebSocketStreamChannel newInboundStream(WebSocketStream stream) {
        return new WebSocketMultiplexHandlerStreamChannel(stream, inboundStreamHandler);
    }

    WebSocketStreamChannel newOutboundStream() {
        return new WebSocketMultiplexHandlerStreamChannel(newStream(), null);
    }

    private final class WebSocketMultiplexHandlerStreamChannel extends AbstractWebSocketStreamChannel {

        WebSocketMultiplexHandlerStreamChannel(WebSocketStream stream, ChannelHandler inboundHandler) {
            super(stream, ++idCount, inboundHandler);
        }

        @Override
        protected ChannelHandlerContext parentContext() {
            return ctx;
        }
    }
}
