package algorithms;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/20 12:15
 */
public class UnionFind {

    public UnionFind(){

    }
    int[] fa;
    int[] size;

    void makeSet(int n){
        fa = new int[n];
        size = new int[n];
        for(int i = 0;i < n;i++){
            fa[i] = i;
            size[i] = 1;
        }
    }
    int find(int x){
        if(fa[x] == x){
            return x;
        }
        return find(fa[x]);
    }

    void union(int x,int y){
        int xx = find(x);
        int yy = find(y);
        if(size[xx] > size[yy]){
            int temp = xx;
            xx = yy;
            yy = temp;
        }
        fa[xx] = yy;
        size[yy] += size[xx];
    }
    boolean check(int x,int y){
        int xx = find(x);
        int yy =find(y);
        return xx == yy;
    }
    void union1(int x,int y){
        x = find(x);
        y = find(y);
        if(x == y){
            return;
        }
        fa[x] = y;
    }

    public static void main(String[] args) {
        UnionFind s = new UnionFind();
        s.makeSet(2);
    }
}