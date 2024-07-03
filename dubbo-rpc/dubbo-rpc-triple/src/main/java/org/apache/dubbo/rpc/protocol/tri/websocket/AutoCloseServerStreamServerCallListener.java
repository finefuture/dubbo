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
package org.apache.dubbo.rpc.protocol.tri.websocket;

import org.apache.dubbo.common.stream.StreamObserver;
import org.apache.dubbo.remoting.http12.message.StreamingDecoder;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcInvocation;
import org.apache.dubbo.rpc.protocol.tri.h12.ServerStreamServerCallListener;

public class AutoCloseServerStreamServerCallListener extends ServerStreamServerCallListener {

    private final StreamingDecoder streamingDecoder;

    public AutoCloseServerStreamServerCallListener(
            RpcInvocation invocation,
            Invoker<?> invoker,
            StreamObserver<Object> responseObserver,
            StreamingDecoder streamingDecoder) {
        super(invocation, invoker, responseObserver);
        this.streamingDecoder = streamingDecoder;
    }

    @Override
    public void onMessage(Object message) {
        super.onMessage(message);
        streamingDecoder.close();
    }
}
