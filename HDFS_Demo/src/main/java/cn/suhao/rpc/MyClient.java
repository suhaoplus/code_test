package cn.suhao.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.net.InetSocketAddress;

public class MyClient {
    public static void main(String[] args) {
        try {
            ClientProtocol proxy = RPC.getProxy(ClientProtocol.class,1L,new InetSocketAddress(MyServer.ADDRESS,MyServer.PORT),new Configuration());
            int result = proxy.add(3,8);
            String s = proxy.echo("helloword");
            System.out.println("s="+s+"，result="+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
