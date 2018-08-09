package cn.suhao.rpc;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

import java.io.IOException;

public class MyServer {
    public static final String ADDRESS = "localhost";
    public static final int PORT  = 2454;

    public static void main(String[] args) {
        try {
            final Server server = new RPC.Builder(new Configuration()).setProtocol(ClientProtocol.class).setInstance(new ClientProtocolImpl()).setBindAddress(ADDRESS).setPort(PORT).setNumHandlers(5).build();
            System.out.println("start.....");
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
