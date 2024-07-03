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
package org.apache.dubbo.rpc.protocol.tri.command;

import org.apache.dubbo.remoting.websocket.stream.WebSocketStream;
import org.apache.dubbo.remoting.websocket.stream.WebSocketStreamChannel;
import org.apache.dubbo.remoting.websocket.stream.WebSocketStreamChannelBootstrap;
import org.apache.dubbo.rpc.protocol.tri.stream.TripleStreamChannelFuture;

import java.util.Map;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.concurrent.Future;

public class WebSocketCreateStreamQueueCommand extends QueuedCommand {

    private final TripleStreamChannelFuture streamChannelFuture;

    private final WebSocketStreamChannelBootstrap bootstrap;

    private final Map<String, Object> streamAttributes;

    private WebSocketCreateStreamQueueCommand(
            TripleStreamChannelFuture future,
            WebSocketStreamChannelBootstrap bootstrap,
            Map<String, Object> streamAttributes) {
        this.streamChannelFuture = future;
        this.bootstrap = bootstrap;
        this.streamAttributes = streamAttributes;
        this.promise(future.getParentChannel().newPromise());
        this.channel(future.getParentChannel());
    }

    public static WebSocketCreateStreamQueueCommand create(
            TripleStreamChannelFuture future,
            WebSocketStreamChannelBootstrap bootstrap,
            Map<String, Object> streamAttributes) {
        return new WebSocketCreateStreamQueueCommand(future, bootstrap, streamAttributes);
    }

    @Override
    public void doSend(ChannelHandlerContext ctx, ChannelPromise promise) {
        // NOOP
    }

    @Override
    public void run(Channel channel) {
        Future<WebSocketStreamChannel> future = bootstrap.open();
        if (future.isSuccess()) {
            WebSocketStreamChannel streamChannel = future.getNow();
            WebSocketStream stream = streamChannel.stream();
            stream.attrs(streamAttributes);
            streamChannelFuture.complete(streamChannel);
        } else {
            streamChannelFuture.completeExceptionally(future.cause());
        }
    }
}
