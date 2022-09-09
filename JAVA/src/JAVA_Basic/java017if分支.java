package JAVA_Basic;

import java.util.Scanner;

/*
    if分支语句
 */
public class java017if分支 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //输入一个字符，判断是大写字母还是小写字母，输出提示信息
        System.out.println("请输入一个字母");
        int c = input.nextInt();
        if (c >= 65 && c <= 96) {
            System.out.println("大写字母" + (char) c);
        } else {
            System.out.println("小写字母" + (char) c);
        }

        //判断是否为闰年
        System.out.println("请输入一个年份");
        int year = input.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("闰年");
        } else {
            System.out.println("平年");
        }
    }
}
