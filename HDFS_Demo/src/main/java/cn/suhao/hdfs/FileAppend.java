package cn.suhao.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;

public class FileAppend {
    public static void main(String[] args) {
        String localStr = args[0];
        String hdfsStr = args[1];
        Configuration conf = new Configuration();

        try {
            FileSystem fs = FileSystem.get(new URI(hdfsStr), conf, "hadoop");
            InputStream in = new BufferedInputStream(new FileInputStream(localStr));

            FSDataOutputStream out = fs.append(new Path(hdfsStr));

            IOUtils.copyBytes(in,out,1024,true);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭流
        }
    }
}
