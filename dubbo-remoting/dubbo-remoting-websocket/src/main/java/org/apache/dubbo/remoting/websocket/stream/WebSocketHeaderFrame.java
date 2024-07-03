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

import io.netty.handler.codec.http2.DefaultHttp2Headers;
import io.netty.handler.codec.http2.Http2Headers;

import java.util.Objects;

public class WebSocketHeaderFrame extends AbstractWebSocketStreamFrame implements WebSocketFrame {

    private final Http2Headers headers;

    private final boolean endOfStream;

    public WebSocketHeaderFrame() {
        this(new DefaultHttp2Headers());
    }

    public WebSocketHeaderFrame(boolean endOfStream) {
        this(new DefaultHttp2Headers(), endOfStream);
    }

    public WebSocketHeaderFrame(Http2Headers headers) {
        this(headers, false);
    }

    public WebSocketHeaderFrame(Http2Headers headers, boolean endOfStream) {
        this.headers = headers;
        this.endOfStream = endOfStream;
    }

    @Override
    public String name() {
        return "HEADER";
    }

    public Http2Headers getHeaders() {
        return headers;
    }

    public boolean isEndOfStream() {
        return endOfStream;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WebSocketHeaderFrame)) return false;
        if (!super.equals(obj)) return false;
        WebSocketHeaderFrame that = (WebSocketHeaderFrame) obj;
        return endOfStream == that.endOfStream && Objects.equals(headers, that.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), headers, endOfStream);
    }

    @Override
    public String toString() {
        return "WebSocketHeaderFrame{" + super.toString() + "headers=" + headers + ", endOfStream=" + endOfStream + '}';
    }
}
