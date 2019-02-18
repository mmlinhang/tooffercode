package digitInSequence;

/**
 * 面试题44 数字序列中的第n位数字
 */
public class Solution {

    public int numberOfN(int n) {
        if(n < 0)
            return -1;

        int bitCount = 2;
        int total = 10;
        if(n < total)
            return n;
        while(true) {
            int numberCountOfTheBit = 9*baseOf10(bitCount-1);
            if(n < total+numberCountOfTheBit*bitCount) {
                int numTh = (n-total)/bitCount;
                int bitTh = (n-total)%bitCount;
                int number =  numTh+baseOf10(bitCount-1);
                return Integer.parseInt(new String(number+"").substring(bitTh, bitTh+1));
            }
            else {
                total += numberCountOfTheBit*bitCount;
                bitCount++;
            }

        }
    }

    private int baseOf10(int n) {
        int res = 1;
        for(int i=0; i<n; i++)
            res *= 10;

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.numberOfN(-1));
        System.out.println("测试用例2："+solution.numberOfN(0));
        System.out.println("测试用例3："+solution.numberOfN(5));
        System.out.println("测试用例4："+solution.numberOfN(13));
        System.out.println("测试用例5："+solution.numberOfN(19));
    }
}