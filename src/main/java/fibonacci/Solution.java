package fibonacci;

/**
 * 面试题10 斐波那契数列
 */
public class Solution {

    /**
     * 循环法
     */
    public long fibonacci(int n) {
        if(n < 0)
            return -1;
        else if(n == 0 || n == 1)
            return n;

        long first=0, second=1;
        for(int i=1; i<n; i++) {
            long next = first+second;
            first = second;
            second = next;
        }

        return second;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("n为-1："+solution.fibonacci(-1));
        System.out.println("n为0："+solution.fibonacci(0));
        System.out.println("n为1："+solution.fibonacci(1));
        System.out.println("n为10："+solution.fibonacci(10));
        System.out.println("n为15："+solution.fibonacci(15));
    }
}
