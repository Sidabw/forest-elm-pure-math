package com.brew.home.geekbang.p7advanced.chapter2shortest;


import java.util.LinkedList;

public class Tmp1 {


}

// 因为Java提供的优先级队列，没有暴露更新数据的接口，所以我们需要重新实现一个
class PriorityQueue extends java.util.PriorityQueue<Vertex> { // 根据vertex.dist构建小顶堆
    private Vertex[] nodes;
    private int count;

    public PriorityQueue(int v) {
        this.nodes = new Vertex[v + 1];
        this.count = v;
    }

    @Override
    public Vertex poll() {
        return super.poll();
    }

    @Override
    public boolean add(Vertex vertex) {
        return super.add(vertex);
    }

    // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度O(logn)。
    public void update(Vertex vertex) {
        // TODO: 留给读者实现...
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

}
class Edge {
    public int sid; // 边的起始顶点编号
    public int tid; // 边的终止顶点编号
    public int w; // 权重
    public Edge(int sid, int tid, int w) {
        this.sid = sid;
        this.tid = tid;
        this.w = w;
    }
}
// 下面这个类是为了dijkstra实现用的
class Vertex {
    public int id; // 顶点编号ID
    public int dist; // 从起始顶点到这个顶点的距离
    public Vertex(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }
}
class GraphWeighted { // 有向有权图的邻接表表示
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
        PriorityQueue queue = new PriorityQueue(this.v);// 小顶堆
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



