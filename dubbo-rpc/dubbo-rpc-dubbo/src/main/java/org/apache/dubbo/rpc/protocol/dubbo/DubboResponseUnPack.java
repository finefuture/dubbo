package org.apache.dubbo.rpc.protocol.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.serialize.ObjectInput;
import org.apache.dubbo.common.serialize.Serialization;
import org.apache.dubbo.rpc.model.UnPack;

import java.io.ByteArrayInputStream;

public class DubboResponseUnPack implements UnPack {

    private final URL url;

    private final Class<?> returnClass;

    private final Serialization serialization;

    public DubboResponseUnPack(URL url, Class<?> returnClass, String serializeType) {
        this.url = url;
        this.returnClass = returnClass;
        this.serialization = url.getOrDefaultFrameworkModel()
                .getExtensionLoader(Serialization.class)
                .getExtension(serializeType);
    }

    @Override
    public Object unpack(byte[] data) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        final ObjectInput in = serialization.deserialize(url, bais);
        return in.readObject(returnClass);
    }
}
