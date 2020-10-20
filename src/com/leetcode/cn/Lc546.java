package com.leetcode.cn;

import java.util.Arrays;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/8/15 9:25
 */
public class Lc546 {
    int res;
    public int removeBoxes(int[] boxes) {
        int len  = boxes.length;
        boolean[] used = new boolean[len];
        res = 0;
        dfs(boxes,used,0,0);
        return res;
    }
    void dfs(int[] boxes,boolean[] used,int n,int temp){
        if(n == boxes.length){
            res = Math.max(temp,res);
            return;
        }
        Integer flag = null;
        for(int i = 0 ;i<boxes.length;i++){
            if(!used[i]) {
                if (flag == null || flag != boxes[i]) {
                    boolean[] newused = new boolean[boxes.length];
                    System.arraycopy(used, 0, newused, 0, boxes.length);
                    int count = 0;
                    for (int j = i; j < boxes.length; j++) {
                        if(!newused[j]) {
                            if (boxes[i] == boxes[j]) {
                                newused[j] = true;
                                count++;
                            } else {
                                break;
                            }
                        }
                    }



                    dfs(boxes, newused, n + count, temp + count * count);
                    flag = boxes[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        Lc546 s = new Lc546();
        int[] boxes = {3,8,8,5,5,3,9,2,4,2,4,2,4,2,4};
        int res = s.removeBoxes(boxes);
        System.out.println(res);
    }
}
