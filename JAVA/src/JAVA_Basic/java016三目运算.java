package JAVA_Basic;

import java.util.Scanner;

/*
    三目运算
 */
public class java016三目运算 {
    public static void main(String[] args) {
        System.out.println("请输入有一个成绩");
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        boolean bool = score >= 60 ? true : false;
        System.out.println(bool);
    }
}