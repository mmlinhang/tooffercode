package maxValueOfGifts;

/**
 * 面试题47 礼物的最大价值
 */
public class Solution {

    public int maxValue(int[][] gifts) {
        if(gifts==null || gifts.length==0 || gifts[0].length==0)
            return 0;

        int rows=gifts.length, columns=gifts[0].length;
        int[][] maxValue = new int[rows][columns];
        maxValue[0][0] = gifts[0][0];
        for(int i=0; i<Math.min(rows, columns); i++) {
            if(i == 0) {
                for(int j=i+1; j<rows; j++)
                    maxValue[j][i] = maxValue[j-1][i]+gifts[j][i];
                for(int j=i+1; j<columns; j++)
                    maxValue[i][j] = maxValue[i][j-1]+gifts[i][j];
            }
            else {
                maxValue[i][i] = Math.max(maxValue[i][i-1], maxValue[i-1][i])+gifts[i][i];
                for(int j=i+1; j<rows; j++)
                    maxValue[j][i] = Math.max(maxValue[j-1][i], maxValue[j][i-1])+gifts[j][i];
                for(int j=i+1; j<columns; j++)
                    maxValue[i][j] = Math.max(maxValue[i][j-1], maxValue[i-1][j])+gifts[i][j];
            }
        }

        return maxValue[rows-1][columns-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[][] gifts1 = null;
        int[][] gifts2 = {};
        int[][] gifts3 = {{}, {}};
        int[][] gifts4 = {{1}, {2}, {3}};
        int[][] gifts5 = {{1, 2, 3}};
        int[][] gifts6 = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        System.out.println("测试用例1："+solution.maxValue(gifts1));
        System.out.println("测试用例2："+solution.maxValue(gifts2));
        System.out.println("测试用例3："+solution.maxValue(gifts3));
        System.out.println("测试用例4："+solution.maxValue(gifts4));
        System.out.println("测试用例5："+solution.maxValue(gifts5));
        System.out.println("测试用例6："+solution.maxValue(gifts6));
    }
}
