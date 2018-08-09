package cn.suhao.hdfs.serializable;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;

public class Demo09 {
    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.getLocal(conf);
        Path path = new Path("/suhao/ss.txt");
        SequenceFile.Reader reader = null;

        reader = new SequenceFile.Reader(fs,path,conf);

        Writable key = (Writable) ReflectionUtils.newInstance(reader.getKeyClass(),conf);
        Writable value = (Writable)ReflectionUtils.newInstance(reader.getValueClass(),conf);

        long position = reader.getPosition();
        while (reader.next(key,value)){
            String syneen= reader.syncSeen()?"*":"";
            System.out.printf("[%s%s]\t%s\t%s\n",position,syneen,key,value);
            position = reader.getPosition();
        }

        IOUtils.closeStream(reader);
    }
}
