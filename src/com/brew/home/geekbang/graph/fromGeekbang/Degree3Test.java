package com.brew.home.geekbang.graph.fromGeekbang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 找到3度好友关系
 */
public class Degree3Test extends Graph{


    public Degree3Test(int v) {
        super(v);
    }

    /**
     * 通过记录递归深度
     */
    private int recurDepth;

    private Queue<Integer> get3DegreeFriends(int w) {
        //这里w表示起点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(w);

        int[] prev = new int[v];
        Arrays.fill(prev, -1);

        boolean[] visited = new boolean[v];

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int p : adj[cur]) {
                if (!visited[p]){

                }
            }
        }
        return null;
    }
}
