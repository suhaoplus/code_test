package cn.suhao.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.net.URI;

public class ListAll {
    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://master:9000/suhao/"), conf, "hadoop");
        RemoteIterator<LocatedFileStatus> files =  fs.listFiles(new Path("/suhao/"),true);
        while (files.hasNext()){
            LocatedFileStatus file = files.next();
            Path filePath = file.getPath();
            String fileName = filePath.getName();
            System.out.println(fileName);
        }
        System.out.println("----------------------");
        FileStatus[] fileStatus = fs.listStatus(new Path("hdfs://master:9000/suhao/"));//列出当前目录下的文件和文件夹
        for (FileStatus f : fileStatus){
            String name = f.getPath().getName();
            System.out.println(name + (f.isDirectory()?"是文件夹":"是文件"));
        }
    }


}
