//package com.codeforces;

import java.util.Scanner;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/9 19:24
 */
public class cf231A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        while(n-- > 0){
            int temp = 0 ;
            temp += in.nextInt();
            temp += in.nextInt();
            temp += in.nextInt();
            if(temp >= 2){
                res++;
            }
        }
        System.out.println(res);
    }
}
