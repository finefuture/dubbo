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
import org.apache.dubbo.remoting.http12.HttpHeaderNames;
import org.apache.dubbo.remoting.http12.h2.H2StreamChannel;
import org.apache.dubbo.remoting.http12.netty4.HttpWriteQueueHandler;
import org.apache.dubbo.rpc.model.FrameworkModel;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class NettyWebSocketProtocolSelectorHandler extends AbstractNettyWebSocketProtocolSelectorHandler {

    public NettyWebSocketProtocolSelectorHandler(URL url, FrameworkModel frameworkModel, TripleConfig tripleConfig) {
        super(url, frameworkModel, tripleConfig);
    }

    @Override
    protected boolean support(Object msg) {
        return msg instanceof FullHttpRequest;
    }

    @Override
    protected String contentType(Object msg) {
        FullHttpRequest request = (FullHttpRequest) msg;
        return request.headers().get(HttpHeaderNames.CONTENT_TYPE.getName());
    }

    @Override
    protected H2StreamChannel createStreamChannel(ChannelHandlerContext ctx) {
        return new NettyWebSocketChannel(ctx.channel(), getTripleConfig());
    }

    protected HttpWriteQueueHandler getWriteQueue(ChannelHandlerContext ctx) {
        return ctx.channel().pipeline().get(HttpWriteQueueHandler.class);
    }
}
