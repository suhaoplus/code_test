package cn.suhao.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

public class FileStatusTest {
    public static void main(String[] args) {
        String path = "hdfs://master:9000/suhao/input";
        Configuration conf = new Configuration();
        try {
            FileSystem fs = FileSystem.get(URI.create(path), conf, "hadoop");
            boolean b = fs.exists(new Path(path));
            if (b){
                FileStatus fileStatus = fs.getFileStatus(new Path(path));
                FileStatus[] status = {fileStatus};
                Path[] paths = FileUtil.stat2Paths(status);
                for (int i = 0;i < paths.length;i++){
                    System.out.println(paths[i]);
                    System.out.println(paths[i].getName());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
