package com.brew.home.tmp.day230704;

import java.util.LinkedList;
import java.util.Queue;

import com.brew.home.geekbang.p4graph.fromGeekbang.GraphDirected;
import com.brew.home.geekbang.p7advanced.chapter1topo.TopologySortKahn;

public class TopologyKahnPractice extends GraphDirected {
    
    public TopologyKahnPractice(int v) {
        super(v);
    }

    public static void main(String[] args) {
        TopologyKahnPractice kahn = TopologyKahnPractice.buildOne();
        kahn.sort();
        System.out.println();
    }

    public void sort() {
        //1. 构建入度表
        //2. 找到入度0节点
        //3. 遍历

        int[] inDegree = new int[v];
        for(int i = 0; i < adj.length; i++) {
            for (int cur : adj[i]) {
                inDegree[cur]++;
            }
        }

        int start = -1;
        for(int i = 0; i < inDegree.length;i++) {
            if(inDegree[i] == 0) {
                start = i;
                break;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(" -> " + cur);

            for(int next: adj[cur]) {
                inDegree[next]--;

                if(inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }

    public static TopologyKahnPractice buildOne(){
        //因为addEdge已经重写了，所以当前是一个GraphDirected，则父类init方法生成的就是一个有向图
        TopologyKahnPractice graphDirected = new TopologyKahnPractice(8);
        graphDirected.init();
        return graphDirected;
    }
}
