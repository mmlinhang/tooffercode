package lastNumberInCircle;

/**
 * 面试题62 圆圈中最后剩下的数字
 */
public class Solution {

    public int lastNumber(int n, int m) {
        if(n<1 || m<1)
            return -1;


        ListNode nail = makeCircle(n);
        ListNode pre = nail;
        for(int i=0; i<n-1; i++) {
            for(int j=1; j<m; j++)
                pre = pre.next;
            pre.next = pre.next.next;
        }

        return pre.val;
    }

    private ListNode makeCircle(int n) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for(int i=1; i<n; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        p.next = head;

        return p;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1："+solution.lastNumber(0, 1));
        System.out.println("测试用例2："+solution.lastNumber(1, 0));
        System.out.println("测试用例3："+solution.lastNumber(5, 3));
        System.out.println("测试用例4："+solution.lastNumber(8, 4));
        System.out.println("测试用例4："+solution.lastNumber(5, 6));
    }
}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}