package com.leetcode;

import java.util.Arrays;

public class lc923 {


    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        int[][] dp = new int[target + 1][3];
        for(int a : A){

            for(int i = target - a; i >= 0 ;i--){
                for(int j = 1;j >= 0 ;j--){
                    dp[i + a][j + 1] += dp[i][j];
                }
            }
            dp[a][0]++;
        }
        return dp[target][2];
    }

    public static void main(String[] args) {
        int[][] A = {{0,0,0},{1,1,2,2,3,3,4,4,5,5},{1,1,2,2,2,2}};
        int[] target = {0,8,5};
        lc923 s = new lc923();
        for(int i = 0;i < A.length;i++){
            int res = s.threeSumMulti(A[i],target[i]);
            System.out.println(res);
        }
    }
}