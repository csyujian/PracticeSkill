package com.leetcode;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/27 10:57
 */
public class lc396 {

    public int maxRotateFunction(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int sum = Integer.MIN_VALUE,len = A.length;
        for(int i = 0;i < len;i++){
            int temp = 0;
            for(int j = 0;j < len;j++){
                temp += A[j] * ((i + j) % len);
            }
            sum = Math.max(sum,temp);
        }
        return sum;
    }

    public static void main(String[] args) {
        lc396 s = new lc396();
        int[] A = {4,3,2,6};
        s.maxRotateFunction(A);
        int[] alph = new int[256];
        System.out.println('a' >> 1);
    }
}