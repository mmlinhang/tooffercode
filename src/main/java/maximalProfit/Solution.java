package maximalProfit;

/**
 * 面试题63 股票的最大利润
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return -1;

        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int i=0; i<prices.length; i++) {
            if(prices[i] < min)
                min = prices[i];
            if(prices[i]-min > max)
                max = prices[i]-min;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] prices1 = null;
        int[] prices2 = {2};
        int[] prices3 = {1, 2, 3, 4, 5};
        int[] prices4 = {5, 4, 3, 2, 1};
        int[] prices5 = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println("测试用例1："+solution.maxProfit(prices1));
        System.out.println("测试用例2："+solution.maxProfit(prices2));
        System.out.println("测试用例3："+solution.maxProfit(prices3));
        System.out.println("测试用例4："+solution.maxProfit(prices4));
        System.out.println("测试用例5："+solution.maxProfit(prices5));
    }
}
