package uglyNumber;

/**
 * 面试题49 丑数
 */
public class Solution {

    public int kThNumber(int k) {
        if(k < 1)
            return -1;

        int[] uglyNumbers = new int[k];
        uglyNumbers[0] = 1;
        int p2=0, p3=0, p5=0;
        for(int i=1; i<k; i++) {
            int min = min(uglyNumbers[p2]*2, uglyNumbers[p3]*3, uglyNumbers[p5]*5);
            uglyNumbers[i] = min;
            if(uglyNumbers[p2]*2 == min)
                p2++;
            if(uglyNumbers[p3]*3 == min)
                p3++;
            if(uglyNumbers[p5]*5 == min)
                p5++;
        }

        return uglyNumbers[k-1];
    }

    private int min(int i1, int i2, int i3) {
        int min = i1>i2 ? i2:i1;

        return min>i3 ? i3:min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.kThNumber(0));
        System.out.println("测试用例2："+solution.kThNumber(1));
        System.out.println("测试用例3："+solution.kThNumber(2));
        System.out.println("测试用例4："+solution.kThNumber(3));
        System.out.println("测试用例5："+solution.kThNumber(4));
        System.out.println("测试用例6："+solution.kThNumber(5));
        System.out.println("测试用例7："+solution.kThNumber(6));
        System.out.println("测试用例8："+solution.kThNumber(7));
        System.out.println("测试用例9："+solution.kThNumber(8));
        System.out.println("测试用例10："+solution.kThNumber(10));
    }

    private boolean isUglyNumber(int num) {
        if(num < 1)
            return false;
        while(num%2 == 0)
            num /= 2;
        while(num%3 == 0)
            num /= 3;
        while(num%5 == 0)
            num /= 5;

        return num == 1;
    }
}
