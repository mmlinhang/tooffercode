package entryNodeInListLoop;

/**
 * 面试题23 链表中环的入口
 */
public class Solution {

    public ListNode getEntryNode(ListNode head) {
        if(head == null)
            return null;

        ListNode quick=head, slow=head;
        boolean hasLoop = false;
        int loopLen = 0;
        while(true) {
            if(quick.getNext()==null || quick.getNext().getNext()==null)
                break;
            quick = quick.getNext().getNext();
            slow = slow.getNext();
            if(quick == slow) {
                hasLoop = true;
                do {
                    slow = slow.getNext();
                    loopLen++;
                } while(slow != quick);

                break;
            }
        }

        if(!hasLoop)
            return null;

        slow = head; quick = head;
        for(int i=0; i<loopLen; i++)
            quick = quick.getNext();
        while(slow != quick) {
            slow = slow.getNext();
            quick = quick.getNext();
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);
        System.out.println("测试用例1："+solution.getEntryNode(head).getVal());
        node4.setNext(head);
        System.out.println("测试用例2："+solution.getEntryNode(head).getVal());
        node4.setNext(null);
        System.out.println("测试用例3："+solution.getEntryNode(head));
        node4.setNext(node4);
        System.out.println("测试用例4："+solution.getEntryNode(head).getVal());
        head.setNext(head);
        System.out.println("测试用例5："+solution.getEntryNode(head).getVal());
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
