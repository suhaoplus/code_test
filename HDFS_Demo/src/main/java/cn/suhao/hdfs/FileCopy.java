package cn.suhao.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

public class FileCopy {
    public static void main(String[] args) {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream("/suhao/student.json"));
            Configuration conf = new Configuration();
            FileSystem fs = FileSystem.get(URI.create("hdfs://master:9000/suhao/input/student.json"), conf,"hadoop");
            FSDataOutputStream out = fs.create(new Path("hdfs://master:9000/suhao/input/student.json"));
            IOUtils.copyBytes(in,out,1024,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
