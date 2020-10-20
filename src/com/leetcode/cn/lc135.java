package com.leetcode.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/26 9:52
 */
public class lc135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] dp = new int[len];
        List<Integer> mins = new ArrayList<>();
        for(int i = 1;i < len - 1;i++){
            if(ratings[i] <= ratings[i-1] && ratings[i] <= ratings[i + 1]){
                if(ratings[i] + ratings[i] - ratings[i - 1] - ratings[i + 1] > 0){
                    dp[i] = 1;
                    mins.add(i);
                }
            }
        }
        if(ratings[0] < ratings[1]){
            mins.add(0);
            dp[0] = 1;
        }
        if(ratings[len - 1] < ratings[len - 2]){
            dp[len - 1] = 1;
            mins.add(len - 1);
        }
        //1.从1开始进行分割。
        //2.从头开始分割。
        if(mins.size() == 0){
            return len;
        }
        for (int k : mins) {
            for (int j = k + 1; j < len; j++) {
                if (ratings[j] > ratings[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else if (ratings[j] == ratings[j - 1]) {
                    dp[j] = dp[j - 1];
                } else {
                    break;
                }
            }
            for (int j = k - 1; j >= 0; j--) {
                if (ratings[j] > ratings[j + 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else if (ratings[j] == ratings[j + 1]) {
                    dp[j] = dp[j - 1];
                } else {
                    break;
                }
            }

        }




        int sum = 0;
        for(int d : dp){
            sum += d;
        }
        return sum;
    }
    public static void main(String[] args){
        lc135 s = new lc135();
        int[][] nums = {
                {1,2,3},
                {1,0,2},
                {1,2,2},
                {1,3,4,1,3,4}
        };
        for(int[] n : nums){
            System.out.println(s.candy(n));
        }
        
    }

}