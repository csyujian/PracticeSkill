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
     * @param l 当前结点被表示的区间的和的左端点
     * @param r 当前结点被表示的区间的和的右端点
     * @param pos 当前结点坐标
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
     * @param l 查询区间的左端口
     * @param r 查询区间的右端口
     * @param start 当前结点表示的和的左端口
     * @param end 当前结点表示的和的右端口
     * @param pos 当前结点的位置
     * @return 返回和
     */
    int query(int l,int r,int start,int end,int pos){
        //如果查询区间在当前结点的包含的区间之内，那么就直接返回
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
        //如果被查询左区间的端点在中点的左边，意味着左子树需要被查询
        if(l <= m){
            sum += query(l,r,start,m,(pos << 1) | 1);
        }
        //如果被查询的右区间端点在中点的右边，意味着右子树需要被查询
        if( m < r){
            sum += query(l,r,m + 1,end,(pos << 1) + 2);
        }
        return sum;
    }

    /**
     *
     * @param l 被修改区间的左端点
     * @param r 被修改区间的右端点
     * @param c 被修改的值
     * @param s 当前结点表示和的左端点
     * @param t 当前结点表示和的右端点
     * @param pos 当前结点的位置
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
