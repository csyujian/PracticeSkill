package com.leetcode;

class lc795 {
    public int fac(int n){
        if(n==0)
        return 0;
        if(n==1)
            return 1;
        return n+fac(n-1);
    }
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int fast=0,slow=-1;
        int sum=0,max=0;
        for(;fast<A.length;fast++){
        	max=A[fast]>max?A[fast]:max;
            if(!(max>=L&&max<=R)){
                sum+=fac(fast-slow-1);
                slow=fast;
                max=0;
            }
        }
        sum+=fac(fast-slow-1);
        return sum;
    }
    public static void main(String[] args) {
		int[] A={2,1,4,3};
		int res= new lc795().numSubarrayBoundedMax(A, 2, 3);
		System.out.println(res);
	}
}