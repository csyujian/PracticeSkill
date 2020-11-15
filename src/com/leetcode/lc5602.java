package com.leetcode;

public class lc5602 {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        int[] left = new int[len + 1];
        for(int i = 0;i < len;i++){
            left[i + 1] = nums[i] + left[i];
        }
        int[] right = new int[len + 1];
        for(int i = len - 1;i >= 0;i--){
            right[i] = right[i + 1] + nums[i];
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i <= len;i++){
            int lval = left[i];
            if(lval > x){
                break;
            }else{
                int val = x - lval;
                int t = find2(right,val);
                if(t != -1 && t >= i){
                    res = Math.min(res,i + len - t);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    int find2(int[] nums,int val){
        int l = 0,r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < val ){
                r = mid - 1;
            }else if(nums[mid] > val){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,4,2,3};
        lc5602 s = new lc5602();
        int res = s.minOperations(nums,5);
        System.out.println(res);
    }
}