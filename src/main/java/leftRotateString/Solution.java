package leftRotateString;

/**
 * 面试题58变体 左旋转字符串
 */
public class Solution {

    public String leftRotate(String str, int k) {
        if(str==null || k<0 || k>str.length())
            return str;

        char[] chs = str.toCharArray();
        reverseChars(chs, 0, k-1);
        reverseChars(chs, k, chs.length-1);
        reverseChars(chs, 0, chs.length-1);

        return new String(chs);
    }

    private void reverseChars(char[] chs, int start, int end) {
        if(start > end)
            return;
        for(int i=start; i<=(start+end)/2; i++) {
            int dis = i-start;
            char temp = chs[i];
            chs[i] = chs[end-dis];
            chs[end-dis] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.leftRotate("", 0));
        System.out.println("测试用例2："+solution.leftRotate("a", 0));
        System.out.println("测试用例3："+solution.leftRotate("a", 1));
        System.out.println("测试用例4："+solution.leftRotate("abcdefg", 3));
        System.out.println("测试用例5："+solution.leftRotate("abcdefg", 4));
        System.out.println("测试用例6："+solution.leftRotate("abcdefg", 7));
    }
}
