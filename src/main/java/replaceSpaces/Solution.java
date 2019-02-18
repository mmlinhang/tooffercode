package replaceSpaces;

/**
 * 面试题5 替换空格
 * 要求：不能使用额外的字符数组，即在当前字符数组上进行替换
 */
public class Solution {
    // 直接替换法
    // 后面的字符串多次移动
    // 时间复杂度为 O(n^2)

    /**
     * 从后往前进行替换
     * 时间复杂度为 O(n)
     * str 有足够的空间进行扩展
     * len 为字符串的真实长度
     */
    public void replace(char[] str, int len) {
        if(str == null || len < 0)
            return;
        int spaceCount = spaceCount(str, len);
        int newP = len+spaceCount*2-1;
        int preP = len-1;

        while(preP >= 0) {
            if(str[preP] == ' ') {
                str[newP--] = '0';
                str[newP--] = '2';
                str[newP--] = '%';
            }
            else {
                str[newP--] = str[preP];
            }
            preP--;
        }
    }

    private int spaceCount(char[] str, int len) {
        int count = 0;
        for(int i=0; i<len; i++) {
            if(str[i] == ' ')
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //测试用例
        char[] str1 = "we are family    ".toCharArray();
        int len1 = 13;
        char[] str2 = "i love you?  and you            ".toCharArray();
        int len2 = 20;
        char[] str3 = "".toCharArray();
        int len3 = 0;
        char[] str4 = "i".toCharArray();
        int len4 = 1;

        solution.replace(str1, len1);
        solution.replace(str2, len2);
        solution.replace(str3, len3);
        solution.replace(str4, len4);
        System.out.println("测试用例1："+new String(str1));
        System.out.println("测试用例2："+new String(str2));
        System.out.println("测试用例3："+new String(str3));
        System.out.println("测试用例4："+new String(str4));
    }
}
