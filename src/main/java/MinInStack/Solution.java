package MinInStack;

import java.util.Stack;

/**
 * 面试题30 栈中的最小值
 */
public class Solution {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int val) {
        stack1.push(val);
        if(stack2.isEmpty())
            stack2.push(val);
        else {
            if(stack2.peek() > val)
                stack2.push(val);
            else
                stack2.push(stack2.peek());
        }
    }

    public int pop() {
        if(stack1.isEmpty())
            throw new RuntimeException("Stack is empty");
        stack2.pop();
        return stack1.pop();
    }

    public int min() {
        if(stack1.isEmpty())
            throw new RuntimeException("Stack is empty");
        return stack2.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
//        solution.pop();
        solution.push(3);
        System.out.println("测试用例1: "+solution.min());
        solution.push(4);
        System.out.println("测试用例2: "+solution.min());
        solution.push(2);
        System.out.println("测试用例3: "+solution.min());
        solution.pop();
        System.out.println("测试用例4: "+solution.min());
        solution.pop();
        System.out.println("测试用例5: "+solution.min());
        solution.push(3);
        System.out.println("测试用例6: "+solution.min());
    }
}
