package algorithms;

import java.util.Arrays;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/10/19 20:32
 */

public class SegTree {
    int n;
    int[] arr, sum, lazy,mul;
    public SegTree(int[] arr){
        this.arr = arr;
        this.n = arr.length;
        sum = new int[n << 2];
        lazy = new int[n << 2];
        mul = new int[n << 2];
        Arrays.fill(mul,1);
        build(0,n - 1,0);
    }

    /**
     *
     * @param l ��ǰ��㱻��ʾ������ĺ͵���˵�
     * @param r ��ǰ��㱻��ʾ������ĺ͵��Ҷ˵�
     * @param pos ��ǰ�������
     */
    void build(int l,int r,int pos){
        if(l == r){
            sum[pos] = arr[l];
            return;
        }
        int m = (l + r) >> 1;
        build(l,m,(pos << 1) | 1);
        build(m + 1,r,(pos << 1) + 2);
        sum[pos] = sum[(pos << 1) | 1] + sum[(pos << 1) + 2];
    }

    /**
     *
     * @param l ��ѯ�������˿�
     * @param r ��ѯ������Ҷ˿�
     * @param start ��ǰ����ʾ�ĺ͵���˿�
     * @param end ��ǰ����ʾ�ĺ͵��Ҷ˿�
     * @param pos ��ǰ����λ��
     * @return ���غ�
     */
    int query(int l,int r,int start,int end,int pos){
        //�����ѯ�����ڵ�ǰ���İ���������֮�ڣ���ô��ֱ�ӷ���
        if(l <= start && end <= r){
            return sum[pos];
        }
        int m = (start + end) >> 1;
        if(lazy[pos] != 0){
            sum[(pos << 1) | 1] += lazy[pos] * (m - start + 1);
            sum[(pos << 1) + 2] += lazy[pos] * (end - m);
            lazy[pos] = 0;
        }

        int sum = 0;
        //�������ѯ������Ķ˵����е����ߣ���ζ����������Ҫ����ѯ
        if(l <= m){
            sum += query(l,r,start,m,(pos << 1) | 1);
        }
        //�������ѯ��������˵����е���ұߣ���ζ����������Ҫ����ѯ
        if( m < r){
            sum += query(l,r,m + 1,end,(pos << 1) + 2);
        }
        return sum;
    }

    /**
     *
     * @param l ���޸��������˵�
     * @param r ���޸�������Ҷ˵�
     * @param c ���޸ĵ�ֵ
     * @param s ��ǰ����ʾ�͵���˵�
     * @param t ��ǰ����ʾ�͵��Ҷ˵�
     * @param pos ��ǰ����λ��
     */
    void add(int l, int r, int c, int s, int t, int pos){
        if(l <= s && t <= r){
            sum[pos] += (t - s + 1) * c;
            lazy[pos] += c;
            return;
        }
        int m = ( s + t) >> 1;
        if(lazy[pos] != 0){
            sum[(pos << 1) | 1] += lazy[pos] * (m - s + 1);
            sum[(pos << 1) + 2] += lazy[pos] * (t - m);
            lazy[pos] = 0;
        }
        if(l <= m){
            add(l,r,c,s,m,(pos << 1) | 1);
        }
        if(r > m){
            add(l,r,c,m + 1,t,(pos << 1) + 2);
        }
        up(pos);
    }
    void mul(int l,int r,int c,int s,int t,int pos){
        int mid = (s + t) >> 1;
        if(l <= s && t <= r){
            mul[pos] *= c;
            lazy[pos] *= c;
            sum[pos] *= c;
            return;
        }
        pd(pos,s,t);
        if(mid >= l){
            mul(l,r,c,s,mid,(pos << 1) | 1);
        }
        if(mid < r){
            mul(l,r,c,mid + 1,t,(pos << 1) + 2);
        }
        up(pos);

    }
    void up(int pos){
        sum[pos] = sum[(pos << 1) | 1] + sum[(pos << 1) + 2];
    }
    private void pd(int pos, int s, int t) {
        int l = (pos << 1 ) | 1,r = (pos << 1) + 2,mid = (s + t) >> 1;
        if(mul[pos] != 1){
            mul[l] *= mul[pos];
            mul[r] *= mul[pos];
            lazy[l] *= mul[pos];
            lazy[r] *= mul[pos];
            sum[l] *= mul[pos];
            sum[r] *= mul[pos];
            mul[pos] = 1;
        }
        if(lazy[pos] != 0){
            sum[l] += lazy[pos] * ( mid - l + 1);
            sum[r] += lazy[pos] * (t - mid);
            lazy[l] += lazy[pos];
            lazy[r] += lazy[pos];
            lazy[pos] = 0;
        }
    }
}
