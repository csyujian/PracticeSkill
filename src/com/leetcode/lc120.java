package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc120 {
    public int minimumTotal(List<List<Integer>> triangle) {
    	int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
    	List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    	for(int i=0;i<3;i++){
    		List<Integer> tempIntegers = new ArrayList<Integer>();
    		for(int j=0;j<=i;j++){
    			tempIntegers.add(i+j);
    		}
    		triangle.add(tempIntegers);
    	}
		int res=new lc120().minimumTotal(triangle);
		System.out.println(res);
	}
}