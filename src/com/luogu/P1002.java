package com.luogu;

import java.util.Scanner;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/8/23 10:30
 */
public class P1002 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int x1 = cin.nextInt(), y1 = cin.nextInt(), x2 = cin.nextInt(), y2 = cin.nextInt();
        int l = Math.max(x1,x2) , d = Math.max(y1,y2);
        int[][] dp = new int[x1 + 1][y1 + 1];
        dp[1][1] = 1;
        for(int i = 1 ;i <= x1;i++){
            for(int j = 1;j <= y1;j++){
                if(i == 1 && j == 1){
                    continue;
                }
                if( i == x2 - 2){
                    if( j == y2 - 1 || j == y2 + 1){
                        continue;
                    }
                }
                if( i == x2 - 1){
                    if( j == y2 - 2 || j == y2 + 2){
                        continue;
                    }
                }
                if( i == x2 + 1){
                    if( j == y2 - 2 || j == y2 + 2){
                        continue;
                    }
                }
                if( i == x2 + 2){
                    if( j == y2 + 1 || j == y2 - 1){
                        continue;
                    }
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println(dp[x1][y1]);
    }
}

