package com.codeforces;

import java.util.Scanner;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/9 8:38
 */
public class cf4A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        if(a % 2 == 0 && a > 2){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
