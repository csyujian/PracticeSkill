package com.leetcode.cn;

import java.util.ArrayList;
import java.util.List;

class lc916 {
    public void cal(int[] used,String s){
        for(int i=0;i<s.length();i++){
            used[s.charAt(i)-'a']++;
        }
    }
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res=new ArrayList<>();
        /*
        for(int i=0;i<A.length;i++){
            boolean flag=true;
            for(int j=0;j<B.length;j++){
                int[] used=new int[26];
                boolean flag1=true;
                cal(used,B[j]);
                for(int k=0;k<B[j].length();k++){
                    if(--used[B[j].charAt(k)-'a']<0){
                        flag1=false; //����˫��ѭ��
                        flag=false;
                        break;
                    }
                }
                if(flag1==false){
                    break;
                }
                
            }
            if(flag){
                res.add(A[i]);
            }
        }
        */
        search:for(int i=0;i<A.length;i++){
        	int[] usedA=new int[26];
        	cal(usedA, A[i]);
        	for(int j=0;j<B.length;j++){
        		int[] usedB=new int[26];
        		boolean flag=true;
        		cal(usedB, B[j]);
        		for(int k=0;k<26;k++){
        			if(usedA[k]<usedB[k]){
        				continue search;
        			}
        		}
        	}
        	res.add(A[i]);
        }
        return res;
    }
    public static void main(String[] args) {
		String[] A = {"amazon","apple","facebook","google", "algorithms"};
		String[] B = {"e","o"};
		List<String> resList =new lc916().wordSubsets(A, B);
		System.out.println(resList.size());
	}
}