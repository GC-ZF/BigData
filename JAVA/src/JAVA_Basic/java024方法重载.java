package JAVA_Basic;


public class java024方法重载 {
    public static void main(String[] args) {
        System.out.println(isRun(2017) ? "闰年" : "平年");
    }

    /*
    方法函数
    方法的返回值：1、判断给定的是否是闰年
    */
    public static boolean isRun(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /*
        方法重载：在同一个类中，方法相同，参数列表不同。返回值不能作为重载的条件
     */
    public static int add(int a, int b) {
        return a + b;
    }

    public static float add(float a, float b) {
        return a + b;
    }
}
