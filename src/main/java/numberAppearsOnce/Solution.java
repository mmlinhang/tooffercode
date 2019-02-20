package numberAppearsOnce;

/**
 * 面试题56变体 数组中只出现一次的数字（数字只有一个，其他数字出现3次）
 */
public class Solution {

    public int getAppearOnceNum(int[] nums) {
        if(nums==null || nums.length==0)
            throw new RuntimeException("不存在");

        int[] sumBits = new int[32];
        for(int i=0; i<32; i++)
            sumBits[i] = 0;
        for(int i=0; i<nums.length; i++) {
            int mask = 1;
            for(int j=0; j<32; j++) {
                if((nums[i]&mask) != 0)
                    sumBits[j]++;
                mask <<= 1;
            }
        }

        int res = 0;
        for(int i=0; i<32; i++) {
            if(sumBits[i]%3 != 0) {
                int mask = 1;
                for(int j=0; j<i; j++)
                    mask <<= 1;
                res |= mask;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = null;
        int[] nums2 = {-1};
        int[] nums3 = {-3, -3, -3, -2};
        int[] nums4 = {3, 3, 3, -5, -5, -5, -2, 1, 1, 1};
        System.out.println("测试用例2："+solution.getAppearOnceNum(nums2));
        System.out.println("测试用例3："+solution.getAppearOnceNum(nums3));
        System.out.println("测试用例4："+solution.getAppearOnceNum(nums4));
        System.out.println("测试用例1："+solution.getAppearOnceNum(nums1));
    }
}
