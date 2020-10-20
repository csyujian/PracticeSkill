package com.leetcode.cn;

import java.util.HashMap;

class lc5476 {
    public int getWinner(int[] arr, int k) {
        int len = arr.length;
        int temp=0,time=0;
        while(true){
            if(arr[0]>arr[1]){
                time++;
                if(time==k){
                    return arr[0];
                }
                if(time == len-1 && time<k){
                    return arr[0];
                }
                temp = arr[1];
                for(int i =1;i<len-1;i++){
                    arr[i]=arr[i+1];
                }
                arr[len-1]=temp;

            }else{
                time=1;
                if(time==k){
                    return arr[1];
                }
                temp = arr[0];
                for(int i =0;i<len-1;i++){
                    arr[i]=arr[i+1];
                }
                arr[len-1]=temp;
            }
        }
        //return arr[0];

    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,5,4,6,7};
        int res =new lc5476().getWinner(nums,2);
        System.out.println(res);
        //Integer.bitCount();
        //HashMap
    }
}


