package longestSubStringWithoutDup;

/**
 * 面试题48 最长的不包含重复字符的子字符串
 */
public class Solution {

    public  int maxLength(String str) {
        if(str==null || str.length()==0)
            return 0;

        int curSubLen = 0;
        int maxLen = 0;
        int[] preIndexes = new int[26];
        for(int i=0; i<26; i++)
            preIndexes[i] = -1;
        for(int i=0; i<str.length(); i++) {
            int preIndex = preIndexes[str.charAt(i)-'a'];
            if(preIndex==-1 || i-preIndex>curSubLen) {
                curSubLen++;
            }
            else {
                curSubLen = i-preIndex;
            }
            if(curSubLen > maxLen)
                maxLen = curSubLen;
            preIndexes[str.charAt(i)-'a'] = i;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.maxLength(null));
        System.out.println("测试用例1："+solution.maxLength(""));
        System.out.println("测试用例1："+solution.maxLength("arabcacfr"));
        System.out.println("测试用例1："+solution.maxLength("aabbcddefgh"));
    }
}
