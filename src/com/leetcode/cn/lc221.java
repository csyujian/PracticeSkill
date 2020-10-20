package com.leetcode.cn;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/2 19:45
 */
public class lc221 {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][][] dp = new int[m+1][n+1][2];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1][0] = dp[i + 1][j][0] + 1;
                    dp[i+1][j+1][1] = dp[i][j + 1][1] + 1;
                }
            }
        }
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){

                    }else{
                        if(matrix[i - 1][j - 1] >= '1'){
                            matrix[i][j] = (char)(Math.min(Math.min(matrix[i - 1][j - 1] - '0',dp[i][j + 1][1]),dp[i + 1][j][0]) + '1');
                        }
                        res = Math.max(matrix[i][j] - '0',res);
                    }
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','1','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        lc221 s = new lc221();
        s.maximalSquare(matrix);
    }

}
