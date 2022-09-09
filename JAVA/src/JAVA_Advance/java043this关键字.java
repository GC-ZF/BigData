package JAVA_Advance;

/**
 * this关键字
 * 调用类中的属性
 * 调用类中的方法或构造方法
 * 表示当前对象：在方法被调用的过程中，拿个对象调用了方法，在方法内的this关键字就表示谁
 * 类名.this
 */
public class java043this关键字 {
    public static void main(String[] args) {
        Cat cat=new Cat();
        cat.setName("咪咪");
        cat.setAge(3);
        cat.eat();
    }
}

class Cat{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {//name=咪咪
        this.name = name;//this代表的是当前对象
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void eat(){
        //在方法中使用this调用类中的其它方法或属性，this可以省略，this前面可以使用 当前的类名.this
        System.out.println("我是"+this.getName()+",我爱吃🐟");
        System.out.println("我是"+getName()+",我爱吃🐟");
        System.out.println("我是"+Cat.this.getName()+",我爱吃🐟");
    }
}