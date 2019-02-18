package printTreeInLines;

import java.util.LinkedList;

/**
 * 面试题32变体 从上到下分行打印二叉树
 */
public class Solution {

    public void printInLines(BinaryTreeNode tree) {
        if(tree == null)
            return;

        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(tree);
        int curLineLeft = 1;
        int nextLineNum = 0;
        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if(node.getLeft() != null) {
                queue.offer(node.getLeft());
                nextLineNum++;
            }
            if(node.getRight() != null) {
                queue.offer(node.getRight());
                nextLineNum++;
            }
            curLineLeft--;
            System.out.print(node.getVal()+" ");
            if(curLineLeft == 0) {
                System.out.println();
                curLineLeft = nextLineNum;
                nextLineNum = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        System.out.println("测试用例1：");
        solution.printInLines(null);
        System.out.println("测试用例2：");
        solution.printInLines(new BinaryTreeNode(0));
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
        solution.printInLines(node1);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node11 = new BinaryTreeNode(11);
        BinaryTreeNode node12 = new BinaryTreeNode(12);
        node7.setLeft(node8);
        node8.setLeft(node9);
        node9.setLeft(node10);
        node10.setLeft(node11);
        node11.setLeft(node12);
        solution.printInLines(node7);
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