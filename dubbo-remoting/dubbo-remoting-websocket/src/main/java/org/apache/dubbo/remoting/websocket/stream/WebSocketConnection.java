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

import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;

public interface WebSocketConnection extends WebSocketStreamLifecycleManager {

    interface Listener {

        void onStreamAdded(WebSocketStream stream);

        void onStreamActivate(WebSocketStream stream);

        void onStreamHalfClosed(WebSocketStream stream);

        void onStreamClosed(WebSocketStream stream);

        void onStreamRemoved(WebSocketStream stream);
    }

    int newStreamId();

    int lastCreatedStream();

    boolean mayHaveCreatedStream(int streamId);

    WebSocketStream stream(int streamId);

    WebSocketStream createStream(int streamId);

    void activateStream(WebSocketStream stream);

    Future<Void> close(Promise<Void> promise);

    int numActiveStreams();

    void addListener(Listener listener);

    void removeListener(Listener listener);
}
