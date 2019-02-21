package dicesProbabity;

/**
 * 面试题60 n个骰子可能的点数的概率
 */
public class Solution {

    public void print(int n) {
        if(n < 1)
            return;

        int[][] probabilities = new int[2][n*6+1];
        for(int i=0; i<2; i++) {
            for(int j=0; j<n*6+1; j++)
                probabilities[i][j] = 0;
        }
        int flag = 0;
        for(int i=1; i<=6; i++)
            probabilities[flag][i] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<=6*i; j++)
                probabilities[1-flag][i] = 0;

            for(int j=i; j<=6*i; j++) {
                for(int k=1; k<=6 && k<=j; k++)
                    probabilities[1-flag][j] += probabilities[flag][j-k];
            }
            flag = 1-flag;
        }

        double total = Math.pow(6, n);
        for(int i=n; i<6*n; i++) {
            System.out.println("和为"+i+"的概率为："+probabilities[flag][i]/total);
        }
    }
}
