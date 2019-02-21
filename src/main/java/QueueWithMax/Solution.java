package QueueWithMax;

import java.util.ArrayDeque;
/**
 * 面试题59变体 队列的最大值
 */
public class Solution {
    private ArrayDeque<Integer> queue;
    private ArrayDeque<Integer> maxInQueue;

    public Solution() {
        queue = new ArrayDeque<Integer>();
        maxInQueue = new ArrayDeque<Integer>();
    }

    public void offer(int num) {
        while(!maxInQueue.isEmpty() && maxInQueue.peekLast()<num)
            maxInQueue.pollLast();
        maxInQueue.offerLast(num);
        queue.offer(num);
    }

    public int poll() {
        if(queue.isEmpty())
            throw new RuntimeException("队列为空");

        int res = queue.poll();
        if(res == maxInQueue.peekFirst())
            maxInQueue.pollFirst();

        return res;
    }

    public int max() {
        if(queue.isEmpty())
            throw new RuntimeException("队列为空");

        return maxInQueue.peekFirst();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        try {
            solution.poll();
        }
        catch (Exception e) {
            System.out.println("测试用例1：队列为空");
        }
        solution.offer(4);
        System.out.println("测试用例2："+solution.max());
        solution.offer(3);
        System.out.println("测试用例3："+solution.max());
        solution.offer(8);
        System.out.println("测试用例4："+solution.max());
        solution.poll();
        System.out.println("测试用例5："+solution.max());
        solution.poll();
        System.out.println("测试用例6："+solution.max());
        solution.offer(5);
        System.out.println("测试用例7："+solution.max());
        solution.poll();
        System.out.println("测试用例8："+solution.max());
    }
}
