package JAVA_Advance;

/**
 * 继承：继承是从已有的类型创建类的过程
 * 创建一个父类，只能继承非私有的数据（属性和方法）
 * protected 访问权限修饰符，在继承关系中使用，在父类中使用 protected 修饰的属性或方法可以被子类继承
 * 因为子类要使用到父类的数据，那么就要通过父类的构造方法来初始化数据
 * 如果创建子类对象时，会调用父类的默认构造方法
 * <p>
 * 当父类中没有无参构造方法时，子类必须显示的调用父类的带参的构造方法
 * 可以在子类中显示的使用super()调用父类的构造方法，只能出现第一句
 * 继承的好吃：
 * 1.提高代码的复用性
 * 2.提高代码的维护性
 * 3.让类与类之间产生联系，是多态的前提
 * 继承的缺点：增强了类与类之间的耦合性
 * 开发原则：高内聚，低耦合
 * <p>
 * 方法重写（overriding method）
 * 在JAVA中，子类可以继承父类的方法，而不需要重新编写相同的方法，但有时子类并不想原封不动的继承父类方法，而是想做一定的修改，这就需要采用方法的重写，（方法覆盖）。在子类和父类中，重写方法后，在调用时，以创建的对象类型为准，会调用谁的方法
 * 关于方法重写的一些特性
 * 1.发生在子父类中，方法重写的两个返回值】方法名、参数列表必须完全一致
 * 2.子类抛出异常不能超过父类相应方法抛出的异常（子类异常不能大于父类异常）
 * 3.子类方法的访问级别不能低于父类相应方法的访问级别（子类访问级别不能低于父类访问级别）
 * 4.父类中的方法若使用private、static、final任意修饰符修饰，不能被子类重写
 * <p>
 * 为什么要重写方法？（方法重写的目的是什么？）
 * 若子类从父类中继承过来的方法，不能满足子类特有的需求时，子类就需要重写父类中相应的方法，方法的重写也是程序扩展的体现
 * <p>
 * 面试题：overloading与overriding的区别？
 * overloading：方法的重载，发生在同一类中，方法名相同，参数列表不同，返回值无关
 * overriding：方法的重写，发生在子父类中，方法名相同，参数列表相同，返回值相同，子类的访问修饰符大于或等于父类的访问修饰符，子类的异常声明必须小于或等于父类的异常声明，如果方法被privae、static、final修饰，那么不能被重写
 */

/*
我是Dog的构造方法
我是HomeDog的构造方法
旺财我是一只家狗,wangwang
吃饭
我是家狗，我喜欢吃骨头
我是Dog的构造方法
我是HuskyDog的构造方法
我是husky，我喜欢吃鸡肝
 */
public class java052继承的基本概念 {
    public static void main(String[] args) {
        HomeDog homeDog = new HomeDog("旺财");
        homeDog.print();
        homeDog.eat();

        HuskyDog hd = new HuskyDog();
        hd.eat();

    }
}

class Dog52 {
    protected String name;
    private String sex;

    public Dog52(String name, String sex) {
        this.name = name;
        this.sex = sex;
        System.out.println("我是Dog的构造方法");
    }

    protected void eat() {
        System.out.println("吃饭");
    }
}

class HomeDog extends Dog52 {
    public HomeDog(String name) {
        super(name, "公");//只能在第一句
        System.out.println("我是HomeDog的构造方法");
    }

    protected void print() {
        //super.属性 表示调用父类的属性,如果是继承过来的属性，那么super可以省略
        System.out.println(super.name + "我是一只家狗,wangwang");
    }

    //重写父类的方法
    public void eat() {
        super.eat();//调用父类的方法
        System.out.println("我是家狗，我喜欢吃骨头");
    }

}

class HuskyDog extends Dog52 {
    public HuskyDog() {
        super("哈士奇", "母");
        System.out.println("我是HuskyDog的构造方法");
    }

    public void show() {
        System.out.println(name + "我是husky，我能跳舞");
    }

    public void eat() {
        System.out.println("我是husky，我喜欢吃鸡肝");
    }
}