package cn.suhao.hdfs.serializable;

import cn.suhao.domain.Person;
import org.apache.hadoop.io.ObjectWritable;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Demo08 {
    public static void main(String[] args) throws Exception{
        Person p1 = new Person("bbb",21);
        Person p3 = new Person("ccc",22);
        ObjectWritable ow = new ObjectWritable(p1);

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("/suhao/p.txt"));
        ow.write(dos);
        System.out.println("序列化成功！！");
    }
}
