package JAVA_Basic;


import java.util.Random;
import java.util.Scanner;

public class java027猜数字打印三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要猜的数");
        int num = sc.nextInt();
        System.out.println(guessNum(num) ? "在" : "不在");
        printTraingle(5);
    }

    /**
     * 数组示例：1、猜数游戏：从键盘中任意输入一个数据，判断数列中是否包含此数。
     */
    public static boolean guessNum(int num) {

        int[] data = new int[5];
        int len = data.length;
        Random rand = new Random();//随机数
        for (int i = 0; i < len; i++) {
            data[i] = rand.nextInt();
        }
        for (int i = 0; i < len; i++) {
            if (num == data[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数组示例：2、打印正三角形。
     *     A
     *    B B
     *   C C C
     *  D D D D
     * E E E E E
     */
    public static void printTraingle(int num) {
        for (int i = 1; i <= num; i++) {
            for (int m = 1; m <= num - i; m++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                char a = (char) (64 + i);
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}