package mirrorOfBinaryTree;

/**
 * 面试题27 二叉树的镜像
 */
public class Solution {

    public void mirror(BinaryTreeNode treeNode) {
        if(treeNode==null)
            return;

        BinaryTreeNode temp = treeNode.getLeft();
        treeNode.setLeft(treeNode.getRight());
        treeNode.setRight(temp);
        mirror(treeNode.getLeft());
        mirror(treeNode.getRight());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.mirror(null);
        BinaryTreeNode treeNode1 = new BinaryTreeNode(1);
        solution.mirror(treeNode1);
        BinaryTreeNode treeNode2 = new BinaryTreeNode(2);
        treeNode1.setLeft(treeNode2);
        BinaryTreeNode treeNode7 = new BinaryTreeNode(7);
        treeNode2.setLeft(treeNode7);
        solution.mirror(treeNode1);
        BinaryTreeNode treeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode treeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode treeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode treeNode6 = new BinaryTreeNode(6);
        treeNode3.setLeft(treeNode4);
        treeNode3.setRight(treeNode5);
        treeNode4.setLeft(treeNode6);
        solution.mirror(treeNode3);
    }
}

class BinaryTreeNode {
    private int val;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
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