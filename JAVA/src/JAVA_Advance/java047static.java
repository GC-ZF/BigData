package JAVA_Advance;

/**
 * 编译器运行
 * [Ljava.lang.String;@1b6d3586
 * 0
 * cmd运行
 * java java047static关键字.java "feifei" "yunchang"
 * 输出：
 * 2
 * feifei
 * yunchang
 */
public class java047static {
    public static void main(String[] args) {
        System.out.println(args);
        System.out.println(args.length);
        for (String s : args) {
            System.out.println(s);
        }
    }
}
