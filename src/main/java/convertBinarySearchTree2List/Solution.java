package convertBinarySearchTree2List;

/**
 * 面试题36 二叉搜索树与双向链表
 */
public class Solution {

    public BinaryTreeNode convert(BinaryTreeNode tree) {
        if(tree == null)
            return null;

        convert(tree.getLeft());
        if(tree.getLeft() != null) {
            BinaryTreeNode lastNode = getLastInList(tree.getLeft());
            tree.setLeft(lastNode);
            lastNode.setRight(tree);
        }

        convert(tree.getRight());
        if(tree.getRight() != null) {
            BinaryTreeNode nextNode = getFirstInList(tree.getRight());
            tree.setRight(nextNode);
            nextNode.setLeft(tree);
        }

        return getFirstInList(tree);
    }

    private BinaryTreeNode getFirstInList(BinaryTreeNode tree) {
        while(tree.getLeft()!=null)
            tree = tree.getLeft();
        return tree;
    }

    private BinaryTreeNode getLastInList(BinaryTreeNode tree) {
        while(tree.getRight()!=null)
            tree = tree.getRight();
        return tree;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        BinaryTreeNode doubleList1 = solution.convert(null);
        BinaryTreeNode doubleList2 = solution.convert(new BinaryTreeNode(1));

        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(10);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(14);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(13);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(15);
        binaryTreeNode1.setLeft(binaryTreeNode2);
        binaryTreeNode1.setRight(binaryTreeNode3);
        binaryTreeNode2.setLeft(binaryTreeNode4);
        binaryTreeNode2.setRight(binaryTreeNode5);
        binaryTreeNode3.setLeft(binaryTreeNode6);
        binaryTreeNode3.setRight(binaryTreeNode7);
        BinaryTreeNode doubleList3 = solution.convert(binaryTreeNode1);

        BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode10 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode11 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode12 = new BinaryTreeNode(1);
        binaryTreeNode8.setLeft(binaryTreeNode9);
        binaryTreeNode9.setLeft(binaryTreeNode10);
        binaryTreeNode10.setLeft(binaryTreeNode11);
        binaryTreeNode11.setLeft(binaryTreeNode12);
        BinaryTreeNode doubleList4 = solution.convert(binaryTreeNode8);

        BinaryTreeNode binaryTreeNode13 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode14 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode15 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode16 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode17 = new BinaryTreeNode(5);
        binaryTreeNode13.setRight(binaryTreeNode14);
        binaryTreeNode14.setRight(binaryTreeNode15);
        binaryTreeNode15.setRight(binaryTreeNode16);
        binaryTreeNode16.setRight(binaryTreeNode17);
        BinaryTreeNode doubleList5 = solution.convert(binaryTreeNode13);
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