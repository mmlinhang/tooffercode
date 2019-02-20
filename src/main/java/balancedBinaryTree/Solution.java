package balancedBinaryTree;

/**
 * 面试题55变体 判断一棵二叉树是否为平衡二叉树
 */
public class Solution {

    public boolean isBalanced(BinaryTreeNode treeNode) {
        if(treeNode == null)
            return false;

        if(isBalancedCore(treeNode) != -1)
            return true;
        else
            return false;
    }

    private int isBalancedCore(BinaryTreeNode treeNode) {
        if(treeNode == null)
            return 0;

        int dLeft = isBalancedCore(treeNode.getLeft());
        int dRight = isBalancedCore(treeNode.getRight());
        if(dLeft==-1 || dRight==-1)
            return -1;
        if(Math.abs(dLeft-dRight) > 1)
            return -1;
        else
            return Math.max(dLeft, dRight)+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        BinaryTreeNode node0 = null;
        System.out.println("测试用例1："+solution.isBalanced(node0));

        BinaryTreeNode node1 = new BinaryTreeNode(1);
        System.out.println("测试用例2："+solution.isBalanced(node1));

        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        node2.setLeft(node3);
        System.out.println("测试用例3："+solution.isBalanced(node2));

        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        node4.setRight(node5);
        node5.setRight(node6);
        System.out.println("测试用例4："+solution.isBalanced(node4));

        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        node7.setLeft(node8);
        node7.setRight(node9);
        node9.setRight(node10);
        System.out.println("测试用例5："+solution.isBalanced(node7));

        BinaryTreeNode node11 = new BinaryTreeNode(11);
        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node13 = new BinaryTreeNode(13);
        BinaryTreeNode node14 = new BinaryTreeNode(14);
        BinaryTreeNode node15 = new BinaryTreeNode(15);
        node11.setLeft(node12);
        node11.setRight(node13);
        node12.setLeft(node14);
        node14.setRight(node15);
        System.out.println("测试用例6："+solution.isBalanced(node11));
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