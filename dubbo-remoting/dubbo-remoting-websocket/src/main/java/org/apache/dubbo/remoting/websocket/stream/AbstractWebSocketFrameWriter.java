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

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;

import static org.apache.dubbo.remoting.websocket.WebSocketConstants.MAX_UNSIGNED_INT;

public abstract class AbstractWebSocketFrameWriter extends DefaultWebSocketConnectionHolder
        implements WebSocketFrameWriter {

    @Override
    public ChannelFuture writeRstStream(
            ChannelHandlerContext ctx, int streamId, long errorCode, ChannelPromise promise) {
        try {
            verifyErrorCode(errorCode);
            ByteBuf buf = ctx.alloc().buffer();
            writeFrameHeaderInternal(buf, WebSocketFrameType.RST_STREAM, streamId);
            buf.writeInt((int) errorCode);
            return ctx.write(new BinaryWebSocketFrame(buf), promise);
        } catch (Exception e) {
            return promise.setFailure(e);
        }
    }

    protected void writeFrameHeaderInternal(ByteBuf out, byte type, int streamId) {
        out.writeInt(streamId);
        out.writeByte(type);
    }

    private void verifyErrorCode(long errorCode) {
        if (errorCode < 0 || errorCode > MAX_UNSIGNED_INT) {
            throw new IllegalArgumentException("Invalid errorCode: " + errorCode);
        }
    }
}
