package kThNodeInBST;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题54 二叉搜索树的第 k 大节点
 */
public class Solution {

    public BinaryTreeNode getKthNode(BinaryTreeNode treeNode, int k) {
        if(treeNode==null || k<1)
            return null;

        List<BinaryTreeNode> midOrder = new ArrayList<BinaryTreeNode>();
        midOrder(treeNode, midOrder);

        if(k > midOrder.size())
            return null;

        return midOrder.get(k-1);
    }

    private void midOrder(BinaryTreeNode treeNode, List<BinaryTreeNode> midOrder) {
        if(treeNode == null)
            return;

        midOrder(treeNode.getLeft(), midOrder);
        midOrder.add(treeNode);
        midOrder(treeNode.getRight(), midOrder);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        BinaryTreeNode node1 = null;
        System.out.println("测试用例1："+solution.getKthNode(node1, 1));
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        System.out.println("测试用例2："+solution.getKthNode(node2, 1).getValue());

        BinaryTreeNode node6 = new BinaryTreeNode(2);
        BinaryTreeNode node7 = new BinaryTreeNode(1);
        BinaryTreeNode node9 = new BinaryTreeNode(-1);
        BinaryTreeNode node3 = new BinaryTreeNode(2);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        node3.setLeft(node7);
        node3.setRight(node5);
        node7.setLeft(node9);
        node7.setRight(node6);
        node5.setLeft(node4);
        System.out.println("测试用例3："+solution.getKthNode(node3, 4).getValue());
        System.out.println("测试用例4："+solution.getKthNode(node3, 1).getValue());
        System.out.println("测试用例5："+solution.getKthNode(node3, 6).getValue());
    }
}

class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}