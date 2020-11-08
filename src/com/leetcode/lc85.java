package com.leetcode;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/2 20:37
 */
public class lc85 {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][][] dp = new int[m+1][n+1][2];
        getLen(matrix,dp);
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == '1'){
                    int l = dp[i + 1][j + 1][0],r = dp[i + 1][j + 1][1];
                    int a = l,b = r;
                    for(int k = 1;k < l;k++){
                        b = Math.min(dp[i + 1][j + 1 - k][1],b);//求列数
                    }
                    for(int k = 1;k < r;k++){
                        a = Math.min(dp[i + 1 - k][j + 1][0],a);//求行数
                    }
                    matrix[i][j] = (char)(a*b + '0');
                    res = Math.max(b*a,res);

                }
            }
        }
        return res * res;
    }
    void getLen(char[][] matrix,int[][][] dp){
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1][0] = dp[i + 1][j][0] + 1;
                    dp[i+1][j+1][1] = dp[i][j + 1][1] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','1','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        lc85 s = new lc85();
        int res = s.maximalRectangle(matrix);
        System.out.println(res);
    }
}