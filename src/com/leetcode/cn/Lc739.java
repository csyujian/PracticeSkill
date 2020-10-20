package com.leetcode.cn;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/8/14 11:18
 */
public class Lc739 {

        public int[] dailyTemperatures(int[] T) {
            int len = T.length;
            int[] res = new int[len];
            for(int i = 0;i < len - 1;i++){
                if(T[i + 1] > T[i]){
                    res[i] = 1;
                }
            }
            int slow = len;
            for(int i = len - 2;i >= 0;--i){
                if(res[i] > 0){
                    slow = i;
                }else{
                    if(slow != len){
                        int j = slow;
                        while(j < len - 1 && T[j] > 0 ) {
                            j++;
                            if(T[j] > T[i]){
                                break;
                            }
                        }
                        if(j != len && T[j] > T[i]){
                            res[i] = j - i;
                        }
                    }
                }
            }
            return res;
        }

    public static void main(String[] args) {
        Lc739 s = new Lc739();
        int[] T = {34,80,80,34,34,80,80,80,80,34};
        int[] res = s.dailyTemperatures(T);
        for (int t:res
             ) {
            System.out.println(t);
        }
    }
}