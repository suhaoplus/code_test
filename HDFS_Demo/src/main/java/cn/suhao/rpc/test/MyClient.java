package cn.suhao.rpc.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.net.InetSocketAddress;

public class MyClient {
    public static void main(String[] args) {
        try {
            ClientProtocol protocol = RPC.getProxy(ClientProtocol.class,1L,new InetSocketAddress(MyServer.ADDRESS,MyServer.PORT),new Configuration());

            int i = protocol.add(3,8);
            System.out.println(i);
            protocol.echo("hhhhhhhhh");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
