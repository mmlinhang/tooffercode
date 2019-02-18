package copyComplexList;

/**
 * 面试题35 复制复杂链表
 */
public class Solution {

    /**
     * 法一：哈希表保存原链表节点和复制链表节点的映射
     */

    /**
     * 法二：
     *  1. 先将原链表每个节点复制一个并接在原节点后
     *  2. 复制节点的sibling指针即指向原节点sibling指针指向的节点的next节点
     *  3. 拆分成两个链表
     */
    public ComplexListNode copy(ComplexListNode list) {
        if(list == null)
            return null;

        // 第一步,复制链表
        ComplexListNode copyNode = list;
        while(copyNode != null) {
            ComplexListNode newNode = new ComplexListNode(copyNode.getVal());
            newNode.setNext(copyNode.getNext());
            copyNode.setNext(newNode);
            copyNode = copyNode.getNext().getNext();
        }

        // 第二步，设置sibling指针
        ComplexListNode siblingNode = list;
        while(siblingNode != null) {
            if(siblingNode.getSibling() == null)
                siblingNode.getNext().setSibling(null);
            else
                siblingNode.getNext().setSibling(siblingNode.getSibling().getNext());
            siblingNode = siblingNode.getNext().getNext();
        }

        // 第三步，拆分成两个链表
        ComplexListNode copyHead = list.getNext();
        ComplexListNode partNode1 = list;
        ComplexListNode partNode2 = copyHead;
        while(partNode1 != null) {
            partNode1.setNext(partNode1.getNext().getNext());
            partNode1 = partNode1.getNext();
            if(partNode2.getNext() != null) {
                partNode2.setNext(partNode2.getNext().getNext());
                partNode2 = partNode2.getNext();
            }
        }

        return copyHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        ComplexListNode copyHead1 = solution.copy(null);

        ComplexListNode complexListNode1 = new ComplexListNode(1);
        complexListNode1.setSibling(complexListNode1);
        ComplexListNode copyHead2 = solution.copy(complexListNode1);

        ComplexListNode complexListNode2 = new ComplexListNode(2);
        ComplexListNode complexListNode3 = new ComplexListNode(3);
        ComplexListNode complexListNode4 = new ComplexListNode(4);
        ComplexListNode complexListNode5 = new ComplexListNode(5);
        complexListNode2.setNext(complexListNode3);
        complexListNode2.setSibling(complexListNode4);
        complexListNode3.setNext(complexListNode4);
        complexListNode4.setNext(complexListNode5);
        complexListNode4.setSibling(complexListNode3);
        ComplexListNode copyHead3 = solution.copy(complexListNode2);
    }
}

class ComplexListNode {
    private int val;
    private ComplexListNode next;
    private ComplexListNode sibling;

    public ComplexListNode(int val) {
        this.val = val;
    }

    public ComplexListNode getNext() {
        return next;
    }

    public void setNext(ComplexListNode next) {
        this.next = next;
    }

    public ComplexListNode getSibling() {
        return sibling;
    }

    public void setSibling(ComplexListNode sibling) {
        this.sibling = sibling;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
