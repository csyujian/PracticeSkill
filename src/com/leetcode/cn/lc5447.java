package com.leetcode.cn;

import java.util.Arrays;

public class lc5447 {
    public boolean winnerSquareGame(int n) {
        if(n<0){
            return false;
        }else if(n==1){
            return true;
        }
        boolean[] res=new boolean[n+1];
        int[] res1=new int[10];
        Arrays.sort(res1);
       
        res[0]=false;
        //res[1]=true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                if(j*j>i){
                    break;
                }else{
                    if(res[i-j*j]==false){
                        res[i]=true;
                        break;
                    }
                }
            }
        }
        return res[n];
    }
    public static void main(String[] args) {
		new lc5447().winnerSquareGame(5);
		
	}
}
