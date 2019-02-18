package symmetricBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题28 对称的二叉树
 */
public class Solution {

    public boolean isSymmetric(BinaryTreeNode tree) {
        if(tree == null)
            return false;
        List<Integer> preOrder = new ArrayList<Integer>();
        List<Integer> symPreOrder = new ArrayList<Integer>();
        preOrder(tree, preOrder);
        symmetricPreOrder(tree, symPreOrder);

        if(preOrder.size() != symPreOrder.size())
            return false;
        for(int i=0; i<preOrder.size(); i++) {
            if(preOrder.get(i) != symPreOrder.get(i))
                return false;
        }

        return true;
    }

    private void preOrder(BinaryTreeNode tree, List<Integer> list) {
        if(tree == null)
            return;
        list.add(tree.getVal());
        if(tree.getLeft() == null)
            list.add(null);
        else
            preOrder(tree.getLeft(), list);
        if(tree.getRight() == null)
            list.add(null);
        else
            preOrder(tree.getRight(), list);
    }

    private void symmetricPreOrder(BinaryTreeNode tree, List<Integer> list) {
        if(tree == null)
            return;
        list.add(tree.getVal());
        if(tree.getRight() == null)
            list.add(null);
        else
            symmetricPreOrder(tree.getRight(), list);
        if(tree.getLeft() == null)
            list.add(null);
        else
            symmetricPreOrder(tree.getLeft(), list);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(7);
        BinaryTreeNode node7 = new BinaryTreeNode(5);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        System.out.println("测试用例1："+solution.isSymmetric(node1));

        BinaryTreeNode node1_2 = new BinaryTreeNode(8);
        BinaryTreeNode node2_2 = new BinaryTreeNode(6);
        BinaryTreeNode node3_2 = new BinaryTreeNode(9);
        BinaryTreeNode node4_2 = new BinaryTreeNode(5);
        BinaryTreeNode node5_2 = new BinaryTreeNode(7);
        BinaryTreeNode node6_2 = new BinaryTreeNode(7);
        BinaryTreeNode node7_2 = new BinaryTreeNode(5);
        node1_2.setLeft(node2_2);
        node1_2.setRight(node3_2);
        node2_2.setLeft(node4_2);
        node2_2.setRight(node5_2);
        node3_2.setLeft(node6_2);
        node3_2.setRight(node7_2);
        System.out.println("测试用例2："+solution.isSymmetric(node1_2));

        BinaryTreeNode node1_3 = new BinaryTreeNode(7);
        BinaryTreeNode node2_3 = new BinaryTreeNode(7);
        BinaryTreeNode node3_3 = new BinaryTreeNode(7);
        BinaryTreeNode node4_3 = new BinaryTreeNode(7);
        BinaryTreeNode node5_3 = new BinaryTreeNode(7);
        BinaryTreeNode node6_3 = new BinaryTreeNode(7);
        node1_3.setLeft(node2_3);
        node1_3.setRight(node3_3);
        node2_3.setLeft(node4_3);
        node2_3.setRight(node5_3);
        node3_3.setLeft(node6_3);
        System.out.println("测试用例3："+solution.isSymmetric(node1_3));
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