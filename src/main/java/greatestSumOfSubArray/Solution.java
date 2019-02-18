package greatestSumOfSubArray;

/**
 * 面试题42 连续子数组的最大和
 */
public class Solution {

    /**
     * 这段代码可以从动态规划的角度来理解：
     *      求出各个以 nums[i] 为结尾的子数组的最大和。然后得出最大的最大和。
     */
    public int greatestSum(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int curSum = nums[0];
        int greatestSum = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(curSum < 0)
                curSum = nums[i];
            else {
                curSum += nums[i];
            }
            if(greatestSum < curSum)
                greatestSum = curSum;
        }

        return greatestSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = null;
        int[] nums2 = {};
        int[] nums3 = {1};
        int[] nums4 = {-2};
        int[] nums5 = {-2, 1};
        int[] nums6 = {1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println("测试用例1："+solution.greatestSum(nums1));
        System.out.println("测试用例2："+solution.greatestSum(nums2));
        System.out.println("测试用例3："+solution.greatestSum(nums3));
        System.out.println("测试用例4："+solution.greatestSum(nums4));
        System.out.println("测试用例5："+solution.greatestSum(nums5));
        System.out.println("测试用例6："+solution.greatestSum(nums6));
    }
}