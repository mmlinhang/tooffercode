package firstCommonNodeInTwoLists;

/**
 * 面试题52 两个链表中的第一个公共节点
 */
public class Solution {

    public ListNode getFirstCommonNode(ListNode head1, ListNode head2) {
        if(head1==null || head2==null)
            return null;

        ListNode p1=head1, p2=head2;
        int count1=getNodeNum(head1);
        int count2=getNodeNum(head2);
        if(count2 > count1) {
            for(int i=0; i<count2-count1; i++) {
                p2 = p2.getNext();
            }
        }
        else {
            for(int i=0; i<count1-count2; i++) {
                p1 = p1.getNext();
            }
        }
        while(p1!=null && p2!=null && p1!=p2) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return p1;
    }

    private int getNodeNum(ListNode head) {
        int count = 0;
        ListNode p = head;
        while(p != null) {
            count++;
            p = p.getNext();
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        ListNode t1 = solution.getFirstCommonNode(null, new ListNode(0));
        ListNode t2 = solution.getFirstCommonNode(new ListNode(1), new ListNode(1));
        ListNode node1 = new ListNode(2);
        ListNode t3 = solution.getFirstCommonNode(node1, node1);

        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(7);
        ListNode node9 = new ListNode(8);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node8);
        node8.setNext(node9);
        node6.setNext(node7);
        node7.setNext(node8);
        ListNode t4 = solution.getFirstCommonNode(node2, node6);
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