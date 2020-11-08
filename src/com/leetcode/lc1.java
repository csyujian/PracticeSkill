package com.leetcode;

public class lc1 {
    public int[] twoSum(int[] nums, int target) {
        int max = 2047;
        int length = nums.length;
        int[] targetArray = new int[max + 1];
        for (int i = 0;i < length;i++) {
            int num = target - nums[i];
            int index = num & max;
            if (targetArray[index] != 0) {
                return new int[]{i, targetArray[index] - 1};
            }
            targetArray[nums[i] & max] = i + 1;
        }
        return null;
    }

    public static void main(String[] args) {
        lc1 s = new lc1();
        int[] nums = {111111111,967,111111111};
        int[] res = s.twoSum(nums,222222222);
        System.out.printf(res[0]+" "+res[1]);
    }
}
