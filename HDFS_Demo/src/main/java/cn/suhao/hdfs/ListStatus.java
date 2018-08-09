package cn.suhao.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

public class ListStatus {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String uri = args[0];
            FileSystem fs = FileSystem.get(new URI(uri), conf, "hadoop");
            list(fs,new Path(uri));
    }
    private static void list(FileSystem fs,Path path) throws Exception{
        FileStatus[] fileStatuses = fs.listStatus(path);
        for (FileStatus f : fileStatuses){
            Path p = f.getPath();
            if (f.isDirectory()){
                System.out.println(p+":文件夹");
                list(fs,p);
            }else {
                System.out.println(p+":文件");
            }
        }
    }
}
