package skipStep;

/**
 * 面试题10变体 跳台阶问题
 */
public class Solution {
    /**
     * 经分析可得，该问题即为求解斐波那契数列第n项数
     */
    public long fibonacci(int n) {
        if(n <= 0)
            return 0;
        if(n == 1 || n == 2)
            return n;

        long first=1, second=2;
        for(int i=0; i<n-2; i++) {
            long next = first+second;
            first = second;
            second = next;
        }

        return second;
    }

    public static void main(String[] args) {

    }
}
