package cn.suhao.rpc.test;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface ClientProtocol extends VersionedProtocol{
    public static final long versionID = 1L;

    public int add(int v1,int v2) throws Exception;

    public void echo(String value) throws Exception;

}
