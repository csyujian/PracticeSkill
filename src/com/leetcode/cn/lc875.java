package com.leetcode.cn;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/15 13:23
 */
public class lc875 {
    public int minEatingSpeed(int[] piles, int H) {
        int n = piles.length;
        int max = 0;
        for (int pile : piles) {
            max  = Math.max(max,pile);
        }
        int right = max;
        int left = 1;
        while(left < right){
            int mid = left + (right - left ) / 2;
            int ans = get(piles,mid);
            if(ans > H){
                left = mid + 1;
            }else if(ans == H){
                right = mid;
            }else{
                right = mid;
            }
        }
        int a = get(piles,13);
        if(a <= H){
            System.out.println(true);
        }
//        System.out.println(get(piles,13));
        return left;
    }
    int get(int[] piles,int mid){
        int res = 0;
        for (int pile : piles) {
            res += pile / mid;
            if (pile % mid != 0) {
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles = {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int res = new lc875().minEatingSpeed(piles,823855818);
        System.out.println(res);
    }
}