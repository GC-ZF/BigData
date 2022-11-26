package JAVA_Advance;

/**
 * 多态：对象在运行过程中的多种形态
 * 多态分为两类：
 * 1.方法的重载与重写
 * 2.对象的多态性
 * <p>
 * 用父类的引用指向子类对象（用大的类型接受小的类型，向上转型、自动转换）
 * 对象的多态性：多态性是从继承关系中的多个类而来的
 * 向上转型：将子类实例转换为父类引用
 * 格式：父类 父类对象=子类实例  自动转换
 * 咦基本数据类型为例 int i = "a"; char的容量比int小所以自动转换
 * <p>
 * 向下转型：将父类实例转换为子类实例
 * 格式：子类 子类对象=（子类）父类实例  强制转换
 * 以基本数据类型为例：char c = (char)97;
 * 因为整形是4个字节，比 char 2个字节大，所以强制完成
 */

/**
 * instanceof是用于检查对象是否为指定的类型，通常在把父类引用强制转换为子类引用时使用，以避免发生类型转换异常
 *
 * 语法：
 *  对象 instanceof 类型   -返回bool值
 * 父类设计法则
 * 通过 instanceof关键字，可以方便检查对象类型，但是如果一个父类的子类过多，这样的判断还是显得很繁琐，所以如何设计一个父类？
 * 1.父类通常情况下都设计为抽象类或接口，其中有限考虑接口，如接口不能满足才考虑抽象类
 * 2.一个具体的类尽可能不去继承另一个具体类，这样的好处是无需检查对象是否为父类的对象
 */

public class java059多态性 {
    public static void main(String[] args) {
//        HomeChicken hc= new HomeChicken("小鸡");
//        hc.eat();
//        YeChicken yc = new YeChicken("大鸡");
//        yc.eat();

        //用父类的引用指向子类对象（用大的类型表示小的类型）自动转换
        Chicken59 hc = new HomeChicken("小鸡");
        hc.eat();
        Chicken59 yc = new YeChicken("大鸡");
        yc.eat();

//        hc=yc;
//        hc.eat();
        //抽象（粒度）面向抽象（接口）编程
        eat(hc);
        eat(yc);

        Chicken59 fire = new FireChicken("火鸡");
        eat(fire);
    }

    public static void eat(Chicken59 c) {
        System.out.println("鸡吃饭");
        c.eat();
        if (c instanceof FireChicken){//成立条件是，对象本身及对象的父类
            FireChicken f = (FireChicken) c;//大的类型转换为小的类型，强制转换
            f.song();
        }
//        try {
//            FireChicken f = (FireChicken) c;//大的类型转换为小的类型，强制转换
//            f.song();
//        } catch (Exception ClassCastException) {
//            System.out.println("无法转换");
//        }
    }
}

//鸡
abstract class Chicken59 {
    private String name;

    public Chicken59() {
    }

    public Chicken59(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void eat();
}

//家鸡
class HomeChicken extends Chicken59 {
    public HomeChicken(String name) {
        super(name);
    }

    public void eat() {
        System.out.println(this.getName() + "我爱吃米");
    }
}

//野鸡
class YeChicken extends Chicken59 {
    public YeChicken(String name) {
        super(name);
    }

    public void eat() {
        System.out.println(this.getName() + "我爱吃虫子");
    }
}

class FireChicken extends Chicken59 {
    public FireChicken(String name) {
        super(name);
    }

    public void eat() {
        System.out.println(this.getName() + "我不吃东西");
    }

    public void song() {
        System.out.println("火鸡唱歌");
    }
}