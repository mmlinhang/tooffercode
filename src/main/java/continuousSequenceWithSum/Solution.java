package continuousSequenceWithSum;

/**
 * 面试题57 和为 s 的连续正数序列
 */
public class Solution {

    public void printSequenceWithSum(int sum) {
        int start=1, end=2;
        int curSum = start+end;
        while(start<end) {
            if(curSum == sum) {
                for(int i=start; i<=end; i++)
                    System.out.print(i+" ");
                System.out.println();
                curSum -=start;
                start++;
            }
            else if(curSum < sum) {
                end++;
                curSum += end;
            }
            else {
                curSum -= start;
                start++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1：");
        solution.printSequenceWithSum(-1);
        System.out.println("测试用例2：");
        solution.printSequenceWithSum(0);
        System.out.println("测试用例3：");
        solution.printSequenceWithSum(1);
        System.out.println("测试用例4：");
        solution.printSequenceWithSum(2);
        System.out.println("测试用例5：");
        solution.printSequenceWithSum(15);
        System.out.println("测试用例6：");
        solution.printSequenceWithSum(21);
        System.out.println("测试用例7：");
        solution.printSequenceWithSum(6);
    }
}
