package com.leetcode;

import java.lang.invoke.MethodHandle;
import java.util.*;

public class lc514 {
    int[][] dp;
    int len;
    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> map = new HashMap<>();
        len = ring.length();
        for(int i = 0;i < ring.length();i++){
            Character ch = ring.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,new ArrayList<>());
            }
            map.get(ch).add(i);
        }
        dp = new int[key.length()][len];
        for(int i = 0;i < key.length();i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return dfs(key.toCharArray(),0,0,map);
    }
    private int dfs(char[] key, int index, int pos, Map<Character,List<Integer>> map){
        if(index == key.length){
            return 0;
        }
        if(dp[index][pos] != Integer.MAX_VALUE){
            return dp[index][pos];
        }
        int res = Integer.MAX_VALUE;
        Character ch = key[index];
        List<Integer> vis = map.get(ch);
        for (int batch : vis) {
            int temp = Math.min(Math.abs(batch - pos), len - Math.abs(pos - batch)) + 1;
            temp += dfs(key, index + 1, batch, map);
            res = Math.min(res, temp);
        }
        dp[index][pos] = res;
        return res;
    }

    public static void main(String[] args) {
        String ring = "caotmcaataijjxi";
        String key = "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx";

        lc514 s = new lc514();
        int res = s.findRotateSteps(ring,key);
        System.out.println(res);
    }
}