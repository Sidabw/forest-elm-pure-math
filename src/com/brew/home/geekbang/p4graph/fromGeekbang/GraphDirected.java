package com.brew.home.geekbang.p4graph.fromGeekbang;

import java.util.LinkedList;

/**
 * 有向图
 */
public class GraphDirected extends GraphUndirected{

    protected GraphDirected(int v, LinkedList<Integer>[] adj) {
        super(v, adj);
    }

    public GraphDirected(int v) {
        super(v);
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        //adj数组的角标即是该元素
        //每个LinkedList的角标就是角标，这里注意。
        adj[s].add(t);
    }

    public static GraphUndirected buildOne(){
        GraphDirected graphUndirected = new GraphDirected(8);
        graphUndirected.init();
        return graphUndirected;
    }

}
