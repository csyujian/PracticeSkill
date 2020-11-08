package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc5562 {
    public int minDeletions(String s) {
        int len = s.length();
        //ÖØÐÂÅÅÁÐ×Ö·û´®
        int[] dp = new int[26];
        for(char ch : s.toCharArray()){
            dp[ch - 'a']++;
        }
        Arrays.sort(dp);
        List<Integer> list = new ArrayList<>();
        int pre = 1;
        for(int i : dp){
            if(i > 0 && i >= pre){
                for(int j = pre ;j < i;j++){
                    list.add(j);
                }
                pre = i + 1;
            }
        }
        for(int i : list){
            System.out.println(i);
        }
        System.out.println();
        int ans = 0;
        int index = list.size() - 1;
        for(int i = 24;i >= 0;i--){
            if(dp[i] == dp[i + 1]){
                while(index >= 0 && list.get(index) >= dp[i]){
                    index--;
                }
                if(index >= 0){
                    ans += dp[i] - list.get(index);

                }else {
                    ans += dp[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "accdcdadddbaadbc";
        lc5562 s = new lc5562();
        int res = s.minDeletions(str);
        System.out.println(res);
    }

}