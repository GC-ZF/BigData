package JAVA_Advance;

import org.omg.CORBA.PERSIST_STORE;

/**
 * final关键字
 * 1.使用final声明一个属性，就是常量，常量的命名规则建议使用全大写，常量必须在定义时或在构造器中初始化
 * 2.使用final声明的方法，不能被子类重写，只能被继承
 * 3.final关键字声明一个类，该类就转变为最终类，没有子类的类，final修饰的类无法被继承
 */
public class java056final关键字 {

    public static void main(String[] args) {
        System.out.println(Constant.PERSON_NUM);
        FinalClass fc=new FinalClass();
        fc.setLength(10);
    }
}

//常量类（工具类）：在实际项目开发中，常量类通常用于定义一些公共的、不变的数据
class Constant {
    public static final int PERSON_NUM = 10; //人数

}

class FinalClass {
    public final int DAY_NUM; //工作天数

    public FinalClass() {
        DAY_NUM = 22;
    }

    public final void print() {
        System.out.println("我是Final方法");
    }

    public void setLength(final int size){
//        size++;
//        System.out.println(size);
    }
}

class SubClass extends FinalClass {
//    public void print(){
//        System.out.println("我是Final方法");
//    }
}
