package printMatrix;

/**
 * 面试题29 顺时针打印矩阵
 */
public class Solution {

    public void printMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        int rows=matrix.length, columns=matrix[0].length;

        int start = 0;
        while(start*2<rows && start*2<columns) {
            printCircle(matrix, start);
            start++;
        }
    }

    private void printCircle(int[][] matrix, int start) {
        int endX = matrix.length-1-start;
        int endY = matrix[0].length-1-start;

        for(int i=start; i<=endY; i++) {
            System.out.print(matrix[start][i]+" ");
        }

        if(endX > start) {
            for(int i=start+1; i<=endX; i++) {
                System.out.print(matrix[i][endY]+" ");
            }
        }

        if(endX>start && endY>start) {
            for(int i=endY-1; i>=start; i--) {
                System.out.print(matrix[endX][i]+" ");
            }
        }

        if(endX-1>start && endY>start) {
            for(int i=endX-1; i>=start+1; i--) {
                System.out.print(matrix[i][start]+" ");
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[][] matrix1 = {};
        int[][] matrix2 = {{}, {}};
        int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix4 = {{1, 2, 3, 4}, {4, 5, 6, 8}, {7, 8, 9, 10}};
        int[][] matrix5 = {{1, 2}, {4, 5}, {7, 8}, {3, 10}, {7, 8}};

        System.out.println("测试用例1：");
        solution.printMatrix(matrix1);
        System.out.println("测试用例2：");
        solution.printMatrix(matrix2);
        System.out.println("测试用例3：");
        solution.printMatrix(matrix3);
        System.out.println("测试用例4：");
        solution.printMatrix(matrix4);
        System.out.println("测试用例5：");
        solution.printMatrix(matrix5);
    }
}
