package JAVA_Basic;

/*
    for循环六种写法
 */
public class java021for循环 {
    public static void main(String[] args) {
//        //1.标准写法
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
//
//        //2.表达式1省略，但在外部声明
//        int j = 0;
//        for (; j < 10; j++) {
//            System.out.println(j);
//        }
//
//        //3.表达式2省略，死循环
//        for (int i = 0; ; i++) {
//            System.out.println(i);
//        }
//
//        //4.表达式3省略，但要声明在循环内部
//        for (int i = 0; i < 10) {
//            System.out.println(i);
//            i++;
//        }
//
//        //5.表达式1，3省略，但是要声明在循环的外部和内部
//        int x = 0;
//        for (; x < 10; ) {
//            System.out.println(x);
//            x++;
//        }
//
//        //6.三个表达式都省略，死循环
//        for (; ; ) {
//
//        }
        /*
            打印输出0~200之间能被7整除但不能被4整除的所有整数
         */
        for (int i = 0; i <= 200; i++) {
            if (i % 7 == 0 && i % 4 != 0) {
                System.out.println(i);
            }
        }

        /*
            输出10个斐波那契数列 第1，2为1，之后为前两项之和
        */
        int n1 = 1;
        int n2 = 1;
        for (int i = 1; i <= 10; i++) {
            if (i <= 2) {
                System.out.println(1);
            } else {
                System.out.println(n1 + n2);
                n2 = n1 + n2;
                n1 = n2 - n1;
            }
        }
    }
}
