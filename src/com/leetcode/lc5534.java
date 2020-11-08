package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/4 13:45
 */
public class lc5534 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int len = points.size();
        List<Double> dp = new ArrayList<>();
        int count = 0,j = 0;
        for(int i = 0; i < len;i++){
            double px = points.get(i).get(0) - location.get(0);
            double py = points.get(i).get(1) - location.get(1);
            double s = px * px + py * py;
            if(s == 0){
                count ++;
                continue;
            }
            dp.add(Math.atan2(px,py) * 180 / Math.PI);
        }
        Collections.sort(dp);
        int dpLen = dp.size();
        for(int i = 0;i < dpLen;i++){
            dp.add(dp.get(i) + 360);
        }
        int l = 0,r = 0,res = 0;
        while(l < dp.size()){
            while(r < dp.size() && dp.get(r) - dp.get(l) <= angle){
                r++;
            }
            res = Math.max(res,r - l);
            l++;
        }
        return res + count;
    }
}
