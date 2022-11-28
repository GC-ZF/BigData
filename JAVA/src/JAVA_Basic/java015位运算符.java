package JAVA_Basic;

/*
    位运算符
 */

import java.util.Scanner;

public class java015位运算符 {
    public static void main(String[] args) {
        System.out.println(~10);//反
        System.out.println(10 & 10);//与
        System.out.println(10 | 10);//或
        System.out.println(10 ^ 10);//异

        /*
            左移:<<
            带符号右移>>
            无符号右移>>>
         */

        //练习:以最快的方法计算8*4
        //0000 1000 8
        //0010 0000 32
        System.out.println(8 << 2);

        //练习:通过键盘输入，初始化两个数将这两个数据交换位置后，输出显示交换后得数据
        Scanner sc = new Scanner(System.in);
        System.out.println("num1=");
        int num1 = sc.nextInt();
        System.out.println("num2=");
        int num2 = sc.nextInt();
        //方法一通过第三个变量交换
        int tmp=num1;
        num1=num2;
        num2=tmp;

        //方法二
        num1 = num1 + num2 - (num2 = num1);

        //方法三
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num1;

        //方法四，最快但不能相同
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^ num2;
    }
}
