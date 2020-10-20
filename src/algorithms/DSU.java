package algorithms;

import java.util.Arrays;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/14 14:59
 */
public class DSU {
    private int[] fa;
    private int len;
    private int[] size;
    public DSU(int len){
        fa = new int[len];
        this.len = len;
        size = new int[len];
        //初始化
        init();
    }
    void init(){
        for(int i = 0 ;i < fa.length;i++){
            fa[i] = i;
        }
        Arrays.fill(size,1);
    }
    //寻找祖先
    int find1(int x){
        //如果x是祖先则先返回
        if(fa[x] == x){
            return x;
        }
        //如果不是则是x的爸爸问x的爷爷
        else {
            return find1(fa[x]);
        }
    }
    //路径压缩，使得所有的结点都指向祖先
    int find2(int x){
        if(x != fa[x]){
            fa[x] = find1(fa[x]);
        }
        return fa[x];
    }
    //合并
    void unionSet1(int x,int y){
        x = find1(x);
        y = find1(y);
        if(x == y){
            return;
        }else{
            fa[x] = y;
        }
    }
    //启发式合并，按小堆向大堆合并
    void unionSet2(int x,int y){
        int xx = find2(x),yy = find2(y);
        if(xx == yy) {
            return ;
        }
        if(size[xx] > size[yy]){
            int temp = xx;
            xx = yy;
            yy = temp;
        }
        fa[xx] = yy;
        size[yy] += size[xx];
    }
}
