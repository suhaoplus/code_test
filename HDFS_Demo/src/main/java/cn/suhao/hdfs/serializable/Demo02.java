package cn.suhao.hdfs.serializable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Demo02 {
    public static void main(String[] args) throws Exception{
        Text t = new Text("苏");
        byte[] b = serialize(t);
        System.out.println(b.length);

        Text t1 = new Text();
        System.out.println(deserialize(t1,b));
    }
    //序列化
    public static byte[] serialize(Writable writable) throws Exception{
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        writable.write(dos);
        dos.close();
        return out.toByteArray();
    }
    //反序列化
    public static Writable deserialize(Writable writable,byte[] bytes) throws Exception{
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        DataInputStream dis = new DataInputStream(in);
        writable.readFields(dis);
        dis.close();
        return writable;
    }
}
