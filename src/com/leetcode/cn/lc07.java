package com.leetcode.cn;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/20 8:41
 */
public class lc07 {
    int reverse(int x){
        String str = String.valueOf(x);
        
        long res = 0;
        for(char ch : str.toCharArray()){
            if(ch == '+'){
                continue;
            }else if(ch == '-'){
                res *= -1;
            }
            res = res * 10 + (ch - '0');
            if(res > Integer.MAX_VALUE ){
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int[] ints = {123,-123,120};
        lc07 s = new lc07();
        for (int i : ints) {
            System.out.println(s.reverse(i));
        }
    }
}
