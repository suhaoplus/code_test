package cn.suhao.rpc.test;

import org.apache.hadoop.ipc.ProtocolSignature;

import java.io.IOException;

public class ClientProtocolImpl implements ClientProtocol {
    @Override
    public int add(int v1, int v2) throws Exception {
        return v1+v2;
    }

    @Override
    public void echo(String value) throws Exception {
        System.out.println(value);
    }

    @Override
    public long getProtocolVersion(String s, long l) throws IOException {
        return versionID;
    }

    @Override
    public ProtocolSignature getProtocolSignature(String s, long l, int i) throws IOException {
        return null;
    }
}
