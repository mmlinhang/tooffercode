package printTreeInZigZag;

import java.util.Stack;

/**
 * 面试题32变体2 之字形打印二叉树
 */
public class Solution {

    public void print(BinaryTreeNode tree) {
        if(tree == null)
            return;

        Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();
        stack1.push(tree);
        while(true) {
            if(stack1.isEmpty())
                break;
            else {
                while(!stack1.isEmpty()) {
                    BinaryTreeNode node = stack1.pop();
                    System.out.print(node.getVal()+" ");
                    if(node.getLeft() != null)
                        stack2.push(node.getLeft());
                    if(node.getRight() != null)
                        stack2.push(node.getRight());
                }
            }
            System.out.println();

            if(stack2.isEmpty())
                break;
            else {
                while(!stack2.isEmpty()) {
                    BinaryTreeNode node = stack2.pop();
                    System.out.print(node.getVal()+" ");
                    if(node.getRight() != null)
                        stack1.push(node.getRight());
                    if(node.getLeft() != null)
                        stack1.push(node.getLeft());
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
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
        solution.print(node7);
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