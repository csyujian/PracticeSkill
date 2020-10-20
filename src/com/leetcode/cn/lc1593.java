package com.leetcode.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/14 13:20
 */
public class lc1593 {
    Set<String> set;
    int res = 0;
    public int maxUniqueSplit(String s) {
        set = new HashSet<>();
        dfs(s,0,0);
        return res;
    }
    void dfs(String s,int pre,int index){
        for(int i = index + 1;i <= s.length();i++){
            if(!set.contains(s.substring(pre,i))){
                set.add( s.substring(pre,i));
                if(i == s.length()){
                    res = Math.max(set.size(),res);
                }else{
                    dfs(s,i,i);
                }
                set.remove(s.substring(pre,i));
            }
        }
    }

    public static void main(String[] args) {
        String s = "ababccc";
        int res=  new lc1593().maxUniqueSplit(s);
        System.out.println(res);
    }

}