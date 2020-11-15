package com.codeforces.c;

import java.util.Scanner;

public class A {
    Scanner in = new Scanner(System.in);
    void solve(){
        int n = in.nextInt(),t = in.nextInt();
        int start = 1;

        for(int i = 1;i <= n;i++ ){
            int m = in.nextInt();
            if(start == i){
                start += m;
            }
            if(start >= t){
                break;
            }
        }
        System.out.println(start == t ? "YES" : "NO");
    }
    public static void main(String[] args) {
        A a = new A();
        a.solve();
    }
}
