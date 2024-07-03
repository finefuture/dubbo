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

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.StringUtil;

public abstract class WebSocketChannelDuplexHandler extends ChannelDuplexHandler {

    private volatile WebSocketStreamFrameCodec frameCodec;

    @Override
    public final void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        frameCodec = requireWebSocketFrameCodec(ctx);
        handlerAdded0(ctx);
    }

    protected void handlerAdded0(@SuppressWarnings("unused") ChannelHandlerContext ctx) {
        // NOOP
    }

    @Override
    public final void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        try {
            handlerRemoved0(ctx);
        } finally {
            frameCodec = null;
        }
    }

    protected void handlerRemoved0(@SuppressWarnings("unused") ChannelHandlerContext ctx) {
        // NOOP
    }

    /**
     * Creates a new {@link WebSocketStream} object.
     *
     * <p>This method is <em>thread-safe</em>.
     */
    public final WebSocketStream newStream() {
        WebSocketStreamFrameCodec codec = frameCodec;
        if (codec == null) {
            throw new IllegalStateException(StringUtil.simpleClassName(WebSocketStreamFrameCodec.class) + " not found."
                    + " Has the handler been added to a pipeline?");
        }
        return codec.newStream();
    }

    private static WebSocketStreamFrameCodec requireWebSocketFrameCodec(ChannelHandlerContext ctx) {
        ChannelHandlerContext frameCodecCtx = ctx.pipeline().context(WebSocketStreamFrameCodec.class);
        if (frameCodecCtx == null) {
            throw new IllegalArgumentException(
                    WebSocketStreamFrameCodec.class.getSimpleName() + " was not found in the channel pipeline.");
        }
        return (WebSocketStreamFrameCodec) frameCodecCtx.handler();
    }
}
