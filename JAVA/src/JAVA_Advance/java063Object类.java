package JAVA_Advance;

import java.util.Objects;

public class java063Object类 {
    public static void main(String[] args) {
        Student63 s= new Student63("张时贰",20,20);
        System.out.println(s.toString());  //等价 System.out.println(s);

        Student63 s2= new Student63("张时贰",20,20);
        boolean b = s.equals(s2);
        System.out.println("Student equals "+b);
        System.out.println(s.getClass()); //类信息 class JAVA_Advance.Student63

        String str1=new String("贝贝");
        String str2=new String("贝贝");
        System.out.println(str1.equals(str2)); //true
    }
}

class Student63 {
    private String name;
    private int sid;
    private int age;

    public Student63() {
    }

    public Student63(String name, int sid, int age) {
        this.name = name;
        this.sid = sid;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student63{" +
                "name='" + name + '\'' +
                ", sid=" + sid +
                ", age=" + age +
                '}';
    }

    //重写equals来实现两个对象的比较
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj instanceof Student63){
            Student63 s=(Student63) obj;
            if(!this.name.equals(s.name)){
                return false;
            }
            if(this.sid!=s.sid){
                return false;
            }
            if(this.age!=s.age){
                return false;
            }
            return true;
        }
        return false;
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student63 student63 = (Student63) o;
//        return sid == student63.sid && age == student63.age && Objects.equals(name, student63.name);
    }
}

/**
 * Student63{name='张时贰', sid=20, age=20}
 * Student equals true
 * class JAVA_Advance.Student63
 * true
 */