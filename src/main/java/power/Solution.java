package power;

/**
 * 面试题16 数值的整数次方
 */
public class Solution {

    public double power(double base, int exponent) {
        if(base==0 && exponent<0)
            throw new RuntimeException("数值不符合规范");

        int unsignedExp = exponent<0 ? -exponent:exponent;
        double res = unsignedPower_2(base, unsignedExp);
        if(exponent < 0)
            res = 1/res;

        return res;
    }

    /**
     * 求非负次幂; 令 0 的 0 次幂为 1
     */
    private double unsignedPower(double base, int exponent) {
        double res = 1.0;
        for(int i=0; i<exponent; i++)
            res = res*base;

        return res;
    }

    /**
     * 高效求非负次幂
     */
    private double unsignedPower_2(double base, int exponent) {
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;

        double res = unsignedPower_2(base, exponent>>1);
        res*=res;
        if((exponent&0x1) == 1)
            res*=base;

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.power(1, 5));
        System.out.println("测试用例2："+solution.power(4, 5));
        System.out.println("测试用例3："+solution.power(4, 0));
        System.out.println("测试用例4："+solution.power(5, -2));
        System.out.println("测试用例4："+solution.power(0, -1));
    }
}
