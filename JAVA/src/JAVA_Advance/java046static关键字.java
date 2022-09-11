package JAVA_Advance;

/**
 * static关键字
 * 1、静态变量或方法不属于对象，依赖类
 * 2、静态变量属于全局变量，生命周期从类一开始加载后一直到程序结束
 * 3、静态变量只有一份，在静态方法区中存储
 * 4、静态变量是本类所有对象共享一份
 * 5、变量：建议不要使用对象名去调用静态数据，直接使用类名调用
 * 6、方法：static修饰一个方法，那么该方法属于类，不属于对象，直接用类名调用
 * 7、静态方法不能访问非静态属性和方法，只能访问静态
 * 不能以任何方式引用this和super
 */
public class java046static关键字 {
    public static void main(String[] args) {
        Role beibei = new Role("刘备", "蜀国");
        Role yunchang = new Role("云长", "蜀国");
        Role zhangfei = new Role("张飞", "蜀国");
        System.out.println(beibei.getInfo());
        System.out.println(yunchang.getInfo());
        System.out.println(zhangfei.getInfo());


        System.out.println(beibei.country);
        System.out.println(yunchang.country);
        System.out.println(zhangfei.country);

        beibei.country="秦国";
        //5、建议不要使用对象名去调用静态数据，直接使用类名调用
        System.out.println("----------------------------");
        System.out.println(beibei.country);
        System.out.println(yunchang.country);
        System.out.println(zhangfei.country);

        System.out.println("----------------------------");
        System.out.println(Role.country);//用类名调用列
    }
}

class Role {
    private String name;
    static String country = "蜀国";//静态变量（全局变量）

    public Role() {
    }

    public Role(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //静态方法不能访问非静态数据
    public static void getCountry(String country){
        //this.country="a";
        Role.country=country;
    }
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }

    public String getInfo() {
        return "name=" + name + ",counry=" + country;
    }
}
/*
name=刘备,counry=蜀国
name=云长,counry=蜀国
name=张飞,counry=蜀国
蜀国
蜀国
蜀国
----------------------------
秦国
秦国
秦国
----------------------------
秦国
 */