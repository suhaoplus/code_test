package cn.suhao.hdfs.codec;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

public class Demo2{
    /**
     * bz2格式解压
     * @param args
     */
    public static void main(String[] args) throws Exception{
        String hdfspath = "hdfs://master:9000/suhao/sogou500w.bz2";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI(hdfspath),conf,"hadoop");
        Path path = new Path(hdfspath);
        //得到压缩项
        CompressionCodecFactory factory = new CompressionCodecFactory(conf);
        CompressionCodec codec = factory.getCodec(path);

        //返回解压路径
        String outpath = CompressionCodecFactory.removeSuffix(hdfspath, codec.getDefaultExtension());
        System.out.println(outpath);

        //得到输入流
        InputStream in = codec.createInputStream(fs.open(path));

        //创建解压后输出流
        OutputStream out = fs.create(new Path(outpath + "aaaaaa"));

        System.out.println("start.......");

        IOUtils.copyBytes(in,out,4096,false);
        System.out.println("successfully！！！");



    }

}
