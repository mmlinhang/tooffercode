package stackWithTwoQueue;

import java.util.LinkedList;

/**
 * 面试题9变体 用两个队列实现栈
 */
public class Solution<T> {

    private LinkedList<T> queue1 = new LinkedList<T>();
    private LinkedList<T> queue2 = new LinkedList<T>();

    public void push(T t) {
        if(!queue2.isEmpty()) {
            queue2.offer(t);
        }
        queue1.offer(t);
    }

    public T pop() {
        if(!queue1.isEmpty()) {
            while(queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
        else if(!queue2.isEmpty()) {
            while(queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        else {
            throw new RuntimeException("栈为空");
        }
    }

    public static void main(String[] args) {
        Solution<Integer> stack = new Solution<Integer>();

        // 测试用例
        try {
            System.out.println("测试用例1："+stack.pop());
        }
        catch (RuntimeException e) {
            System.out.println("测试用例1：栈为空");
        }
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("测试用例2："+stack.pop());
        stack.push(4);
        stack.push(5);
        System.out.println("测试用例1："+stack.pop());
    }
}
