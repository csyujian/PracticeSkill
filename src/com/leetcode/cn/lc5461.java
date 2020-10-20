package com.leetcode.cn;

public class lc5461 {
	//class Solution {
	    public int numSub(String s) {
	        int slow=-1,fast=0,len=s.length(),res=0;
	        int[] remain=new int[len+1];
	        for(int i=1;i<=len;i++){
	            remain[i]+=remain[i-1]+i;
	            remain[i]%=1000000007;
	        }
	        while(fast<len){
	            if(s.charAt(fast)=='0'){
	                res+=remain[fast-slow-1];
	                res%= 1000000007;
	                slow=fast;
	            }
	                fast++;
	            
	        }
	        if(s.charAt(fast-1)=='1'){
	            res+=remain[fast-slow-1];
	            res%=1000000007;
	        }
	        return res;
	    }
	//}
	    public static void main(String[] args) {
			int res=new lc5461().numSub("111111");
			System.out.println(res);

			
		}
}
