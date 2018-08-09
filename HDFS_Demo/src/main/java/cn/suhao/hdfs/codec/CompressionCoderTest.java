package cn.suhao.hdfs.codec;

import org.apache.hadoop.conf.Configuration;
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

public class CompressionCoderTest {
    public static void main(String[] args) throws Exception{
        String codeClassName = "org.apache.hadoop.io.compress.GzipCodec";
        String localPath = "/suhao/sogou500w";
        String hdfsPath = "hdfs://master:9000/sogou500w.gz";
        Class<?> clazz = Class.forName(codeClassName);
        Configuration conf = new Configuration();
        CompressionCodec condec = (CompressionCodec)ReflectionUtils.newInstance(clazz, conf);
        InputStream in = new BufferedInputStream(new FileInputStream(localPath));
        FileSystem fs = FileSystem.get(new URI(hdfsPath), conf, "hadoop");
        OutputStream out = fs.create(new Path(hdfsPath));
        CompressionOutputStream outputStream = condec.createOutputStream(out);
        IOUtils.copyBytes(in,outputStream,4096,true);
        System.out.println("压缩上传成功");
    }
}
