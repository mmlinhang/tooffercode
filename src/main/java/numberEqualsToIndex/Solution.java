package numberEqualsToIndex;

/**
 * 面试题53变体2 数组中数值等于其下表的元素
 */
public class Solution {

    public int getNumberEqualsToIndex(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        int start=0, end=nums.length-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(nums[mid] == mid)
                return mid;
            else if(nums[mid] > mid)
                end = mid-1;
            else
                start = mid+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = null;
        int[] nums2 = {0};
        int[] nums3 = {1};
        int[] nums4 = {-2, -1, 0, 3, 5, 8};
        int[] nums5 = {0, 2, 3, 4, 6};
        int[] nums6 = {-3, -2, 0, 3, 4, 7};
        int[] nums7 = {-2, -1, 0, 1, 4};
        System.out.println("测试用例1："+solution.getNumberEqualsToIndex(nums1));
        System.out.println("测试用例2："+solution.getNumberEqualsToIndex(nums2));
        System.out.println("测试用例3："+solution.getNumberEqualsToIndex(nums3));
        System.out.println("测试用例4："+solution.getNumberEqualsToIndex(nums4));
        System.out.println("测试用例5："+solution.getNumberEqualsToIndex(nums5));
        System.out.println("测试用例6："+solution.getNumberEqualsToIndex(nums6));
        System.out.println("测试用例7："+solution.getNumberEqualsToIndex(nums7));
    }
}
