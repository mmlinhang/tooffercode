package reverseWords;

/**
 * 面试题58 翻转单词顺序
 */
public class Solution {

    public String reverseWords(String sentence) {
        if(sentence==null || sentence.length()==0)
            return sentence;

        int len = sentence.length();
        char[] chs = sentence.toCharArray();
        reverseChars(chs, 0, len-1);

        int start=0, end=0;
        while(end < len) {
            if(chs[start] == ' ') {
                start++;
                end++;
            }
            while(end < len) {
                if(chs[end] != ' ')
                    end++;
                else
                    break;
            }
            reverseChars(chs, start, end-1);
            start = end+1;
            end++;
        }

        return new String(chs);
    }

    private void reverseChars(char[] chs, int start, int end) {
        for(int i=start; i<=(start+end)/2; i++) {
            char temp = chs[i];
            int dis = i-start;
            chs[i] = chs[end-dis];
            chs[end-dis] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.reverseWords(null));
        System.out.println("测试用例2："+solution.reverseWords(""));
        System.out.println("测试用例3："+solution.reverseWords("hello."));
        System.out.println("测试用例4："+solution.reverseWords("hello world."));
        System.out.println("测试用例5："+solution.reverseWords("hello java world."));
        System.out.println("测试用例6："+solution.reverseWords("are you ok? "));
        System.out.println("测试用例7："+solution.reverseWords(" "));
    }
}
