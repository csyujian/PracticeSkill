package com.leetcode.cn;

import java.util.*;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/17 11:14
 */
public class lc52 {

    int res = 0;
    char[][] queen;
    boolean[] col;
    public int totalNQueens(int n) {
        queen = new char[n][n];
        col = new boolean[n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                queen[i][j] = '.';
            }
        }

        dfs(0,n);
//        int aa = max(1,3,2,4);
//        System.out.println(aa);
        return res;
    }
    void dfs(int depth,int n){
        if(depth == n){
            res++;
            return;
        }
        for(int i = 0;i <n;i++){
            if(!col[i]){
                boolean flag = true;
                for(int j = 0;j < depth;j++){

                    if(i + depth - j < n && i +depth -j >= 0 && queen[j][i + depth - j] == 'Q'){
                        flag = false;
                        break;
                    }
                    if(j - depth + i < n && j -depth + i >= 0 && queen[j][j - depth + i] == 'Q'){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    queen[depth][i] = 'Q';
                    col[i] = true;
                    dfs(depth + 1,n);
                    col[i] = false;
                    queen[depth][i] = '.';
                }
            }
        }
    }

    public static void main(String[] args) {
        int res = new lc52().totalNQueens(4);
        System.out.println(res);
    }
}
class Fancy {
    class Oper {
        public int op;
        public int v;
        public Oper(int op, int v) {
            this.op = op;
            this.v = v;
        }
    }
    private List<Integer> list = new ArrayList<>();
    private List<Integer> seqlist = new ArrayList<>();
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    private List<Oper> operList = new ArrayList<>();

    private int seq = 0;
    private int m = 1000000007;

    public Fancy() {

    }

    public void append(int val) {
        int oldSeq = seq++;
        Oper oper = new Oper(0, val);
        list.add(val);
        seqlist.add(oldSeq);
    }

    public void addAll(int inc) {
        int oldSeq = seq++;
        Oper oper = new Oper(1, inc);
        operList.add(oper);
        map.put(oldSeq, operList.size()-1);
    }

    public void multAll(int m) {
        int oldSeq = seq++;
        Oper oper = new Oper(2, m);
        operList.add(oper);
        map.put(oldSeq, operList.size()-1);
    }

    public int getIndex(int idx) {
        int oldSeq = seq++;
        // Oper oper = new Oper(3, idx);
        // map.put(oldSeq, oper);

        if (idx >= list.size()) {
            return -1;
        }

        int val = list.get(idx);
        int targetSeq = seqlist.get(idx);

        Integer s = map.ceilingKey(targetSeq);
        if (s == null) {
            return val;
        }
        int index = map.get(s);

        long ret = (long)val;
        for (int i = index; i < operList.size(); ++i) {
            Oper oper = operList.get(i);

            if (oper.op == 1) {
                ret += oper.v;
            } else {
                ret *= oper.v;
            }

            if (ret > 0x8fffffffffffffL) {
                ret %= m;
            }
        }
        return (int)(ret % m);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
