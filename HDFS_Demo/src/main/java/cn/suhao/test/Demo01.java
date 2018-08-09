package cn.suhao.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.InputStream;
import java.net.URI;

public class Demo01 {
    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://master:9000/"), conf, "hadoop");

        InputStream in = fs.open(new Path("hdfs://master:9000/suhao/input/1.txt"));

        int len = 0;

        byte[] b = new byte[256];

        while ((len = in.read(b)) != -1){
            System.out.write(b,0,len);
        }


    }
}
