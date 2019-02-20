package twoNumberWithSum;

/**
 * 面试题57 和为 s 的两个数字
 */
public class Solution {

    public int[] getTwoNumberWith(int[] nums, int sum) {
        if(nums==null || nums.length==0)
            return null;

        int start=0, end=nums.length-1;
        int[] res = new int[2];
        while(start < end) {
            int towSum = nums[start]+nums[end];
            if(towSum < sum)
                start++;
            else if(towSum > sum)
                end--;
            else {
                res[0] = nums[start];
                res[1] = nums[end];
                return res;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = null;
        int[] nums2 = {1};
        int[] nums3 = {1, 3};
        int[] nums4 = {1, 3, 5, 8, 10, 15};
        int[] nums5 = {-5, -2, 0, 4, 9, 14, 18};
        int[] res1= solution.getTwoNumberWith(nums1, 0);
        int[] res2= solution.getTwoNumberWith(nums2, 1);
        int[] res3= solution.getTwoNumberWith(nums3, 4);
        int[] res4= solution.getTwoNumberWith(nums3, 5);
        int[] res5= solution.getTwoNumberWith(nums4, 15);
        int[] res6= solution.getTwoNumberWith(nums4, 13);
        int[] res7= solution.getTwoNumberWith(nums4, 20);
        int[] res8= solution.getTwoNumberWith(nums4, 26);
        int[] res9= solution.getTwoNumberWith(nums5, 13);
        int[] res10= solution.getTwoNumberWith(nums5, 18);
        int[] res11= solution.getTwoNumberWith(nums5, 4);
    }
}
