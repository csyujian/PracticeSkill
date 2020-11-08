package com.leetcode;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/8/15 14:58
 */
public class Lc1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(),n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int j = 0;j < n;j++){
            for(int i = 0;i < m;i++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i + 1][j + 1] = Math.max(dp[i][j] + 1,dp[i + 1][j + 1]);
                }else{
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1],dp[i + 1][j + 1]);
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j],dp[i + 1][j + 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Lc1143 s = new Lc1143();
        int res = s.longestCommonSubsequence("bl","yby");
        System.out.println(res);
    }
}
