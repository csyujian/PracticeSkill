package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/8/23 11:58
 */
public class lc5497 {
    public int findLatestStep(int[] arr, int m) {
        int len = arr.length;
        int[] dp = new int[len + 1];
        for(int i = 0;i < len;i++){
            int j = arr[i];
            dp[j] = dp[j - 1] + 1;
            int k = dp[j];
            //j++;
            while(j + 1< len && dp[j + 1] > 0){
                dp[j + 1] += k;
                j++;
            }
            if(j <= len && dp[j] == m && dp[1] > 0 && dp[len] >0){
                return i+1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {3,5,1,2,4};
        lc5497 c = new lc5497();
        int res = c.findLatestStep(arr,1);
        System.out.println(res);
        List<String> testList = new ArrayList<String>(){{add("aa");add("bb");add("cc");}};
        String[] array2 = testList.toArray(new String[testList.size()]);
        for(int i = 0; i < array2.length; i++){
            System.out.println(array2[i]);
        }
    }
}

