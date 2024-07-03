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

import org.apache.dubbo.remoting.websocket.stream.WebSocketConnection.Listener;
import org.apache.dubbo.remoting.websocket.stream.WebSocketFrameStreamEvent.EventType;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http2.DefaultHttp2GoAwayFrame;
import io.netty.handler.codec.http2.Http2Headers;

import static org.apache.dubbo.remoting.websocket.stream.StreamIdGenerator.isStreamIdValid;
import static org.apache.dubbo.remoting.websocket.stream.WebSocketError.NO_MORE_STREAM;

public class WebSocketStreamFrameCodec extends WebSocketConnectionHandler {

    private final WebSocketFrameReader reader;

    private final WebSocketFrameWriter writer;

    private ChannelHandlerContext ctx;

    public WebSocketStreamFrameCodec(boolean server, WebSocketFrameReader reader, WebSocketFrameWriter writer) {
        super(server);
        this.reader = reader;
        this.writer = writer;
    }

    public WebSocketFrameReader reader() {
        return reader;
    }

    public WebSocketFrameWriter writer() {
        return writer;
    }

    @Override
    protected void handlerAdded0(ChannelHandlerContext ctx) {
        this.ctx = ctx;
        reader().frameListener(new DefaultFrameListener());
        reader().connection(connection());
        writer().connection(connection());
        connection().addListener(new DefaultConnectionListener());
    }

    WebSocketStream newStream() {
        return connection().createStream(-1);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof BinaryWebSocketFrame) {
            reader().readFrame(ctx, ((BinaryWebSocketFrame) msg).content());
        } else if (msg instanceof CloseWebSocketFrame) {
            CloseWebSocketFrame closeWebSocketFrame = (CloseWebSocketFrame) msg;
            super.channelRead(
                    ctx, new DefaultHttp2GoAwayFrame(closeWebSocketFrame.statusCode(), closeWebSocketFrame.content()));
        } else {
            super.channelRead(ctx, msg);
        }
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof WebSocketDataFrame) {
            WebSocketDataFrame dataFrame = (WebSocketDataFrame) msg;
            writer().writeData(ctx, dataFrame.stream().id(), dataFrame.getData(), dataFrame.isEndOfStream(), promise);
        } else if (msg instanceof WebSocketHeaderFrame) {
            writeHeadersFrame(ctx, (WebSocketHeaderFrame) msg, promise);
        } else if (msg instanceof WebSocketResetFrame) {
            WebSocketResetFrame resetFrame = (WebSocketResetFrame) msg;
            writer().writeRstStream(ctx, resetFrame.stream().id(), resetFrame.errorCode(), promise);
        } else {
            super.write(ctx, msg, promise);
        }
    }

    private void writeHeadersFrame(
            final ChannelHandlerContext ctx, WebSocketHeaderFrame headerFrame, ChannelPromise promise) {
        if (isStreamIdValid(headerFrame.stream().id())) {
            writer().writeHeaders(
                            ctx,
                            headerFrame.stream().id(),
                            headerFrame.getHeaders(),
                            headerFrame.isEndOfStream(),
                            promise);
        } else if (initializeNewStream(ctx, headerFrame.stream(), promise)) {
            promise = promise.unvoid();
            writer().writeHeaders(
                            ctx,
                            headerFrame.stream().id(),
                            headerFrame.getHeaders(),
                            headerFrame.isEndOfStream(),
                            promise);
        }
    }

    private boolean initializeNewStream(ChannelHandlerContext ctx, WebSocketStream stream, ChannelPromise promise) {
        final int streamId = connection().newStreamId();
        if (streamId < 0) {
            promise.setFailure(
                    new WebSocketStreamException(streamId, 500, "No more streams can be created on this connection"));
            onWebSocketFrame(ctx, new WebSocketResetFrame(NO_MORE_STREAM.code()));
            return false;
        }
        stream.id(streamId).activate();
        return true;
    }

    private final class DefaultFrameListener implements WebSocketFrameListener {

        @Override
        public void onDataRead(ChannelHandlerContext ctx, int streamId, ByteBuf data, boolean endOfStream) {
            WebSocketStream stream = connection().stream(streamId);
            onWebSocketFrame(ctx, new WebSocketDataFrame(data, endOfStream).stream(stream));
            if (endOfStream) {
                connection().closeStreamRemote(stream, ctx.newSucceededFuture());
            }
        }

        @Override
        public void onHeadersRead(ChannelHandlerContext ctx, int streamId, Http2Headers headers, boolean endOfStream) {
            WebSocketStream stream = connection().stream(streamId);
            if (stream == null) {
                stream = connection().createStream(streamId).activate();
            }
            onWebSocketFrame(ctx, new WebSocketHeaderFrame(headers, endOfStream).stream(stream));
            if (endOfStream) {
                connection().closeStreamRemote(stream, ctx.newSucceededFuture());
            }
        }

        @Override
        public void onRstStreamRead(ChannelHandlerContext ctx, int streamId, long errorCode) {
            WebSocketStream stream = connection().stream(streamId);
            onWebSocketFrame(ctx, (WebSocketResetFrame) new WebSocketResetFrame(errorCode).stream(stream));
            connection().closeStream(stream, ctx.newSucceededFuture());
        }
    }

    void onWebSocketFrame(ChannelHandlerContext ctx, WebSocketStreamFrame dataFrame) {
        ctx.fireChannelRead(dataFrame);
    }

    void onWebSocketFrame(ChannelHandlerContext ctx, WebSocketResetFrame dataFrame) {
        ctx.fireUserEventTriggered(dataFrame);
    }

    private final class DefaultConnectionListener implements Listener {

        @Override
        public void onStreamAdded(WebSocketStream stream) {
            ctx.fireUserEventTriggered(new WebSocketFrameStreamEvent(stream, EventType.ADDED));
        }

        @Override
        public void onStreamActivate(WebSocketStream stream) {
            ctx.fireUserEventTriggered(new WebSocketFrameStreamEvent(stream, EventType.ACTIVATE));
        }

        @Override
        public void onStreamHalfClosed(WebSocketStream stream) {
            ctx.fireUserEventTriggered(new WebSocketFrameStreamEvent(stream, EventType.HALF_CLOSED));
        }

        @Override
        public void onStreamClosed(WebSocketStream stream) {
            ctx.fireUserEventTriggered(new WebSocketFrameStreamEvent(stream, EventType.CLOSED));
        }

        @Override
        public void onStreamRemoved(WebSocketStream stream) {
            ctx.fireUserEventTriggered(new WebSocketFrameStreamEvent(stream, EventType.REMOVED));
        }
    }
}
