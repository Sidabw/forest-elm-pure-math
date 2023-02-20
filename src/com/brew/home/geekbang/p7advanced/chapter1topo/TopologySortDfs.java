package com.brew.home.geekbang.p7advanced.topo;

import com.brew.home.geekbang.p4graph.fromGeekbang.GraphDirected;

import java.util.Arrays;
import java.util.LinkedList;

public class TopologySortDfs extends GraphDirected {

    public TopologySortDfs(int v) {
        super(v);
    }


    private boolean[] visited;

    private LinkedList<Integer>[] reversedAdj;

    public void sort() {
        System.out.print(this.getClass().getSimpleName());
        //先构建逆临接表
        //dfs深度优先递归找到"入度为0"的节点并打印
        reversedAdj = new LinkedList[v];
        for (int i = 0 ; i < v; i++) {
            reversedAdj[i] = new LinkedList<>();
        }

        //⚠️ATTENTION⚠️：Arrays.fill后面给的obj，不是lambda，所以如下这样写... 数组[]每个元素都会指到一个LinkedList上
//        Arrays.fill(reversedAdj, new LinkedList());

        for (int i = 0; i<v; i++) {
            for (int j = 0; j<adj[i].size(); j++) {
                Integer n1 = adj[i].get(j); //i -> n1
                reversedAdj[n1].add(i);     //n1 -> i
            }
        }

        visited = new boolean[v];

        for (int i = 0; i<v; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(i);
        }
    }

    private void dfs(int node){
        for (int i = 0; i<reversedAdj[node].size();i++) {
            int preNode = reversedAdj[node].get(i);
            if (visited[preNode]) {
                continue;
            }
            visited[preNode] = true;
            dfs(preNode);
        }
        System.out.print("->" + node);
    }

    public static TopologySortDfs buildOne(){
        //因为addEdge已经重写了，所以当前是一个GraphDirected，则父类init方法生成的就是一个有向图
        TopologySortDfs graphDirected = new TopologySortDfs(8);
        graphDirected.init();
        return graphDirected;
    }
}
