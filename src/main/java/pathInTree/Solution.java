package pathInTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题34 二叉树中和为某一值的路径
 */
public class Solution {

    public void printPath(BinaryTreeNode tree, int k) {
        if(tree==null)
            return;

        List<Integer> paths = new ArrayList<Integer>();
        printPathCore(tree, k, paths);
    }

    private void printPathCore(BinaryTreeNode tree, int k, List<Integer> paths) {
        if(tree.getLeft()==null && tree.getRight()==null) {
            if(tree.getVal() == k) {
                for(int path:paths)
                    System.out.print(path+" ");
                System.out.print(tree.getVal());
                System.out.println();
            }
            return;
        }

        paths.add(tree.getVal());
        if(tree.getLeft() != null) {
            printPathCore(tree.getLeft(), k-tree.getVal(), paths);
        }
        if(tree.getRight() != null) {
            printPathCore(tree.getRight(), k-tree.getVal(), paths);
        }
        paths.remove(paths.size()-1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        BinaryTreeNode node1 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(7);
        BinaryTreeNode node3 = new BinaryTreeNode(-4);
        BinaryTreeNode node4 = new BinaryTreeNode(8);
        BinaryTreeNode node5 = new BinaryTreeNode(3);
        BinaryTreeNode node6 = new BinaryTreeNode(2);
        BinaryTreeNode node7 = new BinaryTreeNode(-1);
        BinaryTreeNode node8 = new BinaryTreeNode(6);
        BinaryTreeNode node9 = new BinaryTreeNode(12);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);
        node4.setLeft(node8);
        node6.setRight(node9);
        System.out.println("测试用例1：");
        solution.printPath(node1, 26);
        System.out.println("测试用例2：");
        solution.printPath(node1, 15);
        System.out.println("测试用例3：");
        solution.printPath(node1, 3);
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