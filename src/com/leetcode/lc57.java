package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/22 21:46
 */
public class lc57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int L = newInterval[0],R = newInterval[1];
        List<int[]> res = new ArrayList<>();
        boolean flag = false;
        for(int i = 0;i < len;i++){
            if(intervals[i][1] < L){
                res.add(intervals[i]);
            }else if(intervals[i][0] > R){
                if(!flag){
                    res.add(newInterval);
                }
                res.add(intervals[i]);
            }else{
                if(!flag){
                    intervals[i] = new int[]{Math.min(intervals[i][0],L),Math.max(intervals[i][1],R)};
                    res.add(intervals[i]);
                }else{
                    //res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1],intervals[1]);
                }



            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        lc57 s = new lc57();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newintervals = {4,8};
        int[][] res= s.insert(intervals,newintervals);
        for(int[] r : res){
            for(int i : r){
                System.out.println(i);
            }
        }
    }
}