package JAVA_Basic;

public class java023方法与数组 {
    public static void main(String[] args) {
        getMenu();  //调用
        printStart(5);  //传入参数称为实参

    }


    /*
        定义方法
        访问权限+修饰符+返回值+方法名
     */
    public static void getMenu() {
        System.out.println("-----菜单-----");
        System.out.println("1、宫保鸡丁 22");
        System.out.println("2、韭菜鸡蛋 20");
        System.out.println("3、红烧狮子头 26");
        System.out.println("4、滋补牛尾汤 38");
        System.out.println("5、美颜酱猪蹄 38");
    }

    /*
        打印星星
        形参：在方法定义时的参数称为形参
     */
    public static void printStart(int line) {
        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
