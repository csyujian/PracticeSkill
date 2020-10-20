package algorithms;

/**
 * @author yvzhu
 * @version 1.0
 * @date 2020/9/14 14:13
 */

import java.util.PriorityQueue;

/***
 Prim算法思想
 算法步骤
 1、选择源点：任意选择一个顶点作为源点，将该点对应的边权信息表加入小顶堆中，保证每次取出的都是权值最小的边。
 2、遍历小顶堆：每次都堆中取出权值最小的边（注：需要判断点是否已选择，因此需要有标记列表），
 将该边加入结果。然后将该对端点对应的边权信息表加入小顶堆中。
 ***/
public class Prim {
    PriorityQueue<Vertex> heap;
    public int minCostConnectPoints(int[][] points) {
        heap=new PriorityQueue<Vertex>((a,b)->a.len-b.len);
        int plen=points.length;
        //标记访问过的顶点
        boolean[] marked=new boolean[plen];
        //选择源点
        addVertex(points,0);
        //标记源点
        marked[0]=true;
        //最小生成树的边的个数为 顶点数-1
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
    //将点对应的边权信息表加入小顶堆中
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
 顶点
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
