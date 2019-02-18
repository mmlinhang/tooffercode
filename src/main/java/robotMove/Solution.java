package robotMove;

/**
 * 面试题13 机器人的运动范围
 */
public class Solution {

    /**
     * 回溯法
     */
    public int moveCount(int threshold, int lineNum, int columnNum) {
        if(threshold<0 || lineNum<0 || columnNum<0)
            return 0;

        boolean[][] visited = new boolean[lineNum][columnNum];
        for(int i=0; i<lineNum; i++) {
            for(int j=0; j<columnNum; j++) {
                visited[i][j] = false;
            }
        }

        return moveCount(threshold, lineNum, columnNum, 0, 0, visited);
    }

    private int moveCount(int threshold, int lineNum, int columnNum, int line, int column, boolean[][] visited) {
        int count = 0;
        if(check(threshold, lineNum, columnNum, line, column, visited)) {
            visited[line][column] = true;
            count = 1 + moveCount(threshold, lineNum, columnNum, line+1, column, visited)
                    + moveCount(threshold, lineNum, columnNum, line-1, column, visited)
                    + moveCount(threshold, lineNum, columnNum, line, column+1, visited)
                    + moveCount(threshold, lineNum, columnNum, line, column-1, visited);
        }

        return count;
    }

    private boolean check(int threshold, int lineNum, int columnNum, int line, int column, boolean[][] visited) {
        if(line>=0 && line<lineNum
                && column>=0 && column<columnNum
                && !visited[line][column]
                && digitNum(line)+digitNum(column)<=threshold)
            return true;

        return false;
    }

    private int digitNum(int num) {
        int res = 0;
        while(num != 0) {
            res += num%10;
            num /= 10;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
