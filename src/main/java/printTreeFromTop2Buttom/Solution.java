package printTreeFromTop2Buttom;

import java.util.LinkedList;

/**
 * 面试题32 二叉树的层次遍历
 */
public class Solution {

    public void print(BinaryTreeNode tree) {
        if(tree == null)
            return;

        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(tree);
        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.getVal()+" ");
            if(node.getLeft() != null)
                queue.offer(node.getLeft());
            if(node.getRight() != null)
                queue.offer(node.getRight());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1：");
        solution.print(null);
        System.out.println("测试用例2：");
        solution.print(new BinaryTreeNode(0));
        System.out.println("测试用例3：");
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        solution.print(node1);
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
