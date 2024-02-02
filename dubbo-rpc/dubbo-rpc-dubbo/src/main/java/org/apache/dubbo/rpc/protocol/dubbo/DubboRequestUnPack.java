package org.apache.dubbo.rpc.protocol.dubbo;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.serialize.ObjectInput;
import org.apache.dubbo.common.serialize.Serialization;
import org.apache.dubbo.rpc.model.UnPack;

import java.io.ByteArrayInputStream;

public class DubboRequestUnPack implements UnPack {

    private final URL url;

    private final Class<?>[] pts;

    private final Serialization serialization;

    public DubboRequestUnPack(URL url, Class<?>[] pts, String serializeType) {
        this.url = url;
        this.pts = pts;
        this.serialization = url.getOrDefaultFrameworkModel()
                .getExtensionLoader(Serialization.class)
                .getExtension(serializeType);
    }

    @Override
    public Object unpack(byte[] data) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        final ObjectInput in = serialization.deserialize(url, bais);
        Object[] args = new Object[pts.length];
        for (int i = 0; i < args.length; i++) {
            args[i] = in.readObject(pts[i]);
        }
        return args;
    }
}
