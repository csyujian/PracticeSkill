package com.codeforces.D;


import java.util.Scanner;

public class C {
    Scanner  in = new Scanner(System.in);
    void slove(){
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt(),m = in.nextInt();
            int[][] matrix = new int[n][m];
            for(int i = 0;i <n;i++){
                for(int j = 0;j < m;j++){
                    int temp = in.nextInt();
                    if((i + j) % 2 == 0){
                        if(temp % 2 != 0){
                            temp += 1;
                        }
                    }else{
                        if(temp % 2 == 0){
                            temp += 1;
                        }
                    }
                    matrix[i][j] = temp;
                }
            }
            for(int i = 0;i < n;i++){
                for(int j = 0;j < m;j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        C c = new C();
        c.slove();
    }
}