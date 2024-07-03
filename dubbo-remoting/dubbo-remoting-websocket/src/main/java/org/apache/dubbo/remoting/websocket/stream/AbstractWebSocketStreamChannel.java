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

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.concurrent.RejectedExecutionException;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.DefaultChannelPipeline;
import io.netty.channel.EventLoop;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.VoidChannelPromise;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

import static org.apache.dubbo.remoting.websocket.stream.StreamIdGenerator.isStreamIdValid;

public abstract class AbstractWebSocketStreamChannel extends DefaultAttributeMap implements WebSocketStreamChannel {

    private static final InternalLogger logger =
            InternalLoggerFactory.getInstance(AbstractWebSocketStreamChannel.class);

    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);

    private final DefaultChannelConfig config = new DefaultChannelConfig(this);
    private final WebSocketChannelUnsafe unsafe = new WebSocketChannelUnsafe();
    private final ChannelId channelId;
    private final ChannelPipeline pipeline;
    private final WebSocketStream stream;
    private final ChannelPromise closePromise;

    private volatile boolean registered;

    private boolean outboundClosed;

    private boolean firstFrameWritten;

    AbstractWebSocketStreamChannel(WebSocketStream stream, int id, ChannelHandler inboundHandler) {
        this.stream = stream;
        stream.channel(this);
        pipeline = new DefaultChannelPipeline(this) {};

        closePromise = pipeline.newPromise();
        channelId = new WebSocketStreamChannelId(parent().id(), id);

        if (inboundHandler != null) {
            // Add the handler to the pipeline now that we are registered.
            pipeline.addLast(inboundHandler);
        }
    }

    @Override
    public WebSocketStream stream() {
        return stream;
    }

    @Override
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override
    public ChannelConfig config() {
        return config;
    }

    @Override
    public boolean isOpen() {
        return !closePromise.isDone();
    }

    @Override
    public boolean isActive() {
        return isOpen();
    }

    @Override
    public boolean isWritable() {
        return parent().isWritable();
    }

    @Override
    public ChannelId id() {
        return channelId;
    }

    @Override
    public EventLoop eventLoop() {
        return parent().eventLoop();
    }

    @Override
    public Channel parent() {
        return parentContext().channel();
    }

    @Override
    public boolean isRegistered() {
        return registered;
    }

    @Override
    public SocketAddress localAddress() {
        return parent().localAddress();
    }

    @Override
    public SocketAddress remoteAddress() {
        return parent().remoteAddress();
    }

    @Override
    public ChannelFuture closeFuture() {
        return closePromise;
    }

    @Override
    public long bytesBeforeUnwritable() {
        return parent().bytesBeforeUnwritable();
    }

    @Override
    public long bytesBeforeWritable() {
        return parent().bytesBeforeWritable();
    }

    @Override
    public Unsafe unsafe() {
        return unsafe;
    }

    @Override
    public ChannelPipeline pipeline() {
        return pipeline;
    }

    @Override
    public ByteBufAllocator alloc() {
        return config().getAllocator();
    }

    @Override
    public Channel read() {
        pipeline().read();
        return this;
    }

    @Override
    public Channel flush() {
        pipeline().flush();
        return this;
    }

    @Override
    public ChannelFuture bind(SocketAddress localAddress) {
        return pipeline().bind(localAddress);
    }

    @Override
    public ChannelFuture connect(SocketAddress remoteAddress) {
        return pipeline().connect(remoteAddress);
    }

    @Override
    public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress) {
        return pipeline().connect(remoteAddress, localAddress);
    }

    @Override
    public ChannelFuture disconnect() {
        return pipeline().disconnect();
    }

    @Override
    public ChannelFuture close() {
        return pipeline().close();
    }

    @Override
    public ChannelFuture deregister() {
        return pipeline().deregister();
    }

    @Override
    public ChannelFuture bind(SocketAddress localAddress, ChannelPromise promise) {
        return pipeline().bind(localAddress, promise);
    }

    @Override
    public ChannelFuture connect(SocketAddress remoteAddress, ChannelPromise promise) {
        return pipeline().connect(remoteAddress, promise);
    }

    @Override
    public ChannelFuture connect(SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) {
        return pipeline().connect(remoteAddress, localAddress, promise);
    }

    @Override
    public ChannelFuture disconnect(ChannelPromise promise) {
        return pipeline().disconnect(promise);
    }

    @Override
    public ChannelFuture close(ChannelPromise promise) {
        return pipeline().close(promise);
    }

    @Override
    public ChannelFuture deregister(ChannelPromise promise) {
        return pipeline().deregister(promise);
    }

    @Override
    public ChannelFuture write(Object msg) {
        return pipeline().write(msg);
    }

    @Override
    public ChannelFuture write(Object msg, ChannelPromise promise) {
        return pipeline().write(msg, promise);
    }

    @Override
    public ChannelFuture writeAndFlush(Object msg, ChannelPromise promise) {
        return pipeline().writeAndFlush(msg, promise);
    }

    @Override
    public ChannelFuture writeAndFlush(Object msg) {
        return pipeline().writeAndFlush(msg);
    }

    @Override
    public ChannelPromise newPromise() {
        return pipeline().newPromise();
    }

    @Override
    public ChannelProgressivePromise newProgressivePromise() {
        return pipeline().newProgressivePromise();
    }

    @Override
    public ChannelFuture newSucceededFuture() {
        return pipeline().newSucceededFuture();
    }

    @Override
    public ChannelFuture newFailedFuture(Throwable cause) {
        return pipeline().newFailedFuture(cause);
    }

    @Override
    public ChannelPromise voidPromise() {
        return pipeline().voidPromise();
    }

    @Override
    public int hashCode() {
        return id().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int compareTo(Channel o) {
        if (this == o) {
            return 0;
        }

        return id().compareTo(o.id());
    }

    @Override
    public String toString() {
        return parent().toString() + "(WebSocket - " + stream + ')';
    }

    private final class WebSocketChannelUnsafe implements Unsafe {
        private final VoidChannelPromise unsafeVoidPromise =
                new VoidChannelPromise(AbstractWebSocketStreamChannel.this, false);

        @SuppressWarnings("deprecation")
        private RecvByteBufAllocator.Handle recvHandle;

        private boolean writeDoneAndNoFlush;
        private boolean closeInitiated;

        @Override
        public void connect(
                final SocketAddress remoteAddress, SocketAddress localAddress, final ChannelPromise promise) {
            if (!promise.setUncancellable()) {
                return;
            }
            promise.setFailure(new UnsupportedOperationException());
        }

        @Override
        public RecvByteBufAllocator.Handle recvBufAllocHandle() {
            if (recvHandle == null) {
                recvHandle = config().getRecvByteBufAllocator().newHandle();
            }
            return recvHandle;
        }

        @Override
        public SocketAddress localAddress() {
            return parent().unsafe().localAddress();
        }

        @Override
        public SocketAddress remoteAddress() {
            return parent().unsafe().remoteAddress();
        }

        @Override
        public void register(EventLoop eventLoop, ChannelPromise promise) {
            if (!promise.setUncancellable()) {
                return;
            }
            if (registered) {
                promise.setFailure(new UnsupportedOperationException("Re-register is not supported"));
                return;
            }

            registered = true;

            promise.setSuccess();

            pipeline().fireChannelRegistered();
            if (isActive()) {
                pipeline().fireChannelActive();
            }
        }

        @Override
        public void bind(SocketAddress localAddress, ChannelPromise promise) {
            if (!promise.setUncancellable()) {
                return;
            }
            promise.setFailure(new UnsupportedOperationException());
        }

        @Override
        public void disconnect(ChannelPromise promise) {
            close(promise);
        }

        @Override
        public void close(final ChannelPromise promise) {
            close(promise, WebSocketError.CANCEL);
        }

        void close(final ChannelPromise promise, WebSocketError error) {
            if (!promise.setUncancellable()) {
                return;
            }
            if (closeInitiated) {
                if (closePromise.isDone()) {
                    // Closed already.
                    promise.setSuccess();
                } else if (!(promise instanceof VoidChannelPromise)) {
                    closePromise.addListener((ChannelFutureListener) future -> promise.setSuccess());
                }
                return;
            }
            closeInitiated = true;

            final boolean wasActive = isActive();

            if (parent().isActive() && isStreamIdValid(stream().id()) && !stream().completed()) {
                WebSocketStreamFrame resetFrame = new WebSocketResetFrame(error.code()).stream(stream());
                write(resetFrame, unsafe().voidPromise());
                flush();
            }

            // The promise should be notified before we call fireChannelInactive().
            outboundClosed = true;
            closePromise.setSuccess();
            promise.setSuccess();

            fireChannelInactiveAndDeregister(voidPromise(), wasActive);
        }

        @Override
        public void closeForcibly() {
            close(unsafe().voidPromise());
        }

        @Override
        public void deregister(ChannelPromise promise) {
            fireChannelInactiveAndDeregister(promise, false);
        }

        private void fireChannelInactiveAndDeregister(final ChannelPromise promise, final boolean fireChannelInactive) {
            if (!promise.setUncancellable()) {
                return;
            }

            if (!registered) {
                promise.setSuccess();
                return;
            }
            invokeLater(() -> {
                if (fireChannelInactive) {
                    pipeline.fireChannelInactive();
                }
                if (registered) {
                    registered = false;
                    pipeline.fireChannelUnregistered();
                }
                safeSetSuccess(promise);
            });
        }

        private void safeSetSuccess(ChannelPromise promise) {
            if (!(promise instanceof VoidChannelPromise) && !promise.trySuccess()) {
                logger.warn("Failed to mark a promise as success because it is done already: {}", promise);
            }
        }

        private void invokeLater(Runnable task) {
            try {
                // This method is used by outbound operation implementations to trigger an inbound event later.
                // They do not trigger an inbound event immediately because an outbound operation might have been
                // triggered by another inbound event handler method.  If fired immediately, the call stack
                // will look like this for example:
                //
                //   handlerA.inboundBufferUpdated() - (1) an inbound handler method closes a connection.
                //   -> handlerA.ctx.close()
                //     -> channel.unsafe.close()
                //       -> handlerA.channelInactive() - (2) another inbound handler method called while in (1) yet
                //
                // which means the execution of two inbound handler methods of the same handler overlap undesirably.
                eventLoop().execute(task);
            } catch (RejectedExecutionException e) {
                logger.warn("Can't invoke task later as EventLoop rejected it", e);
            }
        }

        @Override
        public void beginRead() {}

        @Override
        public void write(Object msg, final ChannelPromise promise) {
            // After this point its not possible to cancel a write anymore.
            if (!promise.setUncancellable()) {
                ReferenceCountUtil.release(msg);
                return;
            }

            if (!isActive()
                    ||
                    // Once the outbound side was closed we should not allow header / data frames
                    outboundClosed && (msg instanceof WebSocketHeaderFrame || msg instanceof WebSocketDataFrame)) {
                ReferenceCountUtil.release(msg);
                promise.setFailure(new ClosedChannelException());
                return;
            }

            try {
                if (msg instanceof WebSocketStreamFrame) {
                    WebSocketStreamFrame frame = validateStreamFrame((WebSocketStreamFrame) msg).stream(stream());
                    writeHttp2StreamFrame(frame, promise);
                } else {
                    String msgStr = msg.toString();
                    ReferenceCountUtil.release(msg);
                    promise.setFailure(new IllegalArgumentException("Message must be an "
                            + StringUtil.simpleClassName(WebSocketStreamFrame.class) + ": " + msgStr));
                }
            } catch (Throwable t) {
                promise.tryFailure(t);
            }
        }

        private void writeHttp2StreamFrame(WebSocketStreamFrame frame, final ChannelPromise promise) {
            if (!firstFrameWritten && !(frame instanceof WebSocketHeaderFrame)) {
                ReferenceCountUtil.release(frame);
                promise.setFailure(
                        new IllegalArgumentException("The first frame must be a headers frame. Was: " + frame.name()));
                return;
            }

            final boolean firstWrite;
            if (firstFrameWritten) {
                firstWrite = false;
            } else {
                firstWrite = firstFrameWritten = true;
            }

            ChannelFuture f = write0(parentContext(), frame);
            if (f.isDone()) {
                if (firstWrite) {
                    firstWriteComplete(f, promise);
                } else {
                    writeComplete(f, promise);
                }
            } else {
                f.addListener((ChannelFutureListener) future -> {
                    if (firstWrite) {
                        firstWriteComplete(future, promise);
                    } else {
                        writeComplete(future, promise);
                    }
                });
                writeDoneAndNoFlush = true;
            }
        }

        private void firstWriteComplete(ChannelFuture future, ChannelPromise promise) {
            Throwable cause = future.cause();
            if (cause == null) {
                promise.setSuccess();
            } else {
                // If the first write fails there is not much we can do, just close
                closeForcibly();
                promise.setFailure(cause);
            }
        }

        private void writeComplete(ChannelFuture future, ChannelPromise promise) {
            Throwable cause = future.cause();
            if (cause == null) {
                promise.setSuccess();
            } else {
                if (cause instanceof IOException) {
                    if (config.isAutoClose()) {
                        // Close channel if needed.
                        closeForcibly();
                    } else {
                        outboundClosed = true;
                    }
                }
                promise.setFailure(cause);
            }
        }

        private WebSocketStreamFrame validateStreamFrame(WebSocketStreamFrame frame) {
            if (frame.stream() != null && frame.stream() != stream) {
                String msgString = frame.toString();
                ReferenceCountUtil.release(frame);
                throw new IllegalArgumentException(
                        "Stream " + frame.stream() + " must not be set on the frame: " + msgString);
            }
            return frame;
        }

        @Override
        public void flush() {
            // If we are currently in the parent channel's read loop we should just ignore the flush.
            // We will ensure we trigger ctx.flush() after we processed all Channels later on and
            // so aggregate the flushes. This is done as ctx.flush() is expensive when as it may trigger an
            // write(...) or writev(...) operation on the socket.
            if (!writeDoneAndNoFlush) {
                // There is nothing to flush so this is a NOOP.
                return;
            }
            // We need to set this to false before we call flush0(...) as ChannelFutureListener may produce more data
            // that are explicit flushed.
            writeDoneAndNoFlush = false;
            flush0(parentContext());
        }

        @Override
        public ChannelPromise voidPromise() {
            return unsafeVoidPromise;
        }

        @Override
        public ChannelOutboundBuffer outboundBuffer() {
            // Always return null as we not use the ChannelOutboundBuffer and not even support it.
            return null;
        }
    }

    protected void flush0(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    protected ChannelFuture write0(ChannelHandlerContext ctx, Object msg) {
        ChannelPromise promise = ctx.newPromise();
        ctx.write(msg, promise);
        return promise;
    }

    protected abstract ChannelHandlerContext parentContext();
}
