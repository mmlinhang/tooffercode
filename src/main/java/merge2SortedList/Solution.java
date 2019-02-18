package merge2SortedList;

/**
 * 面试题25 合并两个有序链表
 */
public class Solution {

    public ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;

        if(head1.getVal() < head2.getVal()) {
            head1.setNext(merge(head1.getNext(), head2));
            return head1;
        }
        else {
            head2.setNext(merge(head1, head2.getNext()));
            return head2;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        ListNode merHead1 = solution.merge(null, new ListNode(0));
        ListNode merHead2 = solution.merge(null, null);
        ListNode head1 = new ListNode(0);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(8);
        head1.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        ListNode head2 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(9);
        head2.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        ListNode merHead3 = solution.merge(head1, head2);
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