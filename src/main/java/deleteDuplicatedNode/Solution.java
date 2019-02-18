package deleteDuplicatedNode;

/**
 * 面试题18变体 删除链表中的重复节点
 */
public class Solution {

    public ListNode delete(ListNode head) {
        if(head==null || head.getNext()==null)
            return head;

        ListNode fakeHead = new ListNode(-1);
        fakeHead.setNext(head);
        ListNode pre=fakeHead, back=fakeHead.getNext();
        while(back != null && back.getNext() != null) {
            while(back.getNext()!=null && back.getVal()==back.getNext().getVal())
                back = back.getNext();
            if(pre.getNext() == back) {
                pre = pre.getNext();
                back = back.getNext();
            }
            else {
                pre.setNext(back.getNext());
                back = back.getNext();
            }
        }

        return fakeHead.getNext();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(0);
        ListNode node7 = new ListNode(0);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        head = solution.delete(head);
        ListNode p = head;
        System.out.println("测试用例1：");
        while(p != null) {
            System.out.print(p.getVal()+" ");
            p = p.getNext();
        }
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
