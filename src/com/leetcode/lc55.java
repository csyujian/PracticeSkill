package com.leetcode;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/22 18:50
 */
public class lc55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[][] dp = new boolean[len][len];
        for(int i = 0;i < len;i++){
            for(int j = 1;j <= nums[i] && i + j < len;j++){
                dp[i][i+j] = true;
            }
        }
        dp[0][0] = true;
        for(int i = 0;i < len;i++){
            if(!dp[i][0]){
                boolean flag = false;
                for(int j = 0;j < i;j++){
                    if(dp[j][i]){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    dp[i][0] = true;
                }
            }
        }
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5};
        lc55 s = new lc55();
        boolean res = s.canJump(nums1);
        System.out.println(res);
    }
}
