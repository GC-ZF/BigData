package JAVA_Advance;

/**
 * 适配器模式，将一个类的接口转换成用户希望的另外一个接口，适配器模式使得原本由于接口不兼容而不能工作的那些类可以一起工作
 * OO设计原则
 * 1、面向接口编程（面向抽象编程）
 * 2、封装变化
 * 3、多用组合，少用继承
 * 4、对修改关闭，对扩展开放
 */
public class java066适配器设计模式 {
    public static void main(String[] args) {
        PowerA powerA = new PowerAIml();
        work(powerA);

        PowerB powerB = new PowerBImpl();
        Adapter adapter = new Adapter(powerB);
        work(adapter);
    }

    public static void work(PowerA a) {
        System.out.println("正在连接...");
        a.insert();
        System.out.println("工作结束");
    }
}

interface PowerA {
    public void insert();
}

class PowerAIml implements PowerA {
    public void insert() {
        System.out.println("电源A开始工作");
    }
}

interface PowerB {
    public void connet();
}

class PowerBImpl implements PowerB {
    public void connet() {
        System.out.println("电源B开始工作");
    }
}

//适配器
class Adapter implements PowerA {
    private PowerB powerB;

    public Adapter(PowerB powerB) {
        this.powerB = powerB;
    }

    public void insert() {
        powerB.connet();
    }
}

/**
 * 类的适配器 接口需要实现全部，所以借助类减少工作量 对修改关闭，对扩展开放！！！
 */
interface Animal66 {
    public void sing();

    public void cry();

    public void run();

    public void swim();
}

abstract class AnimalFunction {
    public void sing() {
    }

    public void cry() {
    }

    public void run() {
    }

    public void swim() {
    }
}

class Dog66 extends AnimalFunction {
    public void run() {
        System.out.println("狗跑");
    }
}