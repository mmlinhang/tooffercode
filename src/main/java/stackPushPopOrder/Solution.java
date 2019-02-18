package stackPushPopOrder;

import java.util.Stack;

/**
 * 面试题31 栈的压入、弹出序列
 */
public class Solution {

    public boolean isPopOrder(int[] pushOrder, int[] popOrder) {
        if(pushOrder==null || popOrder==null || pushOrder.length!=popOrder.length)
            return false;

        int len = pushOrder.length;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<len; i++) {
            stack.push(pushOrder[i]);
            while(!stack.isEmpty()) {
                if(stack.peek() == popOrder[popIndex]) {
                    stack.pop();
                    popIndex++;
                }
                else
                    break;
            }
        }

        return popIndex == len;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] pushOrder1 = {1};
        int[] popOrder1 = {1};
        int[] pushOrder2 = {1, 2};
        int[] pushOrder3 = {1, 2, 3, 4, 5};
        int[] popOrder2 = {4, 5, 3, 2, 1};
        int[] popOrder3 = {4, 3, 5, 1, 2};
        System.out.println("测试用例1:"+solution.isPopOrder(pushOrder1, popOrder1));
        System.out.println("测试用例2:"+solution.isPopOrder(pushOrder2, popOrder1));
        System.out.println("测试用例3:"+solution.isPopOrder(pushOrder2, popOrder1));
        System.out.println("测试用例4:"+solution.isPopOrder(pushOrder3, popOrder2));
        System.out.println("测试用例5:"+solution.isPopOrder(pushOrder3, popOrder3));
    }
}
