package cn.suhao.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

public class MkdirTest {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(URI.create("hdfs://master:9000/suhao/output"), conf, "hadoop");
            boolean b = fs.mkdirs(new Path("hdfs://master:9000/suhao/output"));
            if (b)
                System.out.println("创建成功！！");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
