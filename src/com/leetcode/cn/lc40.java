package com.leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class lc40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       int len=candidates.length;
       List<List<Integer>> res=new ArrayList<List<Integer>>();
       if(len==0){
           return res;
       }
       Arrays.sort(candidates);
       List<Integer> temp=new ArrayList<>();
       boolean[] used=new boolean[len];
       dfs(candidates,res,used,0,len,temp,target);
       return res;

    }
    int addall(List<Integer> temp){
        int sum=0;
        for(int i :temp){
            sum+=i;
        }
        return sum;
    }
    void dfs(int[] candidates,List<List<Integer>> res,boolean[] used,int start,int len,List<Integer> temp,int target){
    	int sum=addall(temp);
        if(sum==target){
            res.add(new ArrayList<Integer>(temp));
            return;
        }else if(sum>target){
        	return;
        }
        for(int i=start;i<len;i++){
        	if(used[i]!=true){
        		if(i>0&&candidates[i-1]==candidates[i]&&used[i-1]==false){
        			continue;
        		}
        		 temp.add(candidates[i]);
                 boolean[] newUsed = new boolean[len];
                 System.arraycopy(used, 0, newUsed, 0, len);
                 newUsed[i] = true;
                 dfs(candidates,res,newUsed,i+1,len,temp,target);
                 //used[i]=true;
                 temp.remove(temp.size()-1);
        	}  
        }
    }
    public void cal(int[] used,String s){
        for(int i=0;i<s.length();i++){
            used[s.charAt(i)-'a']++;
        }
    }
    public static void main(String[] args) {
		int[] candidates={10,1,2,7,6,1,5};
		List<List<Integer>> res=new lc40().combinationSum2(candidates, 8);
		System.out.println("123");
		System.out.println(res.size());
	}
}