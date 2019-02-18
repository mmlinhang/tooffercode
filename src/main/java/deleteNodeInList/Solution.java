package deleteNodeInList;

/**
 * 面试题18 删除链表中的节点，限制时间复杂度为 O(1)
 */
public class Solution {

    public ListNode deleteNodeInList(ListNode head, ListNode deleteNode) {
        if(head==null || deleteNode==null)
            return null;

        ListNode next = deleteNode.getNext();
        if(next != null) {
            deleteNode.setVal(next.getVal());
            deleteNode.setNext(next.getNext());
        }
        else {
            if(deleteNode == head)
                return null;
            else {
                ListNode pre = head;
                while(pre.getNext() != deleteNode)
                    pre = pre.getNext();
                pre.setNext(null);
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        ListNode head1 = new ListNode(0);
        System.out.println("测试用例1："+solution.deleteNodeInList(head1, head1));
        ListNode node1 = new ListNode(1);
        head1.setNext(node1);
        ListNode node2 = new ListNode(2);
        node1.setNext(node2);
        ListNode node3 = new ListNode(3);
        node2.setNext(node3);
        System.out.println("测试用例2："+solution.deleteNodeInList(head1, node1).getNext().getVal());
        System.out.println("测试用例3："+solution.deleteNodeInList(head1, node3).getNext().getNext());
        System.out.println("测试用例4："+solution.deleteNodeInList(head1, head1).getVal());
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
