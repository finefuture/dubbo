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

import org.apache.dubbo.remoting.websocket.stream.WebSocketStreamChannelBootstrap;
import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.rpc.model.MethodDescriptor.RpcType;
import org.apache.dubbo.rpc.protocol.tri.command.WebSocketCreateStreamQueueCommand;
import org.apache.dubbo.rpc.protocol.tri.stream.AbstractTripleClientStream;
import org.apache.dubbo.rpc.protocol.tri.stream.ClientStream;
import org.apache.dubbo.rpc.protocol.tri.stream.TripleStreamChannelFuture;
import org.apache.dubbo.rpc.protocol.tri.transport.TripleCommandOutBoundHandler;
import org.apache.dubbo.rpc.protocol.tri.transport.TripleHttp2ClientResponseHandler;
import org.apache.dubbo.rpc.protocol.tri.transport.TripleWriteQueue;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executor;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http2.Http2StreamChannel;

import static org.apache.dubbo.remoting.websocket.WebSocketConstants.WEBSOCKET_COMBINATION_SUPPORT_KEY;

public class WebSocketTripleClientStream extends AbstractTripleClientStream {

    public WebSocketTripleClientStream(
            FrameworkModel frameworkModel,
            Executor executor,
            Channel parent,
            ClientStream.Listener listener,
            TripleWriteQueue writeQueue,
            RpcType rpcType) {
        super(frameworkModel, executor, writeQueue, listener, parent, rpcType);
    }

    /**
     * For test only
     */
    public WebSocketTripleClientStream(
            FrameworkModel frameworkModel,
            Executor executor,
            TripleWriteQueue writeQueue,
            ClientStream.Listener listener,
            Http2StreamChannel http2StreamChannel,
            RpcType rpcType) {
        super(frameworkModel, executor, writeQueue, listener, http2StreamChannel, rpcType);
    }

    @Override
    protected TripleStreamChannelFuture initStreamChannel(Channel parent, RpcType rpcType) {
        WebSocketStreamChannelBootstrap bootstrap = new WebSocketStreamChannelBootstrap(parent)
                .handler(new ChannelInboundHandlerAdapter() {
                    @Override
                    public void handlerAdded(ChannelHandlerContext ctx) {
                        ctx.channel()
                                .pipeline()
                                .addLast(WebSocketClientFrameCodec.INSTANCE)
                                .addLast(new TripleCommandOutBoundHandler())
                                .addLast(new TripleHttp2ClientResponseHandler(createTransportListener()));
                    }
                });

        TripleStreamChannelFuture streamChannelFuture = new TripleStreamChannelFuture(parent);
        Map<String, Object> streamAttributes = null;
        if (rpcType == RpcType.UNARY) {
            streamAttributes = Collections.singletonMap(WEBSOCKET_COMBINATION_SUPPORT_KEY, true);
        }
        WebSocketCreateStreamQueueCommand createStreamQueueCommand =
                WebSocketCreateStreamQueueCommand.create(streamChannelFuture, bootstrap, streamAttributes);
        writeQueue.enqueue(createStreamQueueCommand);
        return streamChannelFuture;
    }
}
