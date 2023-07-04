package com.brew.home.geekbang.p4graph.fromGeekbang;

import java.util.LinkedList;

public class GraphUndirected { // 无向图

    public int v; // 顶点的个数
    public LinkedList<Integer>[] adj; // 邻接表

    protected GraphUndirected(int v, LinkedList<Integer>[] adj) {
        this.v = v;
        this.adj = adj;
    }

    public GraphUndirected(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        //adj数组的角标即是该元素
        //每个LinkedList的角标就是角标，这里注意。
        adj[s].add(t);
        adj[t].add(s);
    }
    
    
    public static GraphUndirected buildOne(){
        GraphUndirected graphUndirected = new GraphUndirected(8);
        graphUndirected.init();
        return graphUndirected;
    }

    protected void init() {

        /*

            0────1────2
            │    │    │
            │    │    │
            3────4────5
                 │    │
                 │    │
                 6────7       

         */
        //一度
        addEdge(0, 3);
        addEdge(0, 1);
        //二度
        addEdge(1, 4);
        addEdge(1, 2);
        addEdge(3, 4);
        //三度
        addEdge(2, 5);
        addEdge(4, 5);
        addEdge(4, 6);
        //四度
        addEdge(5, 7);
        addEdge(6, 7);

    }


}