package pathInMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题12 矩阵中的路径
 */
public class Solution {

    private Coordinate[] path;
    private boolean found;
    private boolean[][] hasVisited;

    public void getPath(char[][] matrix, String s) {
        if(matrix == null || matrix[0].length == 0 || s == null || s.isEmpty())
            return;

        path = new Coordinate[s.length()];
        found = false;
        hasVisited = new boolean[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++)
                hasVisited[i][j] = false;
        }

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(!found && matrix[i][j] == s.charAt(0)) {
                    path[0] = new Coordinate(i, j);
                    hasVisited[i][j] = true;
                    getPath(matrix, s, 1);
                    hasVisited[i][j] = false;
                }
            }
        }
    }

    private void getPath(char[][] matrix, String s, int start) {
        if(start == s.length()) {
            found = true;
            return;
        }

        Coordinate cur = path[start-1];
        int line = cur.getLine();
        int column = cur.getColumn();
        List<Coordinate> cors = new ArrayList<Coordinate>();
        if(line>0 && line<matrix.length-1) {
            cors.add(new Coordinate(line+1, column));
            cors.add(new Coordinate(line-1, column));
        }
        else if(line==0 && line<matrix.length-1)
            cors.add(new Coordinate(line+1, column));
        else if(line==matrix.length-1 && line>0)
            cors.add(new Coordinate(line-1, column));
        if(column>0 && column<matrix[0].length-1) {
            cors.add(new Coordinate(line, column+1));
            cors.add(new Coordinate(line, column-1));
        }
        else if(column==0 && column<matrix[0].length-1)
            cors.add(new Coordinate(line, column+1));
        else if(column==matrix[0].length-1 && column>0)
            cors.add(new Coordinate(line, column-1));

        for(Coordinate coordinate:cors) {
            int i = coordinate.getLine();
            int j = coordinate.getColumn();
            if(!found && !hasVisited[i][j] && matrix[i][j] == s.charAt(start)) {
                path[start] = new Coordinate(i, j);
                hasVisited[i][j] = true;
                getPath(matrix, s, start+1);
                hasVisited[i][j] = false;
            }
        }
    }

    public Coordinate[] getPath() {
        return path;
    }

    public void setPath(Coordinate[] path) {
        this.path = path;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例1
        char[][] matrix =
                {
                        {'a', 'b', 't', 'g'},
                        {'c', 'f', 'c', 's'},
                        {'j', 'd', 'e', 'h'}
                };

        solution.getPath(matrix, "bfce");

        System.out.println("测试用例1：");
        Coordinate[] path1 = solution.getPath();
        for(int i=0; i<path1.length; i++) {
            System.out.print("["+path1[i].getLine()+", "+path1[i].getColumn()+"]"+"  ");
        }
    }
}

class Coordinate {

    private int line;
    private int column;

    public Coordinate(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
