package com.leetcode;

import java.util.Arrays;

public class lc5563 {
    public int maxProfit(int[] inventory, int orders) {
        int len = inventory.length;
        Integer[] ni = new Integer[len + 1];
        for (int i = 0; i < inventory.length; i++) {
            ni[i] = inventory[i];
        }
        ni[inventory.length] = 0;
        Arrays.sort(ni, ((o1, o2) -> o2 - o1));
        int pre = ni[0];
        int mod = 1000000007;
        long ans = 0L;
        return (int)ans % mod;
    }

    public static void main(String[] args) {
        int[] inventory = {497978859,167261111,483575207,591815159};
        int[] inventory1 = {2,4,4,6};

        lc5563 s = new lc5563();
        for(int i = 1;i <=16;i++){
            int res = s.maxProfit(inventory,i);
            System.out.println(res);
        }
    }
}