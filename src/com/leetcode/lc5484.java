package com.leetcode;

public class lc5484 {
    public char findKthBit(int n, int k) {
        if(n == 1 ){
            return '0';
        }
        if(n == 2){
            if( k == 1){
                return '0';
            }else{
                return '1';
            }
        }
        boolean flag = true;
        if(k == (1<<(n-1))){
            return '1';
        }else if(k>(1<<(n-1))){
            flag = false;
            k = (1<<n) - k;
        }
        char ch = findKthBit(n-1,k);
        if(!flag){
            if(ch == '0'){
                return '1';
            }else{
                 return '0';
            }
        }
        return ch;
    }

    public static void main(String[] args) {
        char ch = new lc5484().findKthBit(3,1);
        char ch2 = new lc5484().findKthBit(4,11);
        char ch3 = new lc5484().findKthBit(1,1);
        System.out.println(ch);
        System.out.println(ch2);
        System.out.println(ch3);
        System.out.println((char)65);
    }

}