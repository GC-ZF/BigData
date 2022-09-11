package JAVA_Advance;

import sun.management.jmxremote.SingleEntryRegistry;

/**
 * 单例设计模式：保证类中只有一个实例，并提供一个访问它的全局访问点
 * 1、饿汉式：在类被加载后，对象被创建，到程序结束后释放
 * 2、懒汉式：在第一次调用getInstance 方法时，对象被创建，到程序结束后释放
 * <p>
 * 步骤：
 * 1、构造方法私有化
 * 2、声明一个本类对象
 * 3、给外部提供一个静态方法获取对象实例
 * <p>
 * 在项目中为什么要使用单例？单例有什么好处？
 * 1、在设计一些工具类的时候（通常工具类只有功能方法，没有属性）
 * 2、工具类可能会被频繁调用
 * <p>
 * 目的是为了节省重复创建对象所带来的内存消耗，从而来提供效率
 * <p>
 * 能不能使用静态方法私有化+静态方法来替代单例？
 */
public class java049单例设计模式 {
    public static void main(String[] args) {
        //Singleton1 s =new Singleton1();//报错，私有化不可以new对象
        //正确做法，先获取实例
        Singleton1 s = Singleton1.getInstance();
        s.print();

        Singleton1 s1 = Singleton1.getInstance();
        s1.print();

        System.out.println(s == s1);

        //饿汉式
        System.out.println("---------------------");
        Singleton2 q = Singleton2.getInstance();
        q.print();

        Singleton2 q1 = Singleton2.getInstance();
        q1.print();

        System.out.println(q == q1);
    }
}

//能不能使用静态方法私有化+静态方法来替代单例？比如JDK中math
class Tools {
    private Tools() {
    }

    public static void print1() {
    }

    public static void print2() {
    }
}

//饿汉式：占用内存时间长，提高内存效率
class Singleton1 {
    private Singleton1() {
    }

    private static Singleton1 s = new Singleton1();
    public static Singleton1 getInstance() {
        return s;
    }

    public void print() {
        System.out.println("测试方法");
    }
}

//懒汉式：占用内存时间短，效率低（懒加载，延迟加载）。用的时候还没创建对象，在调用的时候创建，生命周期短
//在多线程访问时会有安全问题
class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 s;

    public static Singleton2 getInstance() {
        if (s == null) {
            s = new Singleton2();
        }
        return s;
    }

    public void print() {
        System.out.println("测试方法2");
    }
}

/**
 * 测试方法
 * 测试方法
 * true
 * ---------------------
 * 测试方法2
 * 测试方法2
 * true
 */