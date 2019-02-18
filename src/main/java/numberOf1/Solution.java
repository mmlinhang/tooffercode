package numberOf1;

/**
 * 面试题43 1~n 整数中 1 出现的次数
 */
public class Solution {

    public int numberOf1(int n) {
        if(n < 1)
            return 0;

        return numberOf1Core(n+"");
    }

    // 假设 ns 为 xxxxx
    private int numberOf1Core(String ns) {
        if(ns.length() == 1) {
            if(ns.equals("0"))
                return 0;
            else
                return 1;
        }
        else {
            // 第一部分：计算 xxxx+1 ~ xxxxx
            // 先计算最高位为1的情况
            int firstNum = Integer.parseInt(ns.charAt(0)+"");
            int leftNum = Integer.parseInt(ns.substring(1));
            int bitCount = ns.length();
            int count = 0;
            if(firstNum == 1) {
                count += leftNum+1;
            }
            else {
                int hignestCount = 1;
                for(int i=1; i<bitCount; i++)
                    hignestCount *= 10;
                count += hignestCount;
            }
            // 再计算剩余位数
            count += firstNum*(bitCount-1)*Math.pow(10, bitCount-2);

            // 第二部分 1~xxxx
            count += numberOf1Core(ns.substring(1));

            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.numberOf1(0));
        System.out.println("测试用例2："+solution.numberOf1(1));
        System.out.println("测试用例3："+solution.numberOf1(9));
        System.out.println("测试用例4："+solution.numberOf1(10));
        System.out.println("测试用例5："+solution.numberOf1(12));
        System.out.println("测试用例6："+solution.numberOf1(15));
        System.out.println("测试用例7："+solution.numberOf1(21345));
    }
}
