package cn.suhao.domain;

import java.util.*;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    static class StudentCompartor implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.equals(o2))
                return 0;
            else if(o1.name.equals(o2.name)){
                if (o1.age > o2.age)
                    return 1;
                else
                    return -1;
            }else {
                return o1.name.compareTo(o2.name)>0?1:-1;
            }
        }
    }

    public static void main(String[] args) {
        Student p1 = new Student("bbb",21);
        Student p6 = new Student("bbb",21);
        Student p5 = new Student("bbb",20);
        Student p4 = new Student("bbb",22);
        Student p2 = new Student("aaa",22);
        Student p3 = new Student("ccc",22);
        Student[] p = {p1,p2,p3,p4,p5,p6};
        Arrays.sort(p,new StudentCompartor());
        for (Student s : p){
            System.out.println(s);
        }
    }
}
