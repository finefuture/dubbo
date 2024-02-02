package org.apache.dubbo.rpc.protocol.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.serialize.ObjectOutput;
import org.apache.dubbo.common.serialize.Serialization;
import org.apache.dubbo.rpc.model.Pack;

import java.io.ByteArrayOutputStream;

public class DubboResponsePack implements Pack {

    private final URL url;

    private final Serialization serialization;

    public DubboResponsePack(URL url, String serializeType) {
        this.serialization = url.getOrDefaultFrameworkModel()
                .getExtensionLoader(Serialization.class)
                .getExtension(serializeType);
        this.url = url;
    }

    @Override
    public byte[] pack(Object obj) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final ObjectOutput serialize = serialization.serialize(url, bos);
        serialize.writeObject(obj);
        serialize.flushBuffer();
        return bos.toByteArray();
    }
}
