package org.apache.dubbo.rpc.protocol.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.model.MethodDescriptor;
import org.apache.dubbo.rpc.model.PackableMethod;
import org.apache.dubbo.rpc.model.PackableMethodFactory;

public class DubboPackableMethodFactory implements PackableMethodFactory {

    @Override
    public PackableMethod create(MethodDescriptor methodDescriptor, URL url, String contentType) {
        return DubboPackableMethod.init(methodDescriptor, url, contentType);
    }
}
