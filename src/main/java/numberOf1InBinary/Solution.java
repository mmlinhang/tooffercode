package numberOf1InBinary;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 面试题15 二进制中1的个数
 */
public class Solution {
    /**
     * 法一：右移位+与运算
     * (也可左移位)
     */
    public int numberOf1(int num) {
        int count = 0;
        for(int i=0; i<32; i++) {
            if((num&1) == 1)
                count++;
            num >>= 1;
        }

        return count;
    }

    /**
     * 减1 再 与原数与运算
     */
    public int numberOf1_2(int num) {
        int count = 0;
        while(num != 0) {
            num = (num-1) & num;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.numberOf1(6));
        System.out.println("测试用例2："+solution.numberOf1(0));
        System.out.println("测试用例3："+solution.numberOf1(-1));
        System.out.println("测试用例1_2："+solution.numberOf1_2(6));
        System.out.println("测试用例2_2："+solution.numberOf1_2(0));
        System.out.println("测试用例3_2："+solution.numberOf1_2(-1));

        double d1 = 300000.000000000003;
        double d2 = 525.34e-1;
        if(d1 == 300000)
            System.out.println("can");
    }
}
