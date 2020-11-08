package com.leetcode;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/6 10:47
 */
class lc5493 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        for(int i = 1;i < len ;i++){
            if(arr[i] >= arr[i - 1]){
                dp[i] = dp[ i - 1];
            }else{
                if(dp[i - 1] == 0){
                    dp[i] = 1;
                }else if(arr[i] >= arr[i - dp[i - 1]]){
                    dp[i] = dp[i - 1];
                }else{
                    int j = i - dp[i - 1] - 1;
                    while(arr[i] < arr[j]){
                        j--;
                    }
                    dp[i] = Math.min(i - j ,dp[i - 1] + 1);
                }
                //dp[i] = dp[i - 1] + 1;
            }
        }
        return dp[len - 1];

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,10,4,2,3,5};
        lc5493 s = new lc5493();
        int res = s.findLengthOfShortestSubarray(arr);
        System.out.println(res);
    }
}
