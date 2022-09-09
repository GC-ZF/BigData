package JAVA_Basic;

/**
 * 选择排序算法
 * 每一趟从待排序的数据元素中选出最小（或最大）的一个元素，
 * 顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
 * 选择排序是不稳定的排序方法。
 */
public class java030选择排序 {
    public static void main(String[] args) {
        int[] nums = {34, 4, 56, 17, 90, 65};
        int len = nums.length;
        int min = 0;
        for (int i = 0; i < len - 1; i++) {
            min = i;
            for (int j = i; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[min];
            nums[min] = tmp;
        }
        for (int z = 0; z < len; z++) {
            System.out.print(nums[z] + " ");
        }
    }
}
