//package com.codeforces.c;

import java.util.*;

public class B {
    Scanner in = new Scanner(System.in);
    void slove(){
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = in.nextInt();
        }
        char[][] path = new char[n][n];
        for(int i = 0;i < n;i++){
            path[i] = in.next().toCharArray();
        }
        uf = new int[n];
        for(int i = 0;i < n;i++){
            uf[i] = i;
        }
        for(int i = 0;i < n;i++){
            for(int j = i + 1;j < n;j++){
                if(path[i][j] == '1'){
                    union(i,j);
                }
            }
        }
        helper(nums,path);
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
    int[] uf;
    void union(int i,int j){
        int a = find(i);
        int b = find(j);
        uf[a] = b;
    }
    int find(int i){
        if(uf[i] == i){
            return i;
        }
        return find(uf[i]);
    }
    boolean isUnion(int i,int j){
        return find(i) == find(j);
    }
    void helper(int[] nums, char[][] path){
        int len = nums.length;
        for(int i = 0;i < len;i++){
            int pos = i;
            int min = nums[i];
            for(int j = i + 1;j < len;j++){
                if(min > nums[j] &&isUnion(i,j)){
                    min = nums[j];
                    pos = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[pos];
            nums[pos] = temp;
        }
    }
    public static void main(String[] args) {
        B b = new B();
        b.slove();
    }
}

