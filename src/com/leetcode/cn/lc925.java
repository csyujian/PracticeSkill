package com.leetcode.cn;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/21 14:27
 */
public class lc925 {
    boolean match(String s,String t){
        int m = s.length();
        int n = t.length();
        return false;
    }
    public static void main(String[] args) {
        String s = "aabc";
        String p = "a.bc";
        lc925 solution = new lc925();
        boolean res = solution.match(s,p);
        System.out.println(res);
    }
}