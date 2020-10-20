package algorithms;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/14 14:13
 */

import java.util.PriorityQueue;

/***
 Prim�㷨˼��
 �㷨����
 1��ѡ��Դ�㣺����ѡ��һ��������ΪԴ�㣬���õ��Ӧ�ı�Ȩ��Ϣ�����С�����У���֤ÿ��ȡ���Ķ���Ȩֵ��С�ıߡ�
 2������С���ѣ�ÿ�ζ�����ȡ��Ȩֵ��С�ıߣ�ע����Ҫ�жϵ��Ƿ���ѡ�������Ҫ�б���б���
 ���ñ߼�������Ȼ�󽫸öԶ˵��Ӧ�ı�Ȩ��Ϣ�����С�����С�
 ***/
public class Prim {
    PriorityQueue<Vertex> heap;
    public int minCostConnectPoints(int[][] points) {
        heap=new PriorityQueue<Vertex>((a,b)->a.len-b.len);
        int plen=points.length;
        //��Ƿ��ʹ��Ķ���
        boolean[] marked=new boolean[plen];
        //ѡ��Դ��
        addVertex(points,0);
        //���Դ��
        marked[0]=true;
        //��С�������ıߵĸ���Ϊ ������-1
        int end=plen-1;
        int ans=0;
        while(!heap.isEmpty())
        {
            Vertex vert=heap.poll();
            if(!marked[vert.u])
            {
                ans+=vert.len;
                marked[vert.u]=true;
                addVertex(points,vert.u);
                --end;
                if(end==0)
                {
                    break;
                }
            }
        }
        return ans;
    }
    //�����Ӧ�ı�Ȩ��Ϣ�����С������
    private void addVertex(int[][] points,int x)
    {
        int plen=points.length;
        int i=x==0?1:0;
        while(i<plen)
        {
            int len=Math.abs(points[i][0]-points[x][0])
                    +Math.abs(points[i][1]-points[x][1]);
            heap.offer(new Vertex(len,i));
            if(i==x-1)
            {
                i=x+1;
            }else
            {
                ++i;
            }
        }
    }
}
/***
 ����
 ***/
class Vertex
{
    int len;
    int u;
    public Vertex(int len,int u)
    {
        this.len=len;
        this.u=u;
    }
}
