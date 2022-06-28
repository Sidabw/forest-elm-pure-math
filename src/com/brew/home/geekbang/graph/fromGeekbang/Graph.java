package com.brew.home.geekbang.graph.fromGeekbang;

import java.util.LinkedList;
import java.util.Queue;

public class Graph { // 无向图
    protected int v; // 顶点的个数
    protected LinkedList<Integer> adj[]; // 邻接表

    public Graph(int v) {
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


}