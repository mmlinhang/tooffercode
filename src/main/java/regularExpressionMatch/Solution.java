package regularExpressionMatch;

/**
 * 面试题19 正则表达式匹配
 */
public class Solution {

    public boolean matches(String str, String pattern) {
        if(str==null || pattern==null)
            return false;

        return matchesCore(str, pattern, 0, 0);
    }

    private boolean matchesCore(String str, String pattern, int strIndex, int patternIndex) {
        int strLen=str.length(), patLen=pattern.length();
        if(strLen==strIndex && patLen==patternIndex)
            return true;
        if(strIndex<strLen && patternIndex==patLen)
            return false;

        if(patternIndex<patLen-1 && pattern.charAt(patternIndex+1)=='*') {
            if(strIndex<strLen &&
                    (pattern.charAt(patternIndex)==str.charAt(strIndex) || pattern.charAt(patternIndex)=='.'))
                return matchesCore(str, pattern, strIndex+1, patternIndex+2)
                || matchesCore(str, pattern, strIndex+1, patternIndex)
                || matchesCore(str, pattern, strIndex, patternIndex+2);
            else
                return matchesCore(str, pattern, strIndex, patternIndex+2);
        }
        if(strIndex<strLen &&
                (pattern.charAt(patternIndex)==str.charAt(strIndex) || pattern.charAt(patternIndex)=='.'))
            return matchesCore(str, pattern, strIndex+1, patternIndex+1);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.matches("aabbcc", "aabbcc"));
        System.out.println("测试用例2："+solution.matches("aabbcc", "a*b*c*"));
        System.out.println("测试用例3："+solution.matches("aabbcc", "a.b*c*"));
        System.out.println("测试用例4："+solution.matches("aabbcc", "aab*c*d*"));
        System.out.println("测试用例5："+solution.matches("aabbcc", "aab*"));
        System.out.println("测试用例6："+solution.matches("aabbcc", "a.b*c*."));
        System.out.println("测试用例7："+solution.matches("aabbcc", "a.b*c*.dd"));
        System.out.println("测试用例7："+solution.matches("", "a*"));
        System.out.println("测试用例8："+solution.matches("", "."));
    }
}
