package stringCombination;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题38变体 字符串组合
 */
public class Solution {

    public void printCombination(String s) {
        if(s==null || s.length()==0)
            return;

        char[] chs = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            chs[i] = s.charAt(i);
        }
        printCombinationCore(chs, new ArrayList<Character>(), 0);
    }

    private void printCombinationCore(char[] chs, List<Character> combination, int index) {
        if(index == chs.length) {
            if(combination.size() != 0)
                System.out.println(combination);
        }
        else {
            printCombinationCore(chs, combination, index+1);
            combination.add(chs[index]);
            printCombinationCore(chs, combination, index+1);
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1：");
        solution.printCombination("");
        System.out.println("测试用例2：");
        solution.printCombination("a");
        System.out.println("测试用例3：");
        solution.printCombination("ab");
        System.out.println("测试用例4：");
        solution.printCombination("abc");
        System.out.println("测试用例5：");
        solution.printCombination("abcd");
    }
}
