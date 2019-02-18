package cutRope;

/**
 * 面试题14 剪绳子
 */
public class Solution {

    /**
     * 动态规划
     */
    public int maxOfCut(int length) {
        if(length < 2)
            return 0;
        if(length == 2)
            return 1;
        if(length == 3)
            return 2;

        int[] products = new int[length+1];
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for(int i=4; i<=length; i++) {
            int max = 0;
            for(int j=1; j<=i/2; j++) {
                int p = products[j]*products[i-j];
                if(p > max)
                    max = p;
            }
            products[i] = max;
        }

        return products[length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.maxOfCut(1));
        System.out.println("测试用例2："+solution.maxOfCut(2));
        System.out.println("测试用例3："+solution.maxOfCut(3));
        System.out.println("测试用例4："+solution.maxOfCut(4));
        System.out.println("测试用例5："+solution.maxOfCut(10));
    }
}
