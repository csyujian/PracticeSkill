package com.leetcode;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/27 13:57
 */
public class lc41 {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0;i < len;i++){
            if( nums[i] > 0  && nums[i] <= len && nums[nums[i] - 1] != nums[i] ) {
                swap(nums, nums[i], nums[nums[i] -1 ]);
            }
        }

        for(int i = 0;i < len;i++){
            if(nums[i] != i + 1){
                return i;
            }
        }
        return len;
    }
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args){
        int[][] nums = {
//                {1,2,0},
//                {3,4,-1,0},
//                {7,8,9,11,12},
                {2,3,4,-1,1,7,6,5}
        };
        lc41 s = new lc41();
        for(int[] num : nums){
            int res = s.firstMissingPositive(num);
            System.out.println(res);
        }
    }

}