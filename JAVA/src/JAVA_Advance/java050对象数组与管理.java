package JAVA_Advance;

import java.util.Arrays;

/**
 * 对象数组就是数组里的每个元素都是类的对象，赋值时先定义对象，然后将对象直接赋给数组
 * 动态数组：
 * 1、数组是一种线性数据结构
 * 2、数组不适合做删除、插入操作，适合添加、查找、遍历
 */
public class java050对象数组与管理 {
    public static void main(String[] args) {
        //添加
        ChickenManger cm = new ChickenManger(5);
        cm.add(new Chicken(1, "小1", 10));
        cm.add(new Chicken(2, "小2", 8));
        cm.add(new Chicken(3, "小3", 7));
        cm.add(new Chicken(4, "小4", 1));
        cm.add(new Chicken(5, "小5", 13));
        cm.getLength();///数组长度
        //扩建
        cm.add(new Chicken(6, "小6", 14));

        System.out.println("----printAll----");
        cm.printAll();

        System.out.println("----find----");
        Chicken c = cm.find(5);
        c.print();

        System.out.println("----updat----");
        cm.update(new Chicken(1, "铁公鸡", 20));
        cm.printAll();

        System.out.println("----delete----");
        cm.delete(1);
        cm.printAll();
    }
}

//小鸡管理类
class ChickenManger {
    private Chicken[] cs = null;
    private int count = 0;    //记录当前数组的元素个数（下标）

    public void getLength() {
        System.out.println(cs.length);
    }

    public ChickenManger(int size) {
        if (size > 0) {
            cs = new Chicken[size];
        } else {
            cs = new Chicken[5];
        }
    }

    //添加
    public void add(Chicken add) {
        if (count >= cs.length) {//数组已满，扩充操作
            //算法1：扩充原来数组大小的一半 cs.length*3/2+1
            //算法2：扩充原来数组的一倍     cs.length*2
            int newLen = cs.length * 2;
            cs = Arrays.copyOf(cs, newLen);
        }
        cs[count] = add;
        count++;
    }

    //删除
    public void delete(int id) {
        for (int i = 0; i < count; i++) {
            if (cs[i].getId() == id) {
                for (int j = id - 1; j < count; j++) {
                    cs[j] = cs[j + 1];
                }
                cs[count - 1] = null;
                count--;
                break;
            }
        }
    }

    //更新
    public void update(Chicken c) {
        Chicken temp = find(c.getId());
        if (temp != null) {
            temp.setName(c.getName());
            temp.setAge(c.getAge());
        }
    }

    //查找
    public Chicken find(int id) {
        for (int i = 0; i < count; i++) {
            if (cs[i].getId() == id) {
                return cs[i];
            }
        }
        return null;
    }

    //输出所有
    public void printAll() {
        for (int i = 0; i < count; i++) {
            cs[i].print();
        }
    }
}

//小鸡类(数据对象)  value object (vo)
class Chicken {
    private int id;
    private String name;
    private int age;

    public Chicken() {
    }//一般情况下保留默认的构造方法

    public Chicken(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void print() {
        System.out.println("id:" + id + " name:" + name + " age:" + age);
    }
}
