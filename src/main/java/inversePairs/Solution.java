package inversePairs;

import java.util.Arrays;

/**
 * 面试题51 数组中的逆序对
 */
public class Solution {

    public int getInversePairs(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int len = nums.length;
        int[] copy = new int[len];
        for(int i=0; i<len; i++)
            copy[i] = nums[i];

        return getInversePairsCore(nums, copy, 0, len-1);
    }

    private int getInversePairsCore(int[] nums, int[] copy, int start, int end) {
        if(start == end)
            return 0;

        int mid = (start+end)/2;
        int leftPairs = getInversePairsCore(copy, nums, start, mid);
        int rightPairs = getInversePairsCore(copy, nums, mid+1, end);

        int p1 = mid;
        int p2 = end;
        int pCopy = end;
        int count = 0;
        while(p1>=start && p2>=mid+1) {
            if(nums[p1] > nums[p2]) {
                count += p2-mid;
                copy[pCopy--] = nums[p1--];
            }
            else
                copy[pCopy--] = nums[p2--];
        }
        while(p1>=start)
            copy[pCopy--] = nums[p1--];
        while(p2>=mid+1)
            copy[pCopy--] = nums[p2--];

        return count+leftPairs+rightPairs;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = null;
        int[] nums2 = {};
        int[] nums3 = {1};
        int[] nums4 = {2, 1};
        int[] nums5 = {1, 2};
        int[] nums6 = {5, 4, 3, 2, 1, 0};
        int[] nums7 = {1, 2, 3, 4, 5, 6};
        int[] nums8 = {7, 5, 6, 4};
        System.out.println("测试用例1："+solution.getInversePairs(nums1));
        System.out.println("测试用例2："+solution.getInversePairs(nums2));
        System.out.println("测试用例3："+solution.getInversePairs(nums3));
        System.out.println("测试用例4："+solution.getInversePairs(nums4));
        System.out.println("测试用例5："+solution.getInversePairs(nums5));
        System.out.println("测试用例6："+solution.getInversePairs(nums6));
        System.out.println("测试用例7："+solution.getInversePairs(nums7));
        System.out.println("测试用例8："+solution.getInversePairs(nums8));
    }
}
