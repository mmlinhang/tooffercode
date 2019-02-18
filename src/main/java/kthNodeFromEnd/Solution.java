package kthNodeFromEnd;

/**
 * 面试题22 链表中倒数第k个节点
 */
public class Solution {

    public ListNode getkthNodeFromEnd(ListNode head, int k) {
        if(head==null || k<1)
            return null;

        ListNode pSecond=head, pFirst=head;
        for(int i=0; i<k; i++) {
            if(pSecond == null)
                return null;
            pSecond = pSecond.getNext();
        }
        while(pSecond != null) {
            pSecond = pSecond.getNext();
            pFirst = pFirst.getNext();
        }

        return pFirst;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        ListNode head = new ListNode(0);
        System.out.println("测试用例1："+solution.getkthNodeFromEnd(head, 1).getVal());
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        System.out.println("测试用例2："+solution.getkthNodeFromEnd(head, 2).getVal());
        System.out.println("测试用例2："+solution.getkthNodeFromEnd(head, 4).getVal());
        System.out.println("测试用例2："+solution.getkthNodeFromEnd(head, 5));
    }
}

class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
