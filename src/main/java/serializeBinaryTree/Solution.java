package serializeBinaryTree;

/**
 * 面试题37 序列化二叉树
 */
public class Solution {
    private int index;

    public String serialize(BinaryTreeNode tree) {
        if(tree == null)
            return null;

        return serializeCore(tree).toString();
    }

    private StringBuilder serializeCore(BinaryTreeNode tree) {
        if(tree == null)
            return new StringBuilder("$");

        return new StringBuilder(tree.getVal()+"")
                .append(",").append(serializeCore(tree.getLeft()))
                .append(",").append(serializeCore(tree.getRight()));
    }

    public BinaryTreeNode deserialize(String s) {
        if(s==null || s.length()==0)
            return null;
        String[] nodeVals = s.split(",");
        if(nodeVals.length == 0)
            return null;

        index = 0;
        return deserializeCore(nodeVals);
    }

    private BinaryTreeNode deserializeCore(String[] nodeVals) {
        if(index>=nodeVals.length)
            return null;
        if(nodeVals[index].equals("$")) {
            index++;
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode(Integer.valueOf(nodeVals[index++]));
        root.setLeft(deserializeCore(nodeVals));
        root.setRight(deserializeCore(nodeVals));

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        BinaryTreeNode root1 = new BinaryTreeNode(10);
        String ser1 = solution.serialize(root1);
        BinaryTreeNode node1 = solution.deserialize(ser1);

        BinaryTreeNode root2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(-6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        root2.setLeft(node3);
        root2.setRight(node4);
        node3.setLeft(node5);
        node4.setRight(node6);
        node5.setLeft(node7);
        node5.setRight(node8);
        node8.setRight(node9);
        String ser2 = solution.serialize(root2);
        BinaryTreeNode deNode2 = solution.deserialize(ser2);

        BinaryTreeNode root3 = new BinaryTreeNode(3);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node11 = new BinaryTreeNode(11);
        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node13 = new BinaryTreeNode(13);
        root3.setRight(node10);
        node10.setRight(node11);
        node11.setRight(node12);
        node12.setRight(node13);
        String ser3 = solution.serialize(root3);
        BinaryTreeNode deNode3 = solution.deserialize(ser3);
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

