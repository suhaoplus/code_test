package cn.suhao.domain;

import java.io.Serializable;
import java.util.Arrays;

public class Person implements Comparable,Serializable{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;
        if (this.name.equals(p.name)){
            if (this.age > p.age)
                return 1;
            else if (this.age < p.age)
                return -1;
            else return 0;
        }else {
            return this.name.compareTo(p.name)>0?1:-1;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("bbb",21);
        Person p5 = new Person("bbb",20);
        Person p4 = new Person("bbb",22);
        Person p2 = new Person("aaa",22);
        Person p3 = new Person("ccc",22);
        Person[] p = {p1,p2,p3,p4,p5};

        System.out.println(p1.compareTo(p2));
        Arrays.sort(p);
        for (Person o : p){
            System.out.println(o);
        }
    }

}
