package cn.suhao.hdfs.serializable;

import org.apache.hadoop.io.IntWritable;

import java.io.*;

public class Demo05 {
    public static void main(String[] args) throws Exception{
        IntWritable one = new IntWritable(97);
        OutputStream out = new FileOutputStream("/suhao/one.txt");
        DataOutputStream os = new DataOutputStream(out);
        one.write(os);

        InputStream in = new FileInputStream("/suhao/one.txt");
        DataInputStream dis = new DataInputStream(in);
        IntWritable tow = new IntWritable();
        tow.readFields(dis);
        System.out.println(tow.get());
    }
}
