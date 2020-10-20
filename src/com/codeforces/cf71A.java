package com.codeforces;

import java.util.Scanner;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/9 18:57
 */
public class cf71A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n-- > 0){
            String str = in.next();
            if(str.length() <= 10){
                System.out.println(str);
                continue;
            }
            System.out.print(str.charAt(0));
            int len = str.length() - 2;
            System.out.print(len);
            System.out.println(str.charAt(len+1));
        }
    }
}
