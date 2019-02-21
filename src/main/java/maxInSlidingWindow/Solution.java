package maxInSlidingWindow;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * 面试题59 滑动窗口的最大值
 */
public class Solution {

    public int[] maxInSlidingWindow(int[] nums, int winLen) {
        if(nums==null || nums.length==0 || winLen>nums.length || winLen<1)
            return null;

        int start=0, end=0;
        int len = nums.length;
        Deque<Integer> maxInWin = new ArrayDeque<Integer>();
        int[] res = new int[len-winLen+1];
        int index=0;
        while(end < nums.length) {
            int curNum = nums[end];
            while(!maxInWin.isEmpty() && nums[maxInWin.peekLast()]<curNum)
                maxInWin.pollLast();
            maxInWin.offerLast(end);

            if(maxInWin.peekFirst() < start)
                maxInWin.pollFirst();

            int curWinLen = end-start+1;
            if(curWinLen == winLen) {
                res[index++] = nums[maxInWin.peekFirst()];
                start++;
            }
            end++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = null;
        int[] nums2 = {6};
        int[] nums3 = {6, 18};
        int[] nums4 = {5, 15, -9};
        int[] nums5 = {2, 3, 4, 2, 6, 2, 5, 1};
        int[] nums6 = {6, 4, 5, 8, 3, 4};
        int[] res1 = solution.maxInSlidingWindow(nums1, 1);
        int[] res2 = solution.maxInSlidingWindow(nums2, 1);
        int[] res3 = solution.maxInSlidingWindow(nums2, 2);
        int[] res4 = solution.maxInSlidingWindow(nums2, 0);
        int[] res5 = solution.maxInSlidingWindow(nums3, 2);
        int[] res6 = solution.maxInSlidingWindow(nums3, 1);
        int[] res7 = solution.maxInSlidingWindow(nums4, 2);
        int[] res8 = solution.maxInSlidingWindow(nums4, 3);
        int[] res9 = solution.maxInSlidingWindow(nums5, 3);
        int[] res10 = solution.maxInSlidingWindow(nums5, 4);
        int[] res11 = solution.maxInSlidingWindow(nums5, 5);
        int[] res12 = solution.maxInSlidingWindow(nums6, 2);
    }
}
