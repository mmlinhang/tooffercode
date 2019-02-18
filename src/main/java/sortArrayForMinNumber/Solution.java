package sortArrayForMinNumber;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 面试题45 把数组排序成最小的数
 */
public class Solution {

    public void printMinNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return;

        List<Integer> numsList = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++)
            numsList.add(nums[i]);

        numsList.sort(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                String s1 = ""+i1+i2;
                String s2 = ""+i2+i1;

                return s1.compareTo(s2);
            }
        });

        for(int i:numsList)
            System.out.print(i);
        System.out.println();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = null;
        int[] nums2 = {12};
        int[] nums3 = {3, 32, 321};
        int[] nums4 = {3, 3, 32, 321};

        solution.printMinNumber(nums1);
        solution.printMinNumber(nums2);
        solution.printMinNumber(nums3);
        solution.printMinNumber(nums4);
    }
}
