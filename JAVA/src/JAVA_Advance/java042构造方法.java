package JAVA_Advance;

/**
 * 构造方法是在类中定义，构造方法的格式 类名(){} 无返回值类型
 * 1、构造方法就是类构造对象调用的方法，用于对象的初始化操作
 * 2、构造方法是实例化一个类的对象时，也就是new的时候，最先调用的方法
 */
public class java042构造方法 {
    public static void main(String[] args) {
        Dog dog =new Dog();
        Dog dog1=new Dog("菲菲",10);
        dog1.print();
    }
}

class Dog{
    private String name;
    private int age;
    //默认构造方法，通常有其他构造方法时，要保留默认构造方法
    public Dog(){
        System.out.println("Dog()构造方法执行");
    }
    //构造重载
    public Dog(String name ,int age){
        this();//调用其它构造方法时，此语句需要在第一句，在构造方法相互调用时必须要有出口
        setName(name);
        setAge(age);
        System.out.println("Dog(String name ,int age)有参调用");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void print(){
        System.out.println("name="+name+"age="+age);
    }
}