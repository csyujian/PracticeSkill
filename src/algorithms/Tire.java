package algorithms;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/14 14:36
 * 数组方式
 */
public class Tire {
    private int[][] nex;
    private boolean[] exist;
    private int cnt = 0;
    public Tire(int len){
        nex = new int[len][26];
        exist = new boolean[len];
        cnt = 0;
    }
    void insert(String s){
        int p = 0;
        for(char ch : s.toCharArray()){
            int c = ch - 'a';
            if(nex[p][c] != 0){
                nex[p][c] = ++cnt;
            }
            p = nex[p][c];
        }
        exist[p] = true;
    }
    boolean find(String s){
        int p = 0;
        for(char ch : s.toCharArray()){
            int c = ch - 'a';
            if(nex[p][c] != 0){
                return false;
            }
            p = nex[p][c];
        }
        return exist[p];
    }
}