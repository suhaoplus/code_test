package cn.suhao.hdfs.serializable;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

import java.io.*;

public class Demo10 {
    public static void main(String[] args) throws Exception{
        Writable w = new IntWritable(111);
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("/suhao/person.tct"));
        w.write(dos);
        System.out.println("---------------------");
        IntWritable w1 = new IntWritable();
        DataInputStream dis = new DataInputStream(new FileInputStream("/suhao/person.tct"));
        w1.readFields(dis);
        System.out.println(w1.get());
        System.out.println("---------------------");

        IntWritable w2 = new IntWritable(100000);
        byte[] b1 = serializer(w2);
        System.out.println(b1.length);
        System.out.println("-----------------------");
        IntWritable w3 = new IntWritable();
        IntWritable w4 = deserialize(w3, serializer(w2));
        System.out.println(w4.get());
    }
    private static byte[] serializer(IntWritable i) throws Exception{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        i.write(dos);
        dos.close();
        return out.toByteArray();
    }

    private static IntWritable deserialize(IntWritable w,byte[] b) throws Exception{
        ByteArrayInputStream in = new ByteArrayInputStream(b);
        DataInputStream dis = new DataInputStream(in);
        w.readFields(dis);
        return w;
    }
}
