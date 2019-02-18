package translateNumber2String;

/**
 * 面试题46 把数字翻译成字符串
 */
public class Solution {

    public int translateCount(int number) {
        if(number < 0)
            return 0;

        String numStr = number+"";
        int[] subCount = new int[numStr.length()+1];
        int len = subCount.length;
        if(len == 1)
            return 1;

        subCount[len-1] = 1;
        subCount[len-2] = 1;
        for(int i=len-3; i>=0; i--) {
            if(numStr.substring(i, i+2).compareTo("25") <= 0)
                subCount[i] = subCount[i+1]+subCount[i+2];
            else
                subCount[i] = subCount[i+1];
        }

        return subCount[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.translateCount(-1));
        System.out.println("测试用例2："+solution.translateCount(0));
        System.out.println("测试用例3："+solution.translateCount(5));
        System.out.println("测试用例4："+solution.translateCount(25));
        System.out.println("测试用例5："+solution.translateCount(12258));
        System.out.println("测试用例6："+solution.translateCount(78158));
        System.out.println("测试用例7："+solution.translateCount(26));
    }
}
