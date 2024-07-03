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

import org.apache.dubbo.remoting.websocket.stream.CompositeWebSocketFrameWriter.CompositeDefaultWebSocketFrameWriter;

import io.netty.handler.codec.http2.DefaultHttp2HeadersDecoder;
import io.netty.handler.codec.http2.DefaultHttp2HeadersEncoder;

public class WebSocketFrameCodecBuilder {

    private final boolean server;

    private WebSocketFrameReader reader;

    private WebSocketFrameWriter writer;

    public WebSocketFrameCodecBuilder(boolean server, WebSocketFrameReader reader, WebSocketFrameWriter writer) {
        this.server = server;
        this.reader = reader;
        this.writer = writer;
    }

    public static WebSocketFrameCodecBuilder forClient() {
        return new WebSocketFrameCodecBuilder(
                false,
                new DefaultWebSocketFrameReader(new DefaultHttp2HeadersDecoder()),
                new DefaultWebSocketFrameWriter(new DefaultHttp2HeadersEncoder()));
    }

    public static WebSocketFrameCodecBuilder forServer() {
        return new WebSocketFrameCodecBuilder(
                true,
                new DefaultWebSocketFrameReader(new DefaultHttp2HeadersDecoder()),
                new DefaultWebSocketFrameWriter(new DefaultHttp2HeadersEncoder()));
    }

    public WebSocketFrameCodecBuilder combination() {
        this.reader = new CompositeWebSocketFrameReader(
                new DefaultWebSocketFrameReader(new DefaultHttp2HeadersDecoder()),
                new CombinationWebSocketFrameReader(new DefaultHttp2HeadersDecoder()));
        this.writer = new CompositeWebSocketFrameWriter(
                new CompositeDefaultWebSocketFrameWriter(new DefaultHttp2HeadersEncoder()),
                new CombinationWebSocketFrameWriter(new DefaultHttp2HeadersEncoder()));
        return this;
    }

    public WebSocketFrameCodecBuilder reader(WebSocketFrameReader reader) {
        this.reader = reader;
        return this;
    }

    public WebSocketFrameCodecBuilder writer(WebSocketFrameWriter writer) {
        this.writer = writer;
        return this;
    }

    public WebSocketStreamFrameCodec build() {
        return new WebSocketStreamFrameCodec(server, reader, writer);
    }
}
