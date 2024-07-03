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

import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.nested.TripleConfig;
import org.apache.dubbo.remoting.http12.command.HttpWriteQueue;
import org.apache.dubbo.remoting.http12.exception.UnsupportedMediaTypeException;
import org.apache.dubbo.remoting.http12.h2.H2StreamChannel;
import org.apache.dubbo.remoting.http12.h2.command.Http2WriteQueueChannel;
import org.apache.dubbo.remoting.http12.netty4.HttpWriteQueueHandler;
import org.apache.dubbo.remoting.http12.netty4.h2.NettyHttp2FrameHandler;
import org.apache.dubbo.remoting.websocket.WebSocketServerTransportListenerFactory;
import org.apache.dubbo.remoting.websocket.WebSocketTransportListener;
import org.apache.dubbo.rpc.model.FrameworkModel;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public abstract class AbstractNettyWebSocketProtocolSelectorHandler extends ChannelInboundHandlerAdapter {

    private final URL url;

    private final FrameworkModel frameworkModel;

    private final TripleConfig tripleConfig;

    protected AbstractNettyWebSocketProtocolSelectorHandler(
            URL url, FrameworkModel frameworkModel, TripleConfig tripleConfig) {
        this.url = url;
        this.frameworkModel = frameworkModel;
        this.tripleConfig = tripleConfig;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            if (!support(msg)) {
                return;
            }
            String contentType = contentType(msg);
            WebSocketServerTransportListenerFactory factory =
                    determineWebSocketServerTransportListenerFactory(contentType);
            if (factory == null) {
                throw new UnsupportedMediaTypeException(contentType);
            }

            H2StreamChannel streamChannel = createStreamChannel(ctx);
            HttpWriteQueueHandler writeQueueHandler = getWriteQueue(ctx);
            if (writeQueueHandler != null) {
                HttpWriteQueue writeQueue = writeQueueHandler.getWriteQueue();
                streamChannel = new Http2WriteQueueChannel(streamChannel, writeQueue);
            }

            WebSocketTransportListener webSocketTransportListener =
                    factory.newInstance(streamChannel, getUrl(), getFrameworkModel());
            ctx.channel().closeFuture().addListener(future -> webSocketTransportListener.close());
            ctx.pipeline().addLast(new NettyHttp2FrameHandler(streamChannel, webSocketTransportListener));
            ctx.pipeline().remove(this);
        } finally {
            ctx.fireChannelRead(msg);
        }
    }

    private WebSocketServerTransportListenerFactory determineWebSocketServerTransportListenerFactory(
            String contentType) {
        for (WebSocketServerTransportListenerFactory factory :
                frameworkModel.getActivateExtensions(WebSocketServerTransportListenerFactory.class)) {
            if (factory.supportContentType(contentType)) {
                return factory;
            }
        }
        return null;
    }

    public URL getUrl() {
        return url;
    }

    public FrameworkModel getFrameworkModel() {
        return frameworkModel;
    }

    public TripleConfig getTripleConfig() {
        return tripleConfig;
    }

    protected abstract boolean support(Object msg);

    protected abstract String contentType(Object msg);

    protected abstract H2StreamChannel createStreamChannel(ChannelHandlerContext ctx);

    protected abstract HttpWriteQueueHandler getWriteQueue(ChannelHandlerContext ctx);
}
