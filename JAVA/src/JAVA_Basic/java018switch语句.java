package JAVA_Basic;

import java.util.Scanner;

/*
    switch分支语句
    每一个case子句必须是唯一的常量值，需要添加break，否则将继续往下执行
    default语句可以省略
 */
public class java018switch语句 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("今天是星期几");
        int day = sc.nextInt();
        switch (day) {
            case 1:
                System.out.println("星期一");
                System.out.println("周一比较堵，1.公交 2.地铁");
                int method = sc.nextInt();
                if (method == 1) {
                    System.out.println("公交");
                } else {
                    System.out.println("地铁");
                }
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期七");
                break;
            default:
                System.out.println("输入错误");
                break;
        }
    }
}