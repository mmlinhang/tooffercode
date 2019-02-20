package missingNumber;

/**
 * 面试题53变体 0~n-1 之间缺失的数字
 */
public class Solution {

    public int getMissingNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        int start=0, end=nums.length-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(nums[mid] == mid)
                start = mid+1;
            else {
                if(mid-1 < 0)
                    return 0;
                else if(nums[mid-1] == mid-1)
                    return mid;
                else
                    end = mid-1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = null;
        int[] nums2 = {0};
        int[] nums3 = {1};
        int[] nums4 = {1, 2};
        int[] nums5 = {0, 1};
        int[] nums6 = {0, 1, 2, 3, 5, 6, 7};
        int[] nums7 = {1, 2, 3, 4, 5};
        int[] nums8 = {0, 1, 2, 3, 4, 6};
        int[] nums9 = {0, 1, 2, 3, 4, 5};
        System.out.println("测试用例1："+solution.getMissingNumber(nums1));
        System.out.println("测试用例2："+solution.getMissingNumber(nums2));
        System.out.println("测试用例3："+solution.getMissingNumber(nums3));
        System.out.println("测试用例4："+solution.getMissingNumber(nums4));
        System.out.println("测试用例5："+solution.getMissingNumber(nums5));
        System.out.println("测试用例6："+solution.getMissingNumber(nums6));
        System.out.println("测试用例7："+solution.getMissingNumber(nums7));
        System.out.println("测试用例8："+solution.getMissingNumber(nums8));
        System.out.println("测试用例9："+solution.getMissingNumber(nums9));
    }
}
