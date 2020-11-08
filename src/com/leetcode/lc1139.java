package com.leetcode;

public class lc1139 {
    int largest1BorderedSquare(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int temp,res = 0;
        for(int i=0;i<row;i++){
            for(int j =0;j<col;j++){
                if(matrix[i][j]!=0) {
                    temp = (dp[i][j + 1] > dp[i + 1][j]) ? (Math.min(dp[i + 1][j], dp[i][j])) : (Math.min(dp[i][j + 1], dp[i][j]));
                    //dp[i + 1][j + 1] = temp + 1;
                    res += dp[i+1][j+1]=temp+1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        lc1139 s = new lc1139();
        int res = s.largest1BorderedSquare(matrix);
        System.out.println(res);
    }
}
