package subStructureInTree;

/**
 * 面试题26 树的子结构
 */
public class Solution {

    public boolean isSubStructrue(BinaryTreeNode parentTree, BinaryTreeNode subTree) {
        if(parentTree==null || subTree==null)
            return false;

        return isSubStructureCore(parentTree, subTree);
    }

    private boolean isSubStructureCore(BinaryTreeNode parentTree, BinaryTreeNode subTree) {
        if(subTree == null)
            return true;
        if(parentTree == null)
            return false;

        return isSubStructureByRoot(parentTree, subTree)
                || isSubStructureCore(parentTree.getLeft(), subTree)
                || isSubStructureCore(parentTree.getRight(), subTree);
    }

    private boolean isSubStructureByRoot(BinaryTreeNode parentTree, BinaryTreeNode subTree) {
        if(subTree == null)
            return true;
        if(parentTree == null)
            return false;

        if(parentTree.getVal() == subTree.getVal())
            return isSubStructureByRoot(parentTree.getLeft(), subTree.getLeft())
                    && isSubStructureByRoot(parentTree.getRight(), subTree.getRight());
        else
            return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        node1.setLeft(node2);
        node1.setLeft(node3);
        node2.setLeft(node4);
        node2.setLeft(node5);
        node3.setLeft(node6);
        System.out.println("测试用例1："+solution.isSubStructrue(node1, node3));
        System.out.println("测试用例2："+solution.isSubStructrue(node1, null));
        System.out.println("测试用例2："+solution.isSubStructrue(null, null));
        BinaryTreeNode node7 = new BinaryTreeNode(3);
        BinaryTreeNode node8 = new BinaryTreeNode(6);
        BinaryTreeNode node9 = new BinaryTreeNode(7);
        node7.setLeft(node8);
        node7.setRight(node9);
        System.out.println("测试用例3："+solution.isSubStructrue(node1, node7));
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
