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
        //��ʼ��
        init();
    }
    void init(){
        for(int i = 0 ;i < fa.length;i++){
            fa[i] = i;
        }
        Arrays.fill(size,1);
    }
    //Ѱ������
    int find1(int x){
        //���x���������ȷ���
        if(fa[x] == x){
            return x;
        }
        //�����������x�İְ���x��үү
        else {
            return find1(fa[x]);
        }
    }
    //·��ѹ����ʹ�����еĽ�㶼ָ������
    int find2(int x){
        if(x != fa[x]){
            fa[x] = find1(fa[x]);
        }
        return fa[x];
    }
    //�ϲ�
    void unionSet1(int x,int y){
        x = find1(x);
        y = find1(y);
        if(x == y){
            return;
        }else{
            fa[x] = y;
        }
    }
    //����ʽ�ϲ�����С�����Ѻϲ�
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
