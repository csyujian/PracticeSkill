package com.leetcode.cn;

import java.util.Arrays;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/8/17 9:20
 */
public class lc322 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
//[186,419,83,408] 6249 测试结果:-1 期望结果:20 stdout:
    public static void main(String[] args) {
        int[] coins = {3,2,5};
        lc322 s = new lc322();
        int res = s.coinChange(coins,11);
        System.out.println(res);
    }
}
