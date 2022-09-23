package JAVA_Advance;

/**
 * 封装性
 * 如果属性没有封装，那么在本类之外创建对象之后，可以直接访问属性
 * 访问权限修饰符
 * private表示私有的，私有的属性或方法，只能在类内访问
 * public表示共有的，可以在类内或类外访问
 * 想要在外部访问私有属性，需要提供公有的方法间接访问
 * 通常在一个类中，属性都私有化，并对外提供get 和 set 方法
 * 成员变量有初始值，局部变量必须赋值。局部变量和成员变量可以同名，满足就近原则
 */
public class java040封装的特性 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("菲菲");
        p1.setAge(18);
        p1.print();
        p1.run(10);
        p1=null;
    }
}

//没有封装之前
class Person {
    //属性的封装
    private String name;//成员变量，在类中定义，有初始值0
    private int age;//成员变量，在类中定义

    //对外提供一个为name属性设置的方法
    public void setName(String name) {
        this.name = name;
    }
    //对外设置一个获取name属性的方法
    public String getName() {
        return name;
    }
    public void run(int len){
        int m=len;//参数len是和m都是局部变量，需要赋值
        System.out.println("我跑了"+m+"米");
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    public void print(){
        System.out.println("name:"+name+"age"+age);
    }
}
