package twoMatrixFind;

/**
 * 面试题四 二维数组中的查找
 */
public class Solution {

    public boolean find(int[][] matrix, int num) {
        if(matrix == null)
            return false;
        int rowNum = matrix.length;
        if(rowNum < 1)
            return false;
        int colNum = matrix[0].length;
        if(colNum < 1)
            return false;

        int row = rowNum-1;
        int col = 0;
        while(row > -1 && col < colNum) {
            if(num == matrix[row][col])
                return true;
            else if(matrix[row][col] > num)
                row--;
            else
                col++;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        //测试用例
        int[][] matrix1 = {{1, 4, 7, 8}, {3, 4, 8, 9}, {5, 6, 10, 11}};
        int num1 = 6;
        int[][] matrix2 = {{}, {}, {}, {}};
        int num2 = 5;
        int[][] matrix3 = {};
        int num3 = 7;
        int[][] matrix4 = {{5, 6, 7, 8}, {8, 9, 10, 11}, {10, 13, 15, 17}, {14, 15, 17, 19}};
        int num4 = 16;

        System.out.println("测试用例1:"+solution.find(matrix1, num1));
        System.out.println("测试用例2:"+solution.find(matrix2, num2));
        System.out.println("测试用例3:"+solution.find(matrix3, num3));
        System.out.println("测试用例4:"+solution.find(matrix4, num4));
    }
}
