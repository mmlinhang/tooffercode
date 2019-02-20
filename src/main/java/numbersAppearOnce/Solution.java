package numbersAppearOnce;

/**
 * 面试题56 数组中只出现一次的两个数字
 */
public class Solution {

    public int[] twoAppearOnce(int[] nums) {
        if(nums==null || nums.length<2)
            return null;

        // 对每个数字进行异或运算，得到两个只出现一次的两个数字的异或结果
        int exRes = 0;
        for(int i=0; i<nums.length; i++)
            exRes ^= nums[i];

        // 找出 exRes(二进制) 中第一位 1 的位置
        int first1 = findFirst1(exRes);

        // 分成两组，每组包含一个只出现一次的数字和出现两次的数字
        int num1=0, num2=0;
        for(int i=0; i<nums.length; i++) {
            if(digitInIndexOf(nums[i], first1) == 0)
                num1 ^= nums[i];
            else
                num2 ^= nums[i];
        }
        int[] res = {num1, num2};

        return res;
    }

    private int findFirst1(int num) {
        int mask = 1;
        for(int i=0; i<32; i++) {
            if((num&mask) != 0)
                return i;
            else
                mask <<= 1;
        }

        return -1;
    }

    private int digitInIndexOf(int num, int index) {
        int mask = 1;
        for(int i=0; i<index; i++)
            mask <<= 1;

        return num&mask;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = null;
        int[] nums2 = {1};
        int[] nums3 = {1, 2};
        int[] nums4 = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] res1 = solution.twoAppearOnce(nums1);
        int[] res2 = solution.twoAppearOnce(nums2);
        int[] res3 = solution.twoAppearOnce(nums3);
        int[] res4 = solution.twoAppearOnce(nums4);
    }
}
