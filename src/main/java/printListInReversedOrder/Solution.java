package printListInReversedOrder;

import java.util.Stack;

/**
 * 面试题6 从尾到头打印链表
 */
public class Solution {
    /**
     * 翻转链表法(可以在原链表上进行翻转，也可以形成一个新的倒叙链表)
     */
    public void print(ListNode head) {
        if(head == null)
            return;

        ListNode now = head, pre = null, next = now.next;
        now.next = pre;

        while(next != null) {
            pre = now;
            now = next;
            next = now.next;
            now.next = pre;
        }

        ListNode p = now;
        while(p != null) {
            System.out.println(p.value);
            p = p.next;
        }
    }

    /**
     * 栈法
     */
    public void print2(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode p = head;
        while(p != null) {
            stack.push(p.value);
            p = p.next;
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }

    /**
     * 递归法
     */
    public void print3(ListNode head) {
        if(head == null)
            return;

        print3(head.next);
        System.out.print(head.value+" ");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        ListNode head1 = new ListNode();
        head1.value = 1;

        ListNode head2 = new ListNode();
        head2.value = 1;
        ListNode next1 = new ListNode();
        next1.value = 2;
        head2.next = next1;
        ListNode next2 = new ListNode();
        next2.value = 3;
        next1.next = next2;

        ListNode head3 = null;

        System.out.println("测试用例1，栈法：");solution.print2(head1);
        System.out.println("测试用例2，栈法：");solution.print2(head2);
        System.out.println("测试用例3，栈法：");solution.print2(head3);
        System.out.println("测试用例1，递归法：");solution.print3(head1);System.out.println();
        System.out.println("测试用例2，递归法：");solution.print3(head2);System.out.println();
        System.out.println("测试用例3，递归法：");solution.print3(head3);System.out.println();
        System.out.println("测试用例1，翻转链表法：");solution.print(head1);
        System.out.println("测试用例2，翻转链表法：");solution.print(head2);
        System.out.println("测试用例3，翻转链表法：");solution.print(head3);
    }
}

class ListNode {
    public int value;
    public ListNode next;
}
