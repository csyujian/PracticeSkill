package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/4 9:28
 */
class lc51 {
    char[][] queens;
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        queens = new char[n][n];
        //≥ı ºªØ
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                queens[i][j] = '.';
            }
        }
        res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        backTrace(0,map);
        return res;
    }
    void backTrace(int depth, Map<Integer,Integer> map) {
        int len = queens.length;
        if (depth == len) {
            List<String> temp = new ArrayList<>();
            for (char[] queen : queens) {
                temp.add(new String(queen));
            }
            res.add(temp);
            return;
        }
        int ava = 0;
        for(int i = 0;i < map.size();i++){
            int value = map.get(i);
            ava |= 1 << value;
            if(i+ value - depth < len && i + value - depth >= 0){
                ava |= 1 << ( i + value - depth);
            }
            if (value - i + depth >= 0 && value - i + depth < len) {
                ava |= 1 << (value - i + depth );
            }
        }
        if(ava == 1 << len - 1){
            return;
        }

        for (int i = 0; i < len; i++) {
            if((ava & (1 << i)) == 0){
                map.put(depth,i);
                queens[depth][i] = 'Q';
                backTrace(depth+1,map);
                queens[depth][i] = '.';
                map.remove(depth);
            }
        }
    }


    public static void main(String[] args) {
        lc51 s = new lc51();
        List<List<String>> res = s.solveNQueens(4);
        for(List<String> lists : res){
            for(String str:lists){
                System.out.println(str);
            }
            System.out.println();
        }
    }
}