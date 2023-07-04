package com.brew.home.geekbang.p7advanced.chapter1topo;

import com.brew.home.geekbang.p4graph.fromGeekbang.GraphDirected;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TopologySortKahn extends GraphDirected {

    public TopologySortKahn(int v) {
        super(v);
    }

    public void sort() {
        System.out.print(this.getClass().getSimpleName()+ "  ");
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
        deque.add(origin);//add el to the tail of this dequeu. similar to queue.offer
        while (!deque.isEmpty()) {
            Integer el = deque.pollFirst(); //similar to queue.poll
            System.out.print("->" + el);
            for (int i = 0; i < adj[el].size(); i++) {
                int downstreamEl = adj[el].get(i);
                inDegrees[downstreamEl]--;

                if (inDegrees[downstreamEl] == 0) {
                    deque.add(downstreamEl);
                }
            }
        }
    }
    public static TopologySortKahn buildOne(){
        //因为addEdge已经重写了，所以当前是一个GraphDirected，则父类init方法生成的就是一个有向图
        TopologySortKahn graphDirected = new TopologySortKahn(8);
        graphDirected.init();
        return graphDirected;
    }
}
