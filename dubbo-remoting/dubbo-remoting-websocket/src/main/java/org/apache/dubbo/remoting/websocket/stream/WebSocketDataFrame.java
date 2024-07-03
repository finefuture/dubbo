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
import io.netty.buffer.Unpooled;

import java.util.Objects;

public class WebSocketDataFrame extends AbstractWebSocketStreamFrame implements WebSocketFrame {

    private final ByteBuf data;

    private final boolean endOfStream;

    public WebSocketDataFrame(boolean endOfStream) {
        this(Unpooled.EMPTY_BUFFER, endOfStream);
    }

    public WebSocketDataFrame(ByteBuf data, boolean endOfStream) {
        this.data = data;
        this.endOfStream = endOfStream;
    }

    public ByteBuf getData() {
        return data;
    }

    public boolean isEndOfStream() {
        return endOfStream;
    }

    @Override
    public String name() {
        return "DATA";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WebSocketDataFrame)) return false;
        if (!super.equals(obj)) return false;
        WebSocketDataFrame dataFrame = (WebSocketDataFrame) obj;
        return endOfStream == dataFrame.endOfStream && Objects.equals(data, dataFrame.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), data, endOfStream);
    }

    @Override
    public String toString() {
        return "WebSocketDataFrame{" + super.toString() + "data=" + data + ", endOfStream=" + endOfStream + '}';
    }
}
