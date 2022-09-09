package JAVA_Basic;

import java.util.Scanner;

/*
运算符
 */
public class java013算数赋值关系 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = a + b;
        a = 10;
        b = 3;
        System.out.println(a / b);

        System.out.println(a % b);

        a = b++;//后增，先赋值再自增
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        a = ++b;//后自增，先增后赋值
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        int x = 1;
        int y = 2;
        y = x + y - (++y);
        System.out.println("x=" + x);//1
        System.out.println("y=" + y);//0

        //赋值运算符
        short s = 10;
        s += 1;
        System.out.println("s=" + s);

        //关系运算符，返回boolean类型
        System.out.println(x == y);

        //创建一个键盘输入的工具
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int x1 = sc.nextInt();
        System.out.println("x1=" + x1);

        //输入字符串
        System.out.println("请输入一个字符串");
        String string = sc.next();
        System.out.println(string);
    }
}
