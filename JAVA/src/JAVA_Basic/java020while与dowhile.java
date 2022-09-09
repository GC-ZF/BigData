package JAVA_Basic;


public class java020while与dowhile {
    public static void main(String[] args) {
        //while 先判断再执行
        // 计算1~100
        int num = 0;    //计算总数
        int i = 1;
        while (i <= 100) {
            num += i;
            i++;
        }
        System.out.println(num);

        //计算10的阶乘
        num = 1;
        i = 1;
        while (i <= 10) {
            num *= i;
            i++;
        }
        System.out.println(num);

        //打印100以内所有奇数,偶数和3的倍数
        i = 1;
        while (i < 100) {
            if (i % 2 != 0) {
                System.out.println("奇数" + i + " ");
            } else if (i % 2 == 0) {
                System.out.println("偶数" + i + " ");
            } else if (i % 3 == 0) {
                System.out.println("3的倍数" + i + " ");
            }
            i++;
        }

        /*
            do...while 先执行再判断，最少执行一次
            逆序输出10~0
         */
        i = 10;
        do {
            System.out.print(i + " ");
            i--;
        } while (i >= 0);

        //阶乘求和
        i = 1;
        int j = 1;
        num = 1;
        int sum = 0;
        while (i <= 10) {
            while (j <= i) {
                num *= j;
                j++;
            }
            i++;
            j = 1;
            sum += num;
            num = 1;
        }
        System.out.println("sum=" + sum);

        i = 1;
        sum = 0;
        do {
            j = 1;
            num = 1;
            while (j <= i) {
                num *= j;
                j++;
            }
            sum += num;
            i++;
        } while (i <= 10);
        System.out.println("do sum=" + sum);
    }
}