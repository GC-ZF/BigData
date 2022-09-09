package JAVA_Basic;

/**
 * 二维数组示例:JAVA中没有真正的多维数组，多维数组的表示方式是数组中的元素还是数组。
 * 一起来参加屌丝程序员大赛吧，有3个班级各3名学员参赛，
 * 记录每个学员的成绩，并计算每个班的平均分。
 */
public class java028数组最值 {
    public static void main(String[] args) {

        int[][] scores = {{78, 98, 88}, {87, 96, 85}, {67, 78, 89}};
        int classLen = scores.length;
        for (int i = 0; i < classLen; i++) {
            int sum = 0;
            int count = scores[i].length;
            for (int j = 0; j < count; j++) {
                sum += scores[i][j];
            }
            System.out.println(i + 1 + "平均分为" + sum / count);
        }
    }
}
