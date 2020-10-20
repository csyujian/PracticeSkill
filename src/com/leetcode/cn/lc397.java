package com.leetcode.cn;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/27 10:37
 */
public class lc397 {
    public int integerReplacement(int n) {
        if(n == 1){
            return 0;
        }else if(n == 3){
            return 2;
        }
        if(n % 2== 0){
            return integerReplacement(n / 2) + 1;
        }else{
            if ( (n & 2) > 0){
                return integerReplacement(n + 1) + 1;
            }else{
                return integerReplacement(n / 2) + 2;
            }
        }
    }

    public static void main(String[] args) {
        lc397 s = new lc397();
        int res = s.integerReplacement(2147483647);
        System.out.println(res);
    }
}