package com.codeforces.D;

import java.util.Scanner;

public class A {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        A a = new A();
        a.solve();
    }

    private void solve() {
        int t = in.nextInt();
        while(t-- > 0){
            helper(in.nextInt());
        }
    }

    private void helper(int n) {
        for(int i = 0;i < n;i++){
            System.out.print(1 + " ");
        }
        System.out.println();
    }
}
