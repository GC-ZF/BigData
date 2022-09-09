package JAVA_Basic;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 模拟双色球综合案例
 * 1.用户选择是机选还是手选号码
 * 2.接收用户选号（6红，1蓝）
 * 3.生成系统号码和用户号码，记录个数
 * 4.比较系统号码和用户号码，记录个数
 * 5.验证是否中奖
 * 6.系统号码排序
 * 7.公布结果
 */

public class java033双色球案例 {
    public static void main(String[] args) {
        //定义相关的变量
        int[] userRedBall = new int[6];//用户选择红球号码
        int[] sysRedBall = new int[6];//系统选择红球号码
        int userBlueBall = 0;//用户选择蓝球号码
        int sysBlueBall = 0;//系统选择蓝球号码
        int redCount = 0;//记录用户选择正确红球个数
        int blueCount = 0;//记录用户选择正确蓝球个数
        int[] redBall = new int[33];//存储1~33的红球号码
        //随机生成6个在1~33之间不重复的数
        for (int i = 0; i < redBall.length; i++) {
            redBall[i] = i + 1;
        }

        //游戏开始提示
        System.out.println("双色球游戏开始");
        System.out.println("1.机选 2.手选");

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        boolean flag = true;//判断是否需要重新输入机选或手选
        while (flag) {
            int isAuto = sc.nextInt();
            switch (isAuto) {
                case 1:
                    computer(redBall, userRedBall);//机选红球
                    userBlueBall = r.nextInt(16) + 1;//机选蓝球
                    flag = false;
                    break;
                case 2:
                    System.out.println("请选择6个红球号码(1~33)：");
                    for (int i = 0; i < userRedBall.length; i++) {
                        userRedBall[i] = sc.nextInt();
                    }
                    System.out.println("请输入1个蓝球号码(1~16)：");
                    userBlueBall = sc.nextInt();
                    flag = false;
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }

        //系统随机生成号码
        //红球
        computer(redBall, sysRedBall);
        //蓝球
        sysBlueBall = r.nextInt(16) + 1;

        //统计结果
        //红球
        for (int i = 0; i < userRedBall.length; i++) {
            for (int j = 0; j < sysRedBall.length; j++) {
                if (userRedBall[i] == sysRedBall[j]) {
                    int tmp = sysRedBall[j];
                    sysRedBall[j] = sysRedBall[sysRedBall.length - 1 - redCount];
                    sysRedBall[sysRedBall.length - 1 - redCount] = tmp;
                    redCount++;
                    break;
                }
            }
        }
        //蓝球
        if (userBlueBall == sysBlueBall) {
            blueCount = 1;
        }

        //验证是否中奖
        if (blueCount == 0 && redCount <= 3) {
            System.out.println("未中奖");
        } else if (blueCount == 1 && redCount < 1) {
            System.out.println("中了六等奖，5块钱！");
        } else if (blueCount == 1 && redCount == 3 || (blueCount == 0 && redCount == 4)) {
            System.out.println("中了五等奖，10块钱");
        } else if (blueCount == 1 && redCount == 4 || (blueCount == 0 && redCount == 5)) {
            System.out.println("中了四等奖，200块钱");
        } else if (blueCount == 1 && redCount == 5) {
            System.out.println("中了三等奖，3000块钱");
        } else if (blueCount == 0 && redCount == 6) {
            System.out.println("中了二等奖，150w");
        } else if (blueCount == 1 && redCount == 6) {
            System.out.println("中了一等奖，500w");
        } else {
            System.out.println("系统出错");
        }

        //公布系统号码
        System.out.println("本期中奖红球号码为");
        sort(sysRedBall);
        System.out.println(Arrays.toString(sysRedBall));
        System.out.println("本期中奖蓝球号码为:" + sysBlueBall);

        //公布用户号码
        System.out.println("您选择的红球号码为");
        sort(userRedBall);
        System.out.println(Arrays.toString(userRedBall));
        System.out.println("您选择的蓝球号码为:" + userBlueBall);

        System.out.println("谢谢参与");
    }

    //冒泡

    public static void sort(int[] ball) {
        for (int i = 0; i < ball.length - 1; i++) {
            for (int j = 0; j < ball.length - i - 1; j++) {
                if (ball[j] > ball[j + 1]) {
                    ball[j] = ball[j] + ball[j + 1];
                    ball[j + 1] = ball[j] - ball[j + 1];
                    ball[j] = ball[j] - ball[j + 1];
                }
            }
        }
    }

    //用于在指定数列中，随机生成多个不重复的数
    public static void computer(int[] redBall, int[] userRedBall) {
        Random r = new Random();
        int index = -1;
        int len = userRedBall.length;//生成六个随机数
        for (int i = 0; i < len; i++) {
            index = r.nextInt(redBall.length - i);
            userRedBall[i] = redBall[index];

            //改变数组顺序，与倒数第i为交换，在下一次生成随机数时排除在外（142行）
            int tmp = redBall[index];
            redBall[index] = redBall[redBall.length - 1 - i];
            redBall[redBall.length - 1 - i] = tmp;
        }
    }
}
