package org.apache.dubbo.rpc.protocol.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.serialize.ObjectOutput;
import org.apache.dubbo.common.serialize.Serialization;
import org.apache.dubbo.rpc.model.Pack;

import java.io.ByteArrayOutputStream;

public class DubboRequestPack implements Pack {

    private final URL url;

    private final boolean singleArgument;

    private final Serialization serialization;

    public DubboRequestPack(URL url, String serializeType, boolean singleArgument) {
        this.singleArgument = singleArgument;
        this.url = url;
        this.serialization = url.getOrDefaultFrameworkModel()
                .getExtensionLoader(Serialization.class)
                .getExtension(serializeType);
    }

    @Override
    public byte[] pack(Object obj) throws Exception {
        Object[] arguments;
        if (singleArgument) {
            arguments = new Object[] {obj};
        } else {
            arguments = (Object[]) obj;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final ObjectOutput serialize = serialization.serialize(url, bos);
        for (Object argument : arguments) {
            serialize.writeObject(argument);
        }
        serialize.flushBuffer();
        return bos.toByteArray();
    }
}
