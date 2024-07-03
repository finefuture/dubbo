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

import org.apache.dubbo.common.logger.ErrorTypeAwareLogger;
import org.apache.dubbo.common.logger.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.netty.channel.ChannelFuture;
import io.netty.util.collection.IntObjectHashMap;
import io.netty.util.collection.IntObjectMap;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;

import static io.netty.util.internal.ObjectUtil.checkNotNull;
import static org.apache.dubbo.remoting.websocket.stream.StreamIdGenerator.isStreamIdValid;
import static org.apache.dubbo.remoting.websocket.stream.WebSocketStream.State.CLOSED;
import static org.apache.dubbo.remoting.websocket.stream.WebSocketStream.State.HALF_CLOSED_LOCAL;
import static org.apache.dubbo.remoting.websocket.stream.WebSocketStream.State.HALF_CLOSED_REMOTE;
import static org.apache.dubbo.remoting.websocket.stream.WebSocketStream.State.OPEN;

public class DefaultWebSocketConnection implements WebSocketConnection {

    private static final ErrorTypeAwareLogger logger =
            LoggerFactory.getErrorTypeAwareLogger(DefaultWebSocketConnection.class);

    private final IntObjectMap<WebSocketStream> streamMap = new IntObjectHashMap<>();

    private final List<Listener> listeners = new ArrayList<>();

    private final StreamIdGenerator streamIdGenerator;

    private final boolean server;

    private int lastCreatedStreamId;

    private Promise<Void> closePromise;

    public DefaultWebSocketConnection(StreamIdGenerator streamIdGenerator, boolean server) {
        this.streamIdGenerator = streamIdGenerator;
        this.server = server;
    }

    @Override
    public int newStreamId() {
        return streamIdGenerator.newStreamId();
    }

    @Override
    public int lastCreatedStream() {
        return lastCreatedStreamId;
    }

    @Override
    public boolean mayHaveCreatedStream(int streamId) {
        return streamId <= lastCreatedStream();
    }

    @Override
    public WebSocketStream stream(int streamId) {
        return streamMap.get(streamId);
    }

    @Override
    public WebSocketStream createStream(int streamId) {
        checkNewStreamAllowed(streamId);
        WebSocketStream stream = new DefaultWebSocketStream(streamId);
        if (isStreamIdValid(streamId)) {
            addStream(stream);
        }
        return stream;
    }

    @Override
    public void activateStream(WebSocketStream stream) {
        if (stream(stream.id()) == null) {
            addStream(stream);
        }
        streamActivated(stream);
    }

    @Override
    public Future<Void> close(Promise<Void> promise) {
        checkNotNull(promise, "promise");
        if (closePromise == null) {
            closePromise = promise;
        }
        if (numActiveStreams() == 0) {
            promise.trySuccess(null);
            return promise;
        }
        Iterator<WebSocketStream> itr = streamMap.values().iterator();
        while (itr.hasNext()) {
            DefaultWebSocketStream stream = (DefaultWebSocketStream) itr.next();
            stream.close(itr);
        }
        closePromise.trySuccess(null);
        return closePromise;
    }

    @Override
    public int numActiveStreams() {
        return streamMap.size();
    }

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    private void addStream(WebSocketStream stream) {
        streamMap.put(stream.id(), stream);
        lastCreatedStreamId = stream.id();
        notifyAdded(stream);
    }

    private void streamActivated(WebSocketStream stream) {
        if (server) {
            notifyActivated(stream);
        }
    }

    private void removeStream(WebSocketStream stream, Iterator<WebSocketStream> itr) {
        if (itr == null) {
            if (streamMap.remove(stream.id()) == null) {
                return;
            }
        } else {
            itr.remove();
        }
        notifyRemoved(stream);
        if (closePromise != null && isStreamMapEmpty()) {
            closePromise.trySuccess(null);
        }
    }

    private boolean isStreamMapEmpty() {
        return streamMap.size() == 0;
    }

    private boolean isClosed() {
        return closePromise != null;
    }

    private void checkNewStreamAllowed(int streamId) {
        if (isClosed()) {
            throw new WebSocketStreamException(
                    streamId,
                    500,
                    String.format("Attempted to create stream id %d after connection was closed", streamId));
        }
    }

    @Override
    public void closeStreamLocal(WebSocketStream stream, ChannelFuture future) {
        stream.eos(false);
        switch (stream.state()) {
            case HALF_CLOSED_LOCAL:
            case OPEN:
                stream.closeLocalSide();
                break;
            default:
                closeStream(stream, future);
                break;
        }
    }

    @Override
    public void closeStreamRemote(WebSocketStream stream, ChannelFuture future) {
        stream.eos(true);
        switch (stream.state()) {
            case HALF_CLOSED_REMOTE:
            case OPEN:
                stream.closeRemoteSide();
                break;
            default:
                closeStream(stream, future);
                break;
        }
    }

    @Override
    public void closeStream(WebSocketStream stream, ChannelFuture future) {
        if (future.isDone()) {
            stream.close();
        } else {
            future.addListener(f -> stream.close());
        }
    }

    void notifyAdded(WebSocketStream stream) {
        for (int i = 0; i < listeners.size(); i++) {
            try {
                listeners.get(i).onStreamAdded(stream);
            } catch (Throwable cause) {
                logger.error("Caught Throwable from listener onStreamHalfClosed.", cause);
            }
        }
    }

    void notifyActivated(WebSocketStream stream) {
        for (int i = 0; i < listeners.size(); i++) {
            try {
                listeners.get(i).onStreamActivate(stream);
            } catch (Throwable cause) {
                logger.error("Caught Throwable from listener onStreamHalfClosed.", cause);
            }
        }
    }

    void notifyHalfClosed(WebSocketStream stream) {
        for (int i = 0; i < listeners.size(); i++) {
            try {
                listeners.get(i).onStreamHalfClosed(stream);
            } catch (Throwable cause) {
                logger.error("Caught Throwable from listener onStreamHalfClosed.", cause);
            }
        }
    }

    void notifyClosed(WebSocketStream stream) {
        for (int i = 0; i < listeners.size(); i++) {
            try {
                listeners.get(i).onStreamClosed(stream);
            } catch (Throwable cause) {
                logger.error("Caught Throwable from listener onStreamClosed.", cause);
            }
        }
    }

    void notifyRemoved(WebSocketStream stream) {
        for (int i = 0; i < listeners.size(); i++) {
            try {
                listeners.get(i).onStreamRemoved(stream);
            } catch (Throwable cause) {
                logger.error("Caught Throwable from listener onStreamClosed.", cause);
            }
        }
    }

    public class DefaultWebSocketStream implements WebSocketStream {

        private int id;

        private final Map<String, Object> attributeMap = new HashMap<>();

        private WebSocketStreamChannel channel;

        private State state;

        private boolean receivedEndOfStream;

        private boolean sentEndOfStream;

        public DefaultWebSocketStream(int id) {
            this.id = id;
            this.state = OPEN;
        }

        @Override
        public int id() {
            return id;
        }

        @Override
        public WebSocketStream id(int streamId) {
            this.id = streamId;
            return this;
        }

        @Override
        public WebSocketStream activate() {
            activateStream(this);
            return this;
        }

        @Override
        public State state() {
            return state;
        }

        @Override
        public void eos(boolean remote) {
            if (remote) {
                receivedEndOfStream = true;
            } else {
                sentEndOfStream = true;
            }
        }

        @Override
        public boolean completed() {
            return receivedEndOfStream && sentEndOfStream;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T> T attr(String key) {
            return (T) attributeMap.get(key);
        }

        @Override
        public <T> WebSocketStream attr(String key, T t) {
            attributeMap.put(key, t);
            return this;
        }

        @Override
        public WebSocketStream attrs(Map<String, Object> streamAttributes) {
            if (streamAttributes != null && !streamAttributes.isEmpty()) {
                attributeMap.putAll(streamAttributes);
            }
            return this;
        }

        @Override
        public void channel(WebSocketStreamChannel channel) {
            this.channel = channel;
        }

        @Override
        public WebSocketStreamChannel channel() {
            return channel;
        }

        @Override
        public WebSocketStream close() {
            close(null);
            attributeMap.clear();
            channel = null;
            return this;
        }

        WebSocketStream close(Iterator<WebSocketStream> itr) {
            if (state == CLOSED) {
                return this;
            }
            state = CLOSED;
            notifyClosed(this);
            removeStream(this, itr);
            return this;
        }

        @Override
        public WebSocketStream closeLocalSide() {
            switch (state) {
                case OPEN:
                    state = HALF_CLOSED_LOCAL;
                    notifyHalfClosed(this);
                    break;
                case HALF_CLOSED_LOCAL:
                    break;
                default:
                    close();
                    break;
            }
            return this;
        }

        @Override
        public WebSocketStream closeRemoteSide() {
            switch (state) {
                case OPEN:
                    state = HALF_CLOSED_REMOTE;
                    notifyHalfClosed(this);
                    break;
                case HALF_CLOSED_REMOTE:
                    break;
                default:
                    close();
                    break;
            }
            return this;
        }

        @Override
        public String toString() {
            return "DefaultWebSocketStream{" + "id=" + id + ", attributeMap=" + attributeMap + '}';
        }
    }
}
