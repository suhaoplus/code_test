package cn.suhao.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.InputStream;
import java.net.URI;

public class ReadFile {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        String uri = args[0];
        try {
            FileSystem fs = FileSystem.get(new URI(uri), conf, "zkpk");
            InputStream in = fs.open(new Path(uri));
            int len = 0;
            byte[] b = new byte[265];
            while ((len = in.read(b))>=0){
                System.out.write(b,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
