package com.leetcode.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/22 23:27
 */
public class lc75 {
    //你能想出一个仅使用常数空间的一趟扫描算法吗？
    public void sortColors(int[] nums) {
        int l = 0,r = nums.length - 1;
        int len = nums.length;
        int left = 0;
        while(l < r){
            while( l < len && nums[l] == 0){
                left++;
                l++;
            }
            while(r >= 0 && nums[r] == 2){
                r--;
            }
            if(l < r){
                if(nums[l] == 2 && nums[r] == 0){
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    l++;r--;
                }else if(nums[l] == 2){
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    r--;
                }else if(nums[r] == 0){
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    l++;
                }else {
                    l++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 1234;
        String str = String.valueOf(n);
        lc75 s = new lc75();
        int[] nums = {2,0,2,1,1,0};
        s.sortColors(nums);
        StringBuilder sb = new StringBuilder();
        List<Integer> res = new ArrayList<>();
        res.add(1);
        
    }
}