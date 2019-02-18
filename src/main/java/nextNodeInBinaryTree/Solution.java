package nextNodeInBinaryTree;

/**
 * 面试题8 二叉树某一节点在中序序列中的下一节点
 */
public class Solution {

    /**
     * 该题考察多种情况下能否做出准确的分析
     */
    public BinaryTreeNode nextNode(BinaryTreeNode node) {
        if(node == null)
            return null;

        if(node.right != null) {
            BinaryTreeNode p = node.right;
            while(p.left != null)
                p = p.left;
            return p;
        }
        else {
            BinaryTreeNode parent = node.parent;
            while(true) {
                if(parent == null)
                    return null;
                else if(parent.left == node)
                    return parent;
                else {
                    node = parent;
                    parent = parent.parent;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        node1.parent = null;
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;
        node2.left = node4;
        node2.right = node5;
        node4.parent = node2;
        node5.parent = node2;
        node3.left = node6;
        node3.right = node7;
        node6.parent = node3;
        node7.parent = node3;
        node5.left = node8;
        node5.right = node9;
        node8.parent = node5;
        node9.parent = node5;

        BinaryTreeNode next1 = solution.nextNode(node2);
        BinaryTreeNode next2 = solution.nextNode(node9);
        BinaryTreeNode next3 = solution.nextNode(node7);
        System.out.println("node2的下一个节点为："+next1.value);
        System.out.println("node9的下一个节点为："+next2.value);
        System.out.println("node7的下一个节点为："+next3);
    }
}

class BinaryTreeNode {
    public BinaryTreeNode() {

    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode parent;
}
