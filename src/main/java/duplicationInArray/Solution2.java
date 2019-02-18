package duplicationInArray;

/**
 * 剑指offer 面试题三变体
 * n+1 个 1~~ n之间的数； 不允许改变输入数组
 */
public class Solution2 {
    //哈希法，同面试题三解法，lve

    /**
     * 类二分法
     * 时间复杂度O(nlogn)，空间复杂度O(1)
     */
    public int duplicate(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1)
            return -1;

        int left=1, right=nums.length-1;
        int mid;

        while(left < right) {
            mid = (left+right)/2;
            if(countByRange(left, mid, nums) == mid-left+1)
                left = mid+1;
            else
                right = mid;
        }

        return left;
    }

    /**
     * 计算数组中在 min - max 之间的数的个数
     */
    private int countByRange(int min, int max, int[] nums) {
        if(min > max || nums == null)
            return 0;

        int count = 0;
        for(int num:nums) {
            if(num >= min && num <= max) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        // 测试用例
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 5};
        int[] nums2 = {};
        int[] nums3 = {1, 2, 3, 4, 5, 6, 6, 6, 6};
        int[] nums4 = {1, 4, 2, 3, 3, 6, 4};

        System.out.println("类二分法，测试用例一："+solution2.duplicate(nums1));
        System.out.println("类二分法，测试用例二："+solution2.duplicate(nums2));
        System.out.println("类二分法，测试用例三："+solution2.duplicate(nums3));
        System.out.println("类二分法，测试用例四："+solution2.duplicate(nums4));
        System.out.println("类二分法，测试用例五："+solution2.duplicate(null));
    }
}
