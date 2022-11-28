package JAVA_Advance;


public class java067内部类1 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        //在外部创建成员内部类的实例，因为成员内部类需要依赖外部类的对象
        //通常情况下，我们不建议这样实例化内部类的对象
        Outer.Inner inner = outer.new Inner();
        inner.print();

        outer.innerPrint();

        outer.show();

        Outer.Inner3 inner3 = new Outer.Inner3();
        inner3.print();

        outer.print1();
        outer.print2();
        outer.print3(new Eat() {
            public void eat() {
                System.out.println("参数式匿名内部类");
            }
        });
    }
}

class Outer {
    private String name;

    /**
     * 1、成员内部类：直接在类中定义的类
     */
    //建议在外部类中定义一个方法，对外提供访问内部类的接口
    public void innerPrint() {
        Inner inner = new Inner();
        inner.print();
    }

    class Inner {
        public void print() {
            System.out.println("inner");
        }
    }

    /**
     * 方法内部类，在一个类中的方法内定义一个类
     * 1、只能在定义的方法内实例化，不能再其它地方实例化
     * 2、方法内部类对象不能使用该内部类所在方法的非final局部变量
     */
    public void show() {
        class Inner2 {
            public void print() {
                System.out.println("方法内部类");
            }
        }
        Inner2 inner2 = new Inner2();
        inner2.print();
    }

    /**
     * 静态内部类：在类中定义一个静态修饰的内部类
     * 静态的含义是该内部类可以像其它静态成员一样，没有外部类对象时，也能够访问它，静态嵌套类仅能访问外部类的静态成员和方法
     */
    static class Inner3 {
        public void print() {
            System.out.println("静态内部类");
        }
    }

    /**
     * 匿名内部类：没有名字的内部类。匿名内部类的三种情况：继承式、接口式、参数式
     * 1、不能有构造方法，只能有一个实例
     * 2、不能定义任何静态成员、静态方法
     * 3、不能是public、protected、private、static
     * 4、一定是在new的后面，用其隐含实现一个接口或者继承一个类
     * 5、匿名内部类为局部的，所以局部内的所有限制都对其生效
     */
    public void print1() {
        Cat67 cat = new Cat67() {
            @Override
            public void eat() {
                System.out.println("cat: 继承式匿名内部类");
            }
        };
        cat.eat();
    }

    //接口式
    public void print2() {
        Eat eat = new Eat() {
            public void eat() {
                System.out.println("eat: 接口式匿名内部类");
            }
        };
        eat.eat();
    }

    //参数式
    public void print3(Eat eat) {
        eat.eat();
    }
}

abstract class Cat67 {
    public abstract void eat();
}

interface Eat {
    public void eat();
}
/**
 * 成员：成员内部类、静态内部类
 * 局部：方法内部类、匿名内部类
 * 依赖外部类对象的，成员内部类，方法内部类、匿名内部类
 * 静态内部类不依赖外部类的对象，所以在项目中优先选择考虑静态内部类（内存泄漏）
 */