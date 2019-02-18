package print1ToMaxNNum;

/**
 * 面试题17 打印从1到最大的n位整数
 */
public class Solution {

    public void print(int n) {
        if(n <= 0)
            return;
        Number number = new Number(n);
        while(number.inc()) {
            number.print();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1：");
        solution.print(3);
        System.out.println("测试用例2：");
        solution.print(0);
        System.out.println("测试用例3：");
        solution.print(-1);
        System.out.println("测试用例4：");
        solution.print(5);
    }
}

class Number {
    private char[] num;

    public Number(int n) {
        num = new char[n];
        for(int i=0; i<n; i++)
            num[i] = '0';
    }

    /**
     * 改进 isMax 函数，这里的时间复杂度为 O(n)
     * 弃用该函数
     */
    public boolean isMax() {
        for(int i=0; i<num.length; i++) {
            if(num[i] != '9')
                return false;
        }
        return true;
    }

    /**
     * @return true 为可增；false 为不可增
     */
    public boolean inc() {
        int index = num.length-1;
        while(index >= 0) {
            if(num[index] == '9')
                num[index--] = '0';
            else {
                num[index]++;
                return true;
            }
        }

        return false;
    }

    public void print() {
        int index = 0;
        while(index<num.length && num[index]=='0')
            index++;
        if(index == num.length)
            System.out.print("0");
        for(int i=index; i<num.length; i++) {
            System.out.print(num[i]);
        }
        System.out.println();
    }
}
