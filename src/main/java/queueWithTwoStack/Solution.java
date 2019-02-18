package queueWithTwoStack;

import java.util.Stack;

/**
 * 面试题9 用两个栈实现队列
 */
public class Solution<T> {
    private Stack<T> pushStack = new Stack<T>();
    private Stack<T> popStack = new Stack<T>();

    public void appendTail(T t) {
        pushStack.push(t);
    }

    public T deleteTail() {
        if(pushStack.isEmpty())
            return null;

        while(!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }

        T ret = popStack.pop();

        while(!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }

        return ret;
    }

    public void appendTail2(T t) {
        pushStack.push(t);
    }

    public T deleteTail2() {
        if(pushStack.isEmpty() && popStack.isEmpty())
            return null;

        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

        return popStack.pop();
    }

    public static void main(String[] args) {
        Solution<Integer> solution = new Solution<Integer>();

        // 测试用例
        System.out.println("测试用例1，没有元素："+solution.deleteTail());
        solution.appendTail2(1);
        solution.appendTail2(2);
        solution.appendTail2(3);
        solution.appendTail2(4);
        System.out.println("测试用例2："+solution.deleteTail2());
        solution.appendTail2(5);
        System.out.println("测试用例3："+solution.deleteTail2());
        System.out.println("测试用例4："+solution.deleteTail2());
    }
}
