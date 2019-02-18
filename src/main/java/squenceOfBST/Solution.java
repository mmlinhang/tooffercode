package squenceOfBST;

/**
 * 面试题33 二叉树的后序遍历序列
 */
public class Solution {

    public boolean isPostSequence(int[] postSequence) {
        if(postSequence==null || postSequence.length==0)
            return false;

        int len = postSequence.length;
        return isPostSequenceCore(postSequence, 0, len);
    }

    private boolean isPostSequenceCore(int[] postSequence, int start, int end) {
        if(end <= start+1)
            return true;

        int boundry = findBoundry(postSequence, start, end);
        if(!isAllGreater(postSequence, boundry, end-1))
            return false;

        return isPostSequenceCore(postSequence, start, boundry)
                && isPostSequenceCore(postSequence, boundry, end-1);
    }

    private int findBoundry(int[] postSequence, int start, int end) {
        int key = postSequence[end-1];
        int i;
        for(i=start; i<end-1; i++) {
            if(postSequence[i] > key)
                break;
        }

        return i;
    }

    private boolean isAllGreater(int[] postSequence, int start, int end) {
        for(int i=start; i<end; i++) {
            if(postSequence[i] < postSequence[end])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] postSequence1 = {5, 7, 6, 9, 11, 10, 8};
        int[] postSequence2 = {7, 4, 6, 5};
        int[] postSequence3 = {7};
        int[] postSequence4 = null;
        int[] postSequence5 = {17, 15, 12, 10, 8};
        int[] postSequence6 = {-2, 3, 1, -1, 2, 1, 0};
        int[] postSequence7 = {1, 2, 3, 4, 5};
        System.out.println("测试用例1："+solution.isPostSequence(postSequence1));
        System.out.println("测试用例2："+solution.isPostSequence(postSequence2));
        System.out.println("测试用例3："+solution.isPostSequence(postSequence3));
        System.out.println("测试用例4："+solution.isPostSequence(postSequence4));
        System.out.println("测试用例5："+solution.isPostSequence(postSequence5));
        System.out.println("测试用例6："+solution.isPostSequence(postSequence6));
        System.out.println("测试用例7："+solution.isPostSequence(postSequence7));
    }
}
