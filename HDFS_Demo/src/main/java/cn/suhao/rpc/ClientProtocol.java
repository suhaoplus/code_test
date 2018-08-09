package cn.suhao.rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface ClientProtocol extends VersionedProtocol{
    public static final long versionID = 1L;
    public String echo(String value) throws Exception;
    public int add(int v1,int v2) throws Exception;
}
