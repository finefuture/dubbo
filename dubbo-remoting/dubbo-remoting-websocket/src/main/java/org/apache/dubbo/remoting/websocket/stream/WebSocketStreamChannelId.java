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

import io.netty.channel.ChannelId;

public class WebSocketStreamChannelId implements ChannelId {

    private final int id;
    private final ChannelId parentId;

    WebSocketStreamChannelId(ChannelId parentId, int id) {
        this.parentId = parentId;
        this.id = id;
    }

    @Override
    public String asShortText() {
        return parentId.asShortText() + '/' + id;
    }

    @Override
    public String asLongText() {
        return parentId.asLongText() + '/' + id;
    }

    @Override
    public int compareTo(ChannelId o) {
        if (o instanceof WebSocketStreamChannelId) {
            WebSocketStreamChannelId otherId = (WebSocketStreamChannelId) o;
            int res = parentId.compareTo(otherId.parentId);
            if (res == 0) {
                return id - otherId.id;
            } else {
                return res;
            }
        }
        return parentId.compareTo(o);
    }

    @Override
    public int hashCode() {
        return id * 31 + parentId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof WebSocketStreamChannelId)) {
            return false;
        }
        WebSocketStreamChannelId otherId = (WebSocketStreamChannelId) obj;
        return id == otherId.id && parentId.equals(otherId.parentId);
    }

    @Override
    public String toString() {
        return asShortText();
    }
}
