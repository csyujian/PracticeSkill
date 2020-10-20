package com.leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/8/10 19:52
 */
public class Lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int right = nums.length - 1;
            // second loop to judge sum of three numbers
            int left = i + 1;
            while (left < nums.length) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                while (left < right && nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
                if (left == right) {
                    break;
                }
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                }
                left++;
            }
        }
        return  res;
    }



    public static void main(String[] args) {
        Lc15 s = new Lc15();
        int[] nums = {-2, -1,-1,-1,3,3,3};
        List<List<Integer>> res = s.threeSum(nums);
        for (List<Integer> list:res) {
            for (Integer i: list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
