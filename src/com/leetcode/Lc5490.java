package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/8/16 11:43
 */
public class Lc5490 {
    public int minDays(int n) {
        if(n==1) {
            return 1;
        }
        int p = 1073741824,q = 1162261467;
        int count3 = 19,count2=0,count1 = 1;
        while(n%2==0){
            n=n>>1;
            count2++;
        }
        while(q > n){
            q /= 3;
            count3--;
        }
        while( q < n && count3 >=0){
            if(n - q <= count3){
                return count3+count2+count1 + n - q;
            }
            if(n%2==0){
                if(n/2 - q <= count3){
                    return count3+count2+count1 + n / 2 - q + 1;
                }
            }
            while(q * 2 <= n){
                count2++;
                q *=2;
            }

            if(n - q == 1){
                return count3+count2+count1 + n - q;
            }

            q /=3;
            count3--;
        }
        return count3 + count1 +count2;

    }

    public static void main(String[] args) {
        Lc5490 s = new Lc5490();
        int res1 = s.minDays(12);
        System.out.println(12+" "+res1);
        for(int i = 1;i<=56;i++){
            int res = s.minDays(i);
            System.out.println(i+" "+res);
        }
        System.out.println("------------------------");
        System.out.println(s.fun(182));
    }
    int fun(int n){
        int res;
        if(n == 1){
            return 1;
        }else  if(n == 2 || n == 3){
            return 2;
        }else if(n%3 == 0){
            res = Math.min(fun(n/3),fun(n-1)) + 1;
        }else if(n % 2 == 0){
            //res = Math.min(fun())
            if((n - 1)%3 == 0){
                res = Math.min(fun(n-1),fun(n/2)) + 1;
            }else{
                res = Math.min(fun(n-2),fun(n/2)) + 1;
            }
        }else{
            if((n - 1)%3 == 0){
                res = fun(n-1) + 1;
            }else{
                res = Math.min(fun(n - 2) + 2,fun(n-1) + 1);
            }
        }
        return res;
    }
    int fun1(int n ){
        Map<Integer,Integer> map = new HashMap<>();
        int a = 1,b=1;
        for(int i = 1 ; i<= 31;i++){
            a *=2;
            b = 1;
            for(int j = 1;j<= 20;j++) {
                b *= 2;
                if ((long) (a * b) < Integer.MAX_VALUE) {
                    map.put(a * b, i + j + 1);
                } else {
                    break;
                }
            }
        }
        int res = 0;
        while(!map.containsKey(n)){
            if(n%2 == 0){
                if(map.containsKey(n/2));
            }
        }
        return 0;
    }
}