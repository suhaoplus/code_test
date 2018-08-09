package cn.suhao.hdfs.serializable;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparator;

public class Demo03 {
    /**
     * comparator
     * @param args
     */
    public static void main(String[] args) throws Exception{
        WritableComparator wc = WritableComparator.get(IntWritable.class);

        IntWritable a1 = new IntWritable(100);
        IntWritable a2 = new IntWritable(200);

        int i = wc.compare(a1, a2);

        System.out.println(i);

        System.out.println("---------序列化后------");
        byte[] b1 = Demo02.serialize(a1);
        byte[] b2 = Demo02.serialize(a2);

        int i1 = wc.compare(b1, 0, b1.length, b2, 0, b2.length);
        System.out.println(i1);
    }
}
