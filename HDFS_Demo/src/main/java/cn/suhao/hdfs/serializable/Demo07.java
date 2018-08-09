package cn.suhao.hdfs.serializable;

import org.apache.hadoop.io.*;

public class Demo07 {
    public static void main(String[] args) throws Exception{
        RawComparator<IntWritable>  rc = WritableComparator.get(IntWritable.class);
        IntWritable one = new IntWritable(100);
        IntWritable two = new IntWritable(200);

        int i1 = rc.compare(one, two);
        System.out.println(i1);

        int i2 = one.compareTo(two);
        System.out.println(i2);
        System.out.println("------------------");
        byte[] bytes1 = Demo02.serialize(one);
        byte[] bytes2 = Demo02.serialize(two);
        int i3 = rc.compare(bytes1, 0, bytes1.length, bytes2, 0, bytes2.length);
        System.out.println(i3);
        System.out.println("------------------");


    }
}
