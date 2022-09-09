package JAVA_Basic;

import java.util.Scanner;

public class java014逻辑运算符 {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        //与运算
        System.out.println(a & b);
        //或运算
        System.out.println(a | b);
        //异或运算
        System.out.println(a ^ b);
        //非运算
        System.out.println(!b);
        //短路与
        System.out.println(a && b);
        //短路或
        System.out.println(a || b);

        /*
            &:分别计算表达式两边的结果，再做&运算，在做位运算时&表示按位与
            &&:先计算左边的表达式，如果false直接输出false
            所以首选短路
         */

        //练习1：通过键盘输入声明初始化一个圆柱体的高和底面半径,pai的值是3.14，求圆柱体的体积，并显示输出圆柱体的体积
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入圆柱体高");
        double h = sc.nextInt();
        System.out.println("请输入圆柱体半径");
        double r = sc.nextInt();
        System.out.println("圆柱体的体积为:" + 3.14 * r * r * h);

        //练习2：定义一个五位整数,求各个位上的数的和
        System.out.println("请输入一个五位整数");
        int num = sc.nextInt();
        int num5 = num / 10000;
        int num4 = num / 1000 % 10;
        int num3 = num / 100 % 10;
        int num2 = num / 10 % 10;
        int num1 = num % 10;
        int add = num5 + num4 + num3 + num2 + num1;
        System.out.println("各个位上的和为:" + add);

        //练习3：根据天数计算周数和剩余的天数，天数是通过键盘输入
        int day = sc.nextInt();
        System.out.println("请输入天数");
        System.out.println("周数:" + day / 7 + "剩余天数" + day % 7);
    }
}