package stringPermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题38 字符串的排列
 */
public class Solution {

    public void printPermutation(String s) {
        if(s==null || s.length()==0)
            return;

        char[] permutation = new char[s.length()];
        for(int i=0; i<s.length(); i++)
            permutation[i] = s.charAt(i);
        printPermutationCore(permutation, 0);
    }

    private void printPermutationCore(char[] permutation, int level) {
        if(level == permutation.length)
            System.out.println(new String(permutation));
        else {
            for(int i=level; i<permutation.length; i++) {
                char tmp = permutation[level];
                permutation[level] = permutation[i];
                permutation[i] = tmp;
                printPermutationCore(permutation, level+1);
                tmp = permutation[level];
                permutation[level] = permutation[i];
                permutation[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1：");
        solution.printPermutation(null);
        System.out.println("测试用例2：");
        solution.printPermutation("");
        System.out.println("测试用例3：");
        solution.printPermutation("a");
        System.out.println("测试用例4：");
        solution.printPermutation("ab");
        System.out.println("测试用例5：");
        solution.printPermutation("abc");
        System.out.println("测试用例6：");
        solution.printPermutation("abcd");
    }
}
