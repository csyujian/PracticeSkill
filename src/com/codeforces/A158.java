package com.codeforces;

import java.util.Scanner;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/25 16:35
 */
public class A158 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(),k = in.nextInt();
        int count = 0;
        int[] nums = new int[n];
        for(int i = 0; i < n;i++){
            nums[i] = in.nextInt();
        }
        for(int i = 0;i < n;i++){
            if(nums[i] >= nums[k - 1] && nums[i] > 0){
                count++;
            }
        }
        System.out.println(count);
    }
}
