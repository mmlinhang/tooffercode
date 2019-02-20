package treeDepth;

/**
 * 面试题55 二叉树的深度
 */
public class Solution {

    public int depth(BinaryTreeNode treeNode) {
        if(treeNode == null)
            return 0;

        return Math.max(depth(treeNode.getLeft()), depth(treeNode.getRight())) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        BinaryTreeNode treeNode0 = null;
        System.out.println("测试用例1："+solution.depth(treeNode0));

        BinaryTreeNode treeNode1 = new BinaryTreeNode(1);
        System.out.println("测试用例2："+solution.depth(treeNode1));

        BinaryTreeNode treeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode treeNode3 = new BinaryTreeNode(3);
        treeNode2.setLeft(treeNode3);
        System.out.println("测试用例3："+solution.depth(treeNode2));

        BinaryTreeNode treeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode treeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode treeNode6 = new BinaryTreeNode(6);
        BinaryTreeNode treeNode7 = new BinaryTreeNode(7);
        BinaryTreeNode treeNode8 = new BinaryTreeNode(8);
        treeNode4.setLeft(treeNode5);
        treeNode4.setRight(treeNode6);
        treeNode6.setRight(treeNode7);
        treeNode7.setRight(treeNode8);
        System.out.println("测试用例4："+solution.depth(treeNode4));
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