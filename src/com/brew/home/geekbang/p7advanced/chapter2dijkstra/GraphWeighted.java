package com.brew.home.geekbang.p7advanced.chapter2dijkstra;

import java.util.LinkedList;

public class GraphWeighted { // 有向有权图的邻接表表示
    private final LinkedList<Edge>[] adj; // 邻接表

    private final int v; // 顶点个数

    public GraphWeighted(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) { // 添加一条边
        //在有向图上添加一条边。临接表adj[]的下标依然是“节点”
        this.adj[s].add(new Edge(s, t, w));
    }

    public void dijkstra(int s, int t) { // 从顶点s到顶点t的最短路径
        int[] predecessor = new int[this.v]; // 用来还原最短路径
        Vertex[] vertexes = new Vertex[this.v];
        for (int i = 0; i < this.v; ++i) {
            //因为优先级队列的i会+1，所以暂且假定图是从1开始，没有0
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueueInGraph queue = new PriorityQueueInGraph(this.v);// 小顶堆
        boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex= queue.poll(); // 取堆顶元素并删除
            //minVertex就认为是当前节点
            if (minVertex.id == t) break; // 最短路径产生了
            //遍历当前节点的所有子节点
            for (int i = 0; i < adj[minVertex.id].size(); ++i) {
                Edge e = adj[minVertex.id].get(i); // 取出一条minVetex相连的边
                //根据边，拿到下一个节点.默认构造的节点的dist是无限大
                Vertex nextVertex = vertexes[e.tid]; // minVertex-->nextVertex
                //第一次进入的minVertex.dist=0
                if (minVertex.dist + e.w < nextVertex.dist) { // 更新next的dist
                    nextVertex.dist = minVertex.dist + e.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    //因为用了小顶堆优先级队列，所以不存在一个元素poll出来，但是后面又拿到了这个元素的情况。
                    //详细的说，'nextVertex'这一层，都来自上一个节点'minVertex'
                    //'nextVertex'这一层往优先级队列里放的时候，dist小的会排再前面
                    //那你说有没有可能小的poll出来了，等到后面竟然发现了更小的？当然不可能
                    //而这里inqueue的判断然后update，处理的是放到队列里但是还没来得及消费的节点。
                    if (inqueue[nextVertex.id]) {
                        queue.update(nextVertex); // 更新队列中的dist值
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }
        // 输出最短路径
        System.out.print(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.print("->" + t);
    }

    public static void main(String[] args) {
        GraphWeighted g = new GraphWeighted(7);
        g.addEdge(1,2,10);
        g.addEdge(1,5,15);
        g.addEdge(2,3,15);
        g.addEdge(2,4,2);
        g.addEdge(4,3,1);
        g.addEdge(4,6,12);
        g.addEdge(3,6,5);
        g.addEdge(5,6,10);

        g.dijkstra(1,6);
    }

}