package JAVA_Advance;

import java.security.PublicKey;

/**
 * 接口的定义格式
 * interface 接口名称{
 * 全局常量
 * 抽象方法
 * }
 *
 * 接口的使用规则
 * 1.定义一个接口，使用interface关键字
 * 2.在一个接口中，只能定义常量、抽象方法、JDK1.8之后可以定义默认的实现方法
 * 3.接口可以继承多个接口，extends xx,xx
 * 4.一个具体类实现接口使用implements关键字
 * 5.一个类可以实现多个接口
 * 6.抽象类实现接口可以不实现接口的方法
 * 7.在接口中定义的方法没有声明访问修饰符 默认为public
 * 8.接口不能有构造方法
 * 9.接口不能被实例化
 */
public class java058接口 {
    public static void main(String[] args) {
        Girl g = new Girl("玛丽");
        g.sleep();
        g.eat();
        g.run();
        g.print();
    }
}

interface IEat {
    //public abstract void eat(); //接口中只能定义抽象方法，简写为
    void eat();//接口中定义的方法没有声明修饰符 public abstract

    //public static final int NUM=10;
    int NUM = 10;//常量

    //在JDK1.8后的特性，可以被所有实现类继承
    public default void print() {
        System.out.println("eat");
    }
}

interface IRun {
    void run();
}

//接口之间可以多继承
interface ISleep extends IEat, IRun {
    void sleep();
}

//具体类实现接口必须实现接口的所有方法
class Girl implements ISleep {
    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    public void sleep() {
        System.out.println("我爱睡觉");
    }

    public void eat() {
        System.out.println("我是" + name + "我爱吃猪脚");
    }

    public void run() {
        System.out.println("吃完就跑");
    }
}

/**
 * 我爱睡觉
 * 我是玛丽我爱吃猪脚
 * 吃完就跑
 * eat
 */
