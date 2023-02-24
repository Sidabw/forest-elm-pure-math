package com.brew.home.geekbang.p7advanced.chapter2shortest;

import java.util.LinkedList;

public class GraphWeighted { // 有向有权图的邻接表表示
    private LinkedList<Edge> adj[]; // 邻接表

    private int v; // 顶点个数

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
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueueInGraph<Vertex> queue = new PriorityQueueInGraph<>(this.v);// 小顶堆
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
                    if (inqueue[nextVertex.id]) {
                        //纵使元素已经从队列里poll出来了，这是inqueue依然会为true，那更新个毛？
                        //猜测哈，这里的更新说的是删除，重新赋值，添加 三步
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

}