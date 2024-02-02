package org.apache.dubbo.rpc.protocol.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.remoting.utils.UrlUtils;
import org.apache.dubbo.rpc.model.MethodDescriptor;
import org.apache.dubbo.rpc.model.Pack;
import org.apache.dubbo.rpc.model.PackableMethod;
import org.apache.dubbo.rpc.model.UnPack;

public class DubboPackableMethod implements PackableMethod {

    private final Pack requestPack;
    private final Pack responsePack;
    private final UnPack requestUnpack;
    private final UnPack responseUnpack;

    public DubboPackableMethod(MethodDescriptor method, URL url, String serializeName, String deserializeName) {
        boolean singleArgument = method.getRpcType() != MethodDescriptor.RpcType.UNARY;
        this.requestPack = new DubboRequestPack(url, serializeName, singleArgument);
        this.responseUnpack = new DubboResponseUnPack(url, (Class<?>) method.getReturnTypes()[0], deserializeName);

        this.responsePack = new DubboResponsePack(url, serializeName);
        this.requestUnpack = new DubboRequestUnPack(url, method.getParameterClasses(), deserializeName);
    }

    public static DubboPackableMethod init(MethodDescriptor methodDescriptor, URL url, String deserializeName) {
        String serializeName = UrlUtils.serializationOrDefault(url);
        if (StringUtils.isBlank(deserializeName)) {
            deserializeName = serializeName;
        }
        return new DubboPackableMethod(methodDescriptor, url, serializeName, deserializeName);
    }

    @Override
    public Pack getRequestPack() {
        return requestPack;
    }

    @Override
    public Pack getResponsePack() {
        return responsePack;
    }

    @Override
    public UnPack getResponseUnpack() {
        return responseUnpack;
    }

    @Override
    public UnPack getRequestUnpack() {
        return requestUnpack;
    }
}
