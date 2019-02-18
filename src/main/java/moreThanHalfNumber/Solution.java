package moreThanHalfNumber;

/**
 * 面试题39 数组中出现次数大于一半的数字
 */
public class Solution {
    /**
     * 法一：最直观的方法。
     *      排序，统计每个数字出现的次数
     *      时间复杂度：O(nlgn)
     */

    /**
     * 法二：寻找第middle大的数字（中位数），即为大于一半的数字。
     *      时间复杂度：O(n)
     */
    public int findMoreThanHalfNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int middle = nums.length/2;
        int start=0, end=nums.length-1;
        int index = partition(nums, start, end);
        while(index != middle) {
            if(index < middle) {
                start = index+1;
                index = partition(nums, start, end);
            }
            else {
                end = index-1;
                index = partition(nums, start, end);
            }
        }

        return nums[middle];
    }

    private int partition(int[] nums, int start, int end) {
        int key = nums[start];
        while(start < end) {
            while(start<end && nums[end]>key)
                end--;
            if(start < end) {
                nums[start++] = nums[end];
            }
            while(start<end && nums[start]<key)
                start++;
            if(start < end) {
                nums[end--] = nums[start];
            }
        }
         nums[start] = key;

        return start;
    }

    /**
     * 法三：遍历一遍数组，保存一个数字和次数，如果下一个数字为该数字，则次数加一
     *         若下一个数字不为该数字，则次数减一。当次数为0时，则更换下一数字，
     *         遍历结束保存的数字即为结果。
     */
    public int findMoreThanHalfNumber2(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int result=nums[0], times=1;
        for(int i=1; i<nums.length; i++) {
            if(times == 0) {
                result = nums[i];
                times = 1;
            }
            else if(nums[i] == result)
                times++;
            else if(nums[i] != result)
                times--;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = null;
        int[] nums2 = {};
        int[] nums3 = {1};
        int[] nums4 = {3, 3, 3};
        int[] nums5 = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        System.out.println("测试用例1："+solution.findMoreThanHalfNumber(nums1));
        System.out.println("测试用例2："+solution.findMoreThanHalfNumber(nums2));
        System.out.println("测试用例3："+solution.findMoreThanHalfNumber(nums3));
        System.out.println("测试用例4："+solution.findMoreThanHalfNumber(nums4));
        System.out.println("测试用例5："+solution.findMoreThanHalfNumber(nums5));
        System.out.println("测试用例1_1："+solution.findMoreThanHalfNumber2(nums1));
        System.out.println("测试用例2_1："+solution.findMoreThanHalfNumber2(nums2));
        System.out.println("测试用例3_1："+solution.findMoreThanHalfNumber2(nums3));
        System.out.println("测试用例4_1："+solution.findMoreThanHalfNumber2(nums4));
        System.out.println("测试用例5_1："+solution.findMoreThanHalfNumber2(nums5));
    }
}
