package com.leetcode.cn;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/15 16:02
 */
public class lcp12 {
    public int minTime(int[] time, int m) {
        int left = 0,right = 0;
        for(int t : time){
            right += t;
        }
        while(left < right){
            int mid = left + (right - left ) / 2;
            int temp = get(time,mid);
            System.out.println(temp);
            if(temp > m){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }
    static int get(int[] time,int mid){
        int res = 0;
        int i = 0;
        while(i < time.length){
            int max = 0;
            int temp = 0;
            int j = i;
            while(j < time.length && temp - max <= mid){

                max = Math.max(max,time[j]);
                temp += time[j];
                j++;
            }
            if(temp - max > mid){
                i = j - 1;
            }else{
                i = j;
            }

            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] time = {1,2,3};
        int res = new lcp12().minTime(time,2);
        System.out.println(res);
        int a = get(time,0);
        System.out.println(a);
    }
}