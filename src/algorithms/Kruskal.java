package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/14 13:44
 */
public class Kruskal {
    //���鼯find����
    int[] f ;

    public int find(int x) {//find�������ж��Ƿ�ͬһ��root�ڵ�
        return f[x] == x ? x : find(f[x]);
    }

    public int minCostConnectPoints(int[][] points) {
        int h = points.length;
        f=new int[h+1];
        //��ʼ��find���飬�ó�ʼÿ���ڵ㶼�Գ�һ�����ϣ����಻��ͨ
        for (int i = 0; i < f.length; i++) {
            f[i]=i;
        }
        List<Edge> edges = new ArrayList<>();
        //��߳�
        for (int i = 0; i < h; i++) {
            for (int j = i + 1; j < h; j++) {
                int len = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                if (len != 0) {
                    edges.add(new Edge(i, j, len));
                }
            }
        }
        int ans =0;
        Collections.sort(edges);

        for(Edge e:edges){
            int x=e.getX();
            int y =e.getY();
            int len = e.getLen();
            //��������ڵ���ͬһ�������У�˵��֮ǰ�Ѿ�������·��������
            if(find(x)==find(y)) {
                continue;
            }
            ans+=len;
            //�������Ϻϲ�
            f[find(x)] = find(y);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{1,2},{3,18},{18,-1}};
        System.out.println(new Kruskal().minCostConnectPoints(points));
    }
}

class Edge implements Comparable<Edge> {
    private int x;
    private int y;
    private int len;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Edge(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
    //���ñȽ���ʵ�ְ�len����
    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.len, o.len);
    }
}
