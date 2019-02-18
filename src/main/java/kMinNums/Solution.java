package kMinNums;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 面试题40 最小的k个数
 */
public class Solution {

    /**
     * 法一：partition法
     */
    public int[] getKMinNums(int[] nums, int k) {
        if(nums==null || nums.length==0 || nums.length<k || k<0)
            return null;

        int[] res = new int[k];
        int start=0, end=nums.length-1;
        int index = partition(nums, start, end);
        if(k-1 >= 0) {
            while(index != k-1) {
                if(index > k-1) {
                    end = index-1;
                    index = partition(nums, start, end);
                }
                else {
                    start = index + 1;
                    index = partition(nums, start, end);
                }
            }
        }


        for(int i=0; i<=k-1; i++) {
            res[i] = nums[i];
        }

        return res;
    }

    private int partition(int[] nums, int start, int end) {
        int key = nums[start];
        while(start < end) {
            while(start<end && nums[end]>key)
                end--;
            if(start < end)
                nums[start++] = nums[end];
            while(start<end && nums[start]<key)
                start++;
            if(start < end)
                nums[end--] = nums[start];
        }
        nums[start] = key;

        return start;
    }

    /**
     * 法二：最大堆法。
     *      用最大堆保存当前k个最小的值
     */
    public int[] getKMinNums2(int[] nums, int k) {
        if(nums==null || nums.length==0 || k>nums.length || k<0)
            return null;
        if(k == 0)
            return new int[0];

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i=0; i<k; i++) {
            heap.offer(nums[i]);
        }
        for(int i=k; i<nums.length; i++) {
            if(heap.peek() > nums[i]) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++)
            res[i] = heap.poll();

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] res1 = solution.getKMinNums2(null, 0);
        int[] nums1 = {};
        int[] res2 = solution.getKMinNums2(nums1, 0);
        int[] nums2 = {1};
        int[] res3 = solution.getKMinNums2(nums2, 1);
        int[] nums3 = {1, 5, 2};
        int[] res4 = solution.getKMinNums2(nums3, 2);
        int[] res5 = solution.getKMinNums2(nums3, 3);
        int[] res6 = solution.getKMinNums2(nums3, 4);
        int[] res7 = solution.getKMinNums2(nums3, 0);
        int[] nums4 = {4, 3, 2, 1, 9, 0, 8, 4, 5, 3};
        int[] res8 = solution.getKMinNums2(nums4, 5);
    }
}
