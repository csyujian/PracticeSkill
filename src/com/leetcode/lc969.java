package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/22 11:51
 */
public class lc969 {
    public static void main(String[] args) {
        int[] A = {3, 2, 4, 1,5,0,7};
        int N = A.length;
        List<Integer> ans = new ArrayList();
        //Ϊʲôʹ��Integer
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i) {
            B[i] = i + 1;
        }
        //����Ϊģ��������
        Arrays.sort(B, (i, j) -> A[i - 1] - A[j - 1]);

        for (int i : B) {
            for (int f : ans) {
                if (i <= f) {
                    i = f + 1 - i;
                }

            }
            ans.add(i);
            ans.add(N--);

        }
    }
}