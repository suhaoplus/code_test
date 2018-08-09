package cn.suhao.hdfs.serializable;

import org.apache.hadoop.io.Text;

public class Demo04 {
    /**
     * 测试Text和String的区别
     * @param args
     */
    public static void main(String[] args) {
        Text t = new Text("hadoop");
        System.out.println(t);
        System.out.println(t.charAt(2) + "\t" + (int)'d');
        System.out.println("-------------------------------");
        String s = new String("hadoop");
        System.out.println(s);
        System.out.println(s.charAt(2) + "\t" + (int)'d');
        System.out.println(s.length());
        System.out.println(s.getBytes().length);
        System.out.println("------------------------");
        Text text = new Text("dashuju");
        System.out.println(text);
        byte[] bytes = text.getBytes();
        for (byte b : bytes){
            System.out.println(b);
        }
    }
}
