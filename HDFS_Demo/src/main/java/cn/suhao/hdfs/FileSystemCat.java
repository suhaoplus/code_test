package cn.suhao.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;

public class FileSystemCat {
    public static void main(String[] args) {
        String uri = args[0];
        Configuration conf = new Configuration();
        InputStream in = null;
        try {
            FileSystem fs = FileSystem.get(new URI(uri), conf, "hadoop");
            in = fs.open(new Path(uri));

            FileOutputStream fos = new FileOutputStream("/suhao/a.txt");

            byte[] b = new byte[1024];
            int n = 0;
            while ((n = in.read(b))!=-1){
                fos.write(b,0,n);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeStream(in);
        }
    }
}
