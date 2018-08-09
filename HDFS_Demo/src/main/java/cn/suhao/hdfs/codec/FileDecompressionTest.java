package cn.suhao.hdfs.codec;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.CompressionInputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

public class FileDecompressionTest {
    public static void main(String[] args) throws Exception{
        String uri = args[0];
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI(uri), conf, "hadoop");
        Path path = new Path(uri);
        CompressionCodecFactory factory = new CompressionCodecFactory(conf);
        CompressionCodec codec = factory.getCodec(path);
        if (codec == null){
            System.exit(-1);
        }
        String outuri = CompressionCodecFactory.removeSuffix(uri, codec.getDefaultExtension());
        System.out.println(outuri);
        InputStream in = codec.createInputStream(fs.open(path));
        OutputStream out = fs.create(new Path(outuri + "ang"));
        IOUtils.copyBytes(in,out,4096,false);
        IOUtils.closeStream(in);
        IOUtils.closeStream(out);


    }
}
