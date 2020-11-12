package com.codeforces.B;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    Scanner in = new Scanner(System.in);
    void sovle(){
        int t = in.nextInt();
        while (t-- > 0){
            int n = in.nextInt();
            long[] dp = new long[n];
            for(int i = 0;i < n;i++){
                dp[i] = in.nextLong();
            }
            Arrays.sort(dp);
            long res = 0;
            for(int i = 0;i < n;i++){
                res = Math.max(res,(n - i) * dp[i]);
            }
            System.out.println(res);

        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.sovle();
    }
}