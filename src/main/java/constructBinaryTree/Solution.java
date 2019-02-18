package constructBinaryTree;

import java.util.Arrays;

/**
 * 面试题7 重建二叉树
 */
public class Solution {

    /**
     * 递归法
     */
    public BinaryTreeNode construct(int[] preOrder, int[] midOrder) {
        if(preOrder == null || preOrder.length == 0 || midOrder == null || midOrder.length == 0)
            return null;

        int rootVal = preOrder[0];
        BinaryTreeNode root = new BinaryTreeNode();
        root.value = rootVal;

        int rootInMid = findIndex(midOrder, rootVal);
        // 得到左子树
        int[] leftPreOrder = Arrays.copyOfRange(preOrder, 1, 1+rootInMid);
        int[] rightPreOrder = Arrays.copyOfRange(preOrder, 1+rootInMid, preOrder.length);
        int[] leftMidOrder = Arrays.copyOfRange(midOrder, 0, rootInMid);
        int[] rightMidOrder = Arrays.copyOfRange(midOrder, rootInMid+1, midOrder.length);
        BinaryTreeNode left = construct(leftPreOrder, leftMidOrder);
        BinaryTreeNode right = construct(rightPreOrder, rightMidOrder);
        root.left = left;
        root.right = right;

        return root;
    }

    private int findIndex(int[] matrix, int val) {
        if(matrix == null)
            return -1;
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i] == val)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] midOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode tree = solution.construct(preOrder, midOrder);
    }
}

class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
}
