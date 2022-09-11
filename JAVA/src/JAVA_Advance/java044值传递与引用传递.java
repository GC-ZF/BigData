package JAVA_Advance;

public class java044值传递与引用传递 {
    public static void main(String[] args) {
        //值传递
        int x = 10;
        methodx(x);
        System.out.println("x=" + x);//10  直接放在栈中

        //引用传递
        Demo d = new Demo();
        methodDemo(d);
        System.out.println("Demo.age=" + d.age);//Demo.age=5  d在栈中存的是地址指向栈中 d.age

        //String传递（引用数据类型），字符串数据类型相当于new一个对象，所以不是引用传递
        String name = "小飞";
        methodString(name);
        System.out.println("name=" + name);//小飞

        //String传递
        Demo2 p = new Demo2();
        methodDemo1(p);
        System.out.println("p=" + p.name);//备备
    }

    //值传递
    public static void methodx(int mx) {
        mx = 20;
    }

    //引用传递
    public static void methodDemo(Demo duck) {
        duck.age = 5;//在栈中存的是地址 在栈中指向 d.age 的位置
    }

    //String传递
    public static void methodString(String sname) {
        sname = "小贝";
    }

    //
    public static void methodDemo1(Demo2 p) {
        p.name = "备备";
    }
}

//引用传递
class Demo {
    int age = 2;
}

class Demo2 {
    String name = "菲菲";
}