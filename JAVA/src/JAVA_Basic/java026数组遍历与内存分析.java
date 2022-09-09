package JAVA_Basic;

public class java026数组遍历与内存分析 {
    public static void main(String[] args) {
        int[] scores = {80, 81, 82, 83, 84};
        System.out.println("数组的长度" + scores.length);
        //for遍历
        int len = scores.length;
        for (int i = 0; i < len; i++) {
            System.out.println(scores[i]);
        }

        //forearch遍历
        for (int x : scores) {
            System.out.println(x);
        }

        print(scores);
        print2(1, 2, 3, 4, 5);
    }

    public static void print(int[] x) {
        int len = x.length;
        for (int i = 0; i < len; i++) {
            System.out.println(x[i]);
        }
    }

    /*
        JSK1.5可变参数
        可变参数只能是参数列表中的最后一个
        可变参数作为数组使用
     */
    public static void print2(int... x) {
        int len = x.length;
        for (int i = 0; i < len; i++) {
            System.out.println(x[i]);
        }
    }

    //测试数组的异常NullPointerException(空指针)
    public static void print3(int[] x) {
        // java.lang.NullPointerException
        //当一个变量为null（没有赋值时）时，我们去调用了该变量的属性和方法
        System.out.println("数组的长度为：" + x.length);
    }

    //测试数组的异常,数组下标越界
    // java.lang.ArrayIndexOutOfBoundsException
    public static void print4(int[] x) {
        for (int i = 0; i <= x.length; i++) {
            System.out.println(x[i]);
        }
    }
}
