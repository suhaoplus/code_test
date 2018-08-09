package cn.suhao.hdfs.codec;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

public class Demo1 {
    /**
     * bzip2格式压缩
     * @param args
     */
    public static void main(String[] args) throws Exception{
        String codecClassName = "org.apache.hadoop.io.compress.BZip2Codec";
        String localpath = "/suhao/sogou500w";
        String hdfspath = "hdfs://master:9000/suhao/sogou500w.bz2";
        Class<?> clazz = Class.forName(codecClassName);
        Configuration conf = new Configuration();
        InputStream in = new BufferedInputStream(new FileInputStream(localpath));
        FileSystem fs = FileSystem.get(new URI(hdfspath), conf, "hadoop");
        OutputStream out = fs.create(new Path(hdfspath));

        //获取压缩方式
        CompressionCodec codec = (CompressionCodec) ReflectionUtils.newInstance(clazz, conf);
        //压缩文件
        CompressionOutputStream outputStream = codec.createOutputStream(out);//压缩后的输出流
        //输出
        System.out.println("start...");
        IOUtils.copyBytes(in,outputStream,4096,true);
        System.out.println("successfully!!!!!");
    }
}
