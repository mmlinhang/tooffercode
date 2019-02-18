package minNumInRotatedArray;

/**
 * 面试题11 旋转数组的最小数字
 */
public class Solution {

    /**
     * 顺序查找
     * 时间复杂度 O(n)
     */

    /**
     * 二分法
     * 时间复杂度 O(lgn)
     */
    public int min(int[] array) {
        int len = array.length;
        if(array == null || len <= 0)
            throw new RuntimeException("Array is null");

        // 旋转前0个数字
        if(array[0] < array[len-1])
            return array[0];

        int start=0, end=len-1;
        int middle;
        while(end-start > 1) {
            middle = (end-start)/2;
            // 特殊情况，无法判断middle再那个有序序列中
            // 只能使用顺序查询
            if(array[start]==array[middle] && array[end]==array[middle]) {
                for(int i=start; i<end; i++) {
                    if(array[i+1] < array[i])
                        return array[i+1];
                }
            }
            else if(array[middle] >= array[start]) {
                start = middle;
            }
            else if(array[middle] < array[start]) {
                end = middle;
            }
        }

        return array[end];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] a1 = {4, 5, 1, 2, 3};
        int[] a2 = {1, 2, 3, 4, 5};
        int[] a3 = {3, 3, 3, 2, 2, 3};
        int[] a4 = {1, 0, 1, 1, 1};
        int[] a5 = {1};

        System.out.println("测试用例1："+solution.min(a1));
        System.out.println("测试用例2："+solution.min(a2));
        System.out.println("测试用例3："+solution.min(a3));
        System.out.println("测试用例4："+solution.min(a4));
        System.out.println("测试用例5："+solution.min(a5));
    }
}
