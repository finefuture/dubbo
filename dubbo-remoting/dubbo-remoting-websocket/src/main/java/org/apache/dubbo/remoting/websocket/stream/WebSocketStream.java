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

import java.util.Map;

public interface WebSocketStream {

    enum State {
        OPEN(true, true),
        HALF_CLOSED_LOCAL(false, true),
        HALF_CLOSED_REMOTE(true, false),
        CLOSED(false, false);

        private final boolean localSideOpen;
        private final boolean remoteSideOpen;

        State(boolean localSideOpen, boolean remoteSideOpen) {
            this.localSideOpen = localSideOpen;
            this.remoteSideOpen = remoteSideOpen;
        }

        public boolean localSideOpen() {
            return localSideOpen;
        }

        public boolean remoteSideOpen() {
            return remoteSideOpen;
        }
    }

    int id();

    WebSocketStream id(int streamId);

    WebSocketStream activate();

    State state();

    void eos(boolean remote);

    boolean completed();

    <T> T attr(String key);

    <T> WebSocketStream attr(String key, T t);

    WebSocketStream attrs(Map<String, Object> streamAttributes);

    void channel(WebSocketStreamChannel channel);

    WebSocketStreamChannel channel();

    WebSocketStream close();

    WebSocketStream closeLocalSide();

    WebSocketStream closeRemoteSide();
}
