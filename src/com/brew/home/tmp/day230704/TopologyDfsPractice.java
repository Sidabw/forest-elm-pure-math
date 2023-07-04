package com.brew.home.tmp.day230704;

import java.util.LinkedList;

import com.brew.home.geekbang.p4graph.fromGeekbang.GraphDirected;
import com.brew.home.geekbang.p7advanced.chapter1topo.TopologySortDfs;

public class TopologyDfsPractice extends GraphDirected {
    
    public TopologyDfsPractice(int v) {
        super(v);
    }

    private boolean[] visited;

    private LinkedList<Integer>[] reversedAdj;

    public void sort() {
        //1. 构建逆邻接表
        //2. 递归遍历该逆邻接表
        visited = new boolean[v];
        reversedAdj = new LinkedList[v];
        for(int i = 0; i<v; i++) {
            reversedAdj[i] = new LinkedList<>();
        }
        for(int i = 0; i<v;i++){
            for(int cur : adj[i]) {
                reversedAdj[cur].add(i);
            }
        }

        for(int i = 0; i<v;i++) {
            if(visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(i);
        }
    }

    private void dfs(int node) {
        for(int i = 0 ; i < reversedAdj[node].size() ; i++) {
            int preNode = reversedAdj[node].get(i);
            if(visited[preNode]) {
                continue;
            }

            visited[preNode] = true;
            dfs(preNode);
        }

        System.out.print(" -> " + node);
    }

    public static TopologyDfsPractice buildOne() {
        TopologyDfsPractice graphDirected = new TopologyDfsPractice(8);
        graphDirected.init();
        return graphDirected;
    }

    public static void main(String[] args) {
        TopologyDfsPractice dfs = TopologyDfsPractice.buildOne();
        dfs.sort();
    }
}
