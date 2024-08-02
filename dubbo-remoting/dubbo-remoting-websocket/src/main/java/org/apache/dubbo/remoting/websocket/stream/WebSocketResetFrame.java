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

import java.util.Objects;

public class WebSocketResetFrame extends AbstractWebSocketStreamFrame implements WebSocketFrame {

    private final long errorCode;

    public WebSocketResetFrame(long errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String name() {
        return "RST";
    }

    public long errorCode() {
        return errorCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WebSocketResetFrame)) return false;
        if (!super.equals(obj)) return false;
        WebSocketResetFrame that = (WebSocketResetFrame) obj;
        return errorCode == that.errorCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), errorCode);
    }

    @Override
    public String toString() {
        return "WebSocketResetFrame{" + super.toString() + "errorCode=" + errorCode + '}';
    }
}
