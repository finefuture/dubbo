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

import java.nio.channels.ClosedChannelException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public class WebSocketStreamChannelBootstrap {

    private static final InternalLogger logger =
            InternalLoggerFactory.getInstance(WebSocketStreamChannelBootstrap.class);

    @SuppressWarnings("unchecked")
    private static final Map.Entry<ChannelOption<?>, Object>[] EMPTY_OPTION_ARRAY = new Map.Entry[0];

    @SuppressWarnings("unchecked")
    private static final Map.Entry<AttributeKey<?>, Object>[] EMPTY_ATTRIBUTE_ARRAY = new Map.Entry[0];

    // The order in which ChannelOptions are applied is important they may depend on each other for validation
    // purposes.
    private final Map<ChannelOption<?>, Object> options = new LinkedHashMap<>();
    private final Map<AttributeKey<?>, Object> attrs = new ConcurrentHashMap<>();
    private final Channel channel;
    private volatile ChannelHandler handler;

    // Cache the ChannelHandlerContext to speed up open(...) operations.
    private volatile ChannelHandlerContext multiplexCtx;

    public WebSocketStreamChannelBootstrap(Channel channel) {
        this.channel = ObjectUtil.checkNotNull(channel, "channel");
    }

    public <T> WebSocketStreamChannelBootstrap option(ChannelOption<T> option, T value) {
        ObjectUtil.checkNotNull(option, "option");

        synchronized (options) {
            if (value == null) {
                options.remove(option);
            } else {
                options.put(option, value);
            }
        }
        return this;
    }

    public <T> WebSocketStreamChannelBootstrap attr(AttributeKey<T> key, T value) {
        ObjectUtil.checkNotNull(key, "key");
        if (value == null) {
            attrs.remove(key);
        } else {
            attrs.put(key, value);
        }
        return this;
    }

    public WebSocketStreamChannelBootstrap handler(ChannelHandler handler) {
        this.handler = ObjectUtil.checkNotNull(handler, "handler");
        return this;
    }

    public Future<WebSocketStreamChannel> open() {
        return open(channel.eventLoop().newPromise());
    }

    public Future<WebSocketStreamChannel> open(final Promise<WebSocketStreamChannel> promise) {
        try {
            ChannelHandlerContext ctx = findCtx();
            EventExecutor executor = ctx.executor();
            if (executor.inEventLoop()) {
                open0(ctx, promise);
            } else {
                final ChannelHandlerContext finalCtx = ctx;
                executor.execute(() -> {
                    if (channel.isActive()) {
                        open0(finalCtx, promise);
                    } else {
                        promise.setFailure(new ClosedChannelException());
                    }
                });
            }
        } catch (Throwable cause) {
            promise.setFailure(cause);
        }
        return promise;
    }

    private ChannelHandlerContext findCtx() throws ClosedChannelException {
        // First try to use cached context and if this not work lets try to lookup the context.
        ChannelHandlerContext ctx = multiplexCtx;
        if (ctx != null && !ctx.isRemoved()) {
            return ctx;
        }
        ChannelPipeline pipeline = channel.pipeline();
        ctx = pipeline.context(WebSocketMultiplexHandler.class);
        if (ctx == null) {
            if (channel.isActive()) {
                throw new IllegalStateException(StringUtil.simpleClassName(WebSocketMultiplexHandler.class)
                        + " must be in the ChannelPipeline of Channel " + channel);
            } else {
                throw new ClosedChannelException();
            }
        }
        multiplexCtx = ctx;
        return ctx;
    }

    private void open0(ChannelHandlerContext ctx, final Promise<WebSocketStreamChannel> promise) {
        assert ctx.executor().inEventLoop();
        if (!promise.setUncancellable()) {
            return;
        }
        final WebSocketStreamChannel streamChannel;
        try {
            streamChannel = ((WebSocketMultiplexHandler) ctx.handler()).newOutboundStream();
        } catch (Exception e) {
            promise.setFailure(e);
            return;
        }
        try {
            init(streamChannel);
        } catch (Exception e) {
            streamChannel.unsafe().closeForcibly();
            promise.setFailure(e);
            return;
        }

        ChannelFuture future = ctx.channel().eventLoop().register(streamChannel);
        future.addListener((ChannelFutureListener) future1 -> {
            if (future1.isSuccess()) {
                promise.setSuccess(streamChannel);
            } else if (future1.isCancelled()) {
                promise.cancel(false);
            } else {
                if (streamChannel.isRegistered()) {
                    streamChannel.close();
                } else {
                    streamChannel.unsafe().closeForcibly();
                }

                promise.setFailure(future1.cause());
            }
        });
    }

    private void init(Channel channel) {
        ChannelPipeline p = channel.pipeline();
        ChannelHandler handler = this.handler;
        if (handler != null) {
            p.addLast(handler);
        }
        final Map.Entry<ChannelOption<?>, Object>[] optionArray;
        synchronized (options) {
            optionArray = options.entrySet().toArray(EMPTY_OPTION_ARRAY);
        }

        setChannelOptions(channel, optionArray);
        setAttributes(channel, attrs.entrySet().toArray(EMPTY_ATTRIBUTE_ARRAY));
    }

    private static void setChannelOptions(Channel channel, Map.Entry<ChannelOption<?>, Object>[] options) {
        for (Map.Entry<ChannelOption<?>, Object> e : options) {
            setChannelOption(channel, e.getKey(), e.getValue());
        }
    }

    private static void setChannelOption(Channel channel, ChannelOption<?> option, Object value) {
        try {
            @SuppressWarnings("unchecked")
            ChannelOption<Object> opt = (ChannelOption<Object>) option;
            if (!channel.config().setOption(opt, value)) {
                logger.warn("Unknown channel option '{}' for channel '{}'", option, channel);
            }
        } catch (Throwable t) {
            logger.warn(
                    "Failed to set channel option '{}' with value '{}' for channel '{}'", option, value, channel, t);
        }
    }

    private static void setAttributes(Channel channel, Map.Entry<AttributeKey<?>, Object>[] attrs) {
        for (Map.Entry<AttributeKey<?>, Object> e : attrs) {
            @SuppressWarnings("unchecked")
            AttributeKey<Object> key = (AttributeKey<Object>) e.getKey();
            channel.attr(key).set(e.getValue());
        }
    }
}
