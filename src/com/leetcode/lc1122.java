package com.leetcode;

import java.util.*;

public class lc1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] res = new int[n1];
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int a : arr2){
            map2.put(a,0);
        }
        for(int a : arr1){
            if(map2.containsKey(a)){
                map2.put(a,map2.get(a) + 1);
            }else{
                map1.put(a,map1.getOrDefault(a,0) + 1);
            }
        }
        int index = 0;
        for (int val : arr2) {
            int len = map2.get(val);
            for (int j = 0; j < len; j++) {
                res[index++] = val;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int k : arr1) {
            if (map1.containsKey(k)) {
                list.add(k);
            }
        }
        Collections.sort(list);
        for(int i : list){
            res[index++] = i;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = {2,42,38,0,43,21};
        lc1122 s = new lc1122();
        int[] res = s.relativeSortArray(arr1,arr2);
        for(int r : res){
            System.out.print(r + " ");
        }
    }
}