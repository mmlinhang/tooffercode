package firstNotDupChar;

import java.util.HashMap;

/**
 * 面试题50 第一个只出现一次的字符
 */
public class Solution {

    public Character getFirstNotDupChar(String str) {
        if(str==null || str.length()==0)
            return null;

        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        for(int i=0; i<str.length(); i++) {
            char curChar = str.charAt(i);
            if(countMap.containsKey(curChar))
                countMap.put(curChar, countMap.get(curChar)+1);
            else
                countMap.put(curChar, 1);
        }
        for(int i=0; i<str.length(); i++)
            if(countMap.get(str.charAt(i)) == 1)
                return str.charAt(i);

        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.getFirstNotDupChar(null));
        System.out.println("测试用例2："+solution.getFirstNotDupChar(""));
        System.out.println("测试用例3："+solution.getFirstNotDupChar("a"));
        System.out.println("测试用例4："+solution.getFirstNotDupChar("abbcadefc"));
        System.out.println("测试用例5："+solution.getFirstNotDupChar("aa"));
        System.out.println("测试用例6："+solution.getFirstNotDupChar("abcccabcefghfhe"));
    }
}
