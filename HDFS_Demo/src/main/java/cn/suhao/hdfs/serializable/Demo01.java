package cn.suhao.hdfs.serializable;

import org.apache.hadoop.io.IntWritable;

import java.io.*;

public class Demo01 {
    /**
     * 序列化
     * @param args
     */
    public static void main(String[] args) throws Exception{
        //序列化后写入文件
        IntWritable a = new IntWritable(199);

        DataOutput data = new DataOutputStream(new FileOutputStream("/suhao/serializable.txt"));

        a.write(data);
        //读取序列化后的文件
        InputStream in = new FileInputStream("/suhao/serializable.txt");
        OutputStream out = new FileOutputStream("/suhao/sss.txt");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }

        //反序列化
        IntWritable b = new IntWritable();
        DataInput dataInput = new DataInputStream(new FileInputStream("/suhao/serializable.txt"));
        b.readFields(dataInput);//反序列化
        System.out.println("反序列化后："+b.get());
    }
}
