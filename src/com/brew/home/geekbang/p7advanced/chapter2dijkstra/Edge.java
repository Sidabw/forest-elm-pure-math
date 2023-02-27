package com.brew.home.geekbang.p7advanced.chapter2dijkstra;

public class Edge {
    public int sid; // 边的起始顶点编号
    public int tid; // 边的终止顶点编号
    public int w; // 权重
    public Edge(int sid, int tid, int w) {
        this.sid = sid;
        this.tid = tid;
        this.w = w;
    }
}
