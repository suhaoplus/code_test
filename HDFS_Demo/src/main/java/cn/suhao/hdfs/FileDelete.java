package cn.suhao.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class FileDelete {
    public static void main(String[] args)throws Exception {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI(args[0]), conf, "hadoop");
        fs.delete(new Path(args[0]),true);
    }
}
