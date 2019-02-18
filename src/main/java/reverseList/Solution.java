package reverseList;

/**
 * 面试题24 反转链表
 */
public class Solution {

    public ListNode reverse(ListNode head) {
        if(head == null)
            return null;
        ListNode pre=null, cur=head, next=head.getNext();
        cur.setNext(pre);
        while(next != null) {
            pre = cur;
            cur = next;
            next = cur.getNext();
            cur.setNext(pre);
        }

        return cur;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        ListNode reHead = solution.reverse(head);
        ListNode head2 = new ListNode(0);
        ListNode reHead2 = solution.reverse(head2);
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
