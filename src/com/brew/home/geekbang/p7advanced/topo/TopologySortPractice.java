package com.brew.home.geekbang.p7advanced.topo;

import com.brew.home.geekbang.p4graph.fromGeekbang.GraphDirected;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TopologySortPractice extends GraphDirected {

    public TopologySortPractice(int v, LinkedList<Integer>[] adj) {
        super(v, adj);
    }

    public TopologySortPractice(int v) {
        super(v);
    }

    public void topologySortByKahn() {
        //1. 创建入度表
        //2. 找到0入度的，写入Deque
        //3. 操作入度表和Deque完成拓扑排序

        Integer[] inDegrees = new Integer[v];
        Arrays.fill(inDegrees, 0);
        for (int i = 0; i<adj.length; i++) {
            for (int j = 0; j< adj[i].size(); j++) {
                Integer k = adj[i].get(j);
                inDegrees[k]++;
            }
        }

        int origin = -1;
        for (int i = 0; i<inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                origin = i;
                break;
            }
        }
        Deque<Integer> deque = new LinkedList<>();
        deque.add(origin);
        while (!deque.isEmpty()) {
            Integer el = deque.pollFirst();
            System.out.println("->" + el);
            for (int i = 0; i < adj[el].size(); i++) {
                int downstreamEl = adj[el].get(i);
                inDegrees[downstreamEl]--;

                if (inDegrees[downstreamEl] == 0) {
                    deque.add(downstreamEl);
                }
            }
        }
    }
    public static TopologySortPractice buildOne(){
        //因为addEdge已经重写了，所以当前是一个GraphDirected，则父类init方法生成的就是一个有向图
        TopologySortPractice graphDirected = new TopologySortPractice(8);
        graphDirected.init();
        return graphDirected;
    }

    public static void main(String[] args) {
        TopologySortPractice directedGraph = TopologySortPractice.buildOne();
        directedGraph.topologySortByKahn();
    }


}
