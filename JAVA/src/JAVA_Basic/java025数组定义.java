package JAVA_Basic;

/*
    数组的定义：一组能够存储相同数据类型的数据集合
    数组一定要有长度
    数组中的每个数据称为元素
 */
public class java025数组定义 {
    public static void main(String[] args) {
        //第一种
        int[] nums = new int[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        //第二种
        int[] nums2;    //先声明，再定义
        nums2 = new int[5];

        //第三种
        int[] nums3 = new int[]{1, 2, 3, 4, 5};

        //第四种
        int[] nums4 = {1, 2, 3, 4, 5};

        System.out.println(nums.length);
    }
}
