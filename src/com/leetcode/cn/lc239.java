package com.leetcode.cn;

import org.junit.Test;

import java.util.*;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/12 14:34
 */
public class lc239 {
//    @Test
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0;i < n;i++){
            if(list.size() >= k){
                list.pollLast();
            }
            while (list.size() > 1 && list.get(list.size() - 1) <= list.get(list.size() - 2)){
                list.pollLast();
            }
            while (!list.isEmpty() && list.peekLast() <= nums[i]){
                list.pollLast();
            }
            list.push(nums[i]);
            if(i >= k - 1){
                res[i - k + 1] = list.peekLast();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        int[] res = new lc239().maxSlidingWindow(nums,3);
        for(int i : res){
            System.out.println(i);
        }



    }
}
