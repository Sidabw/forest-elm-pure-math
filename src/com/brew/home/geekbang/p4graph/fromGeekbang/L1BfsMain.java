package com.brew.home.geekbang.p4graph.fromGeekbang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 〈一句话功能简述〉:
 * 〈BFS广度优先遍历,基于无向图〉
 *
 * @author feiyi
 * @create 2021/3/7
 * @since 1.0.0
 */
public class L1BfsMain extends GraphUndirected {

    public L1BfsMain(GraphUndirected graphUndirected) {
        super(graphUndirected.v, graphUndirected.adj);
    }

    public void bfs(int s, int t) {
        if (s == t) return;

        boolean[] visited = new boolean[v];
        visited[s]=true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        //using queue. poll from head, add into the last
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int q : adj[w]) {
                if (!visited[q]) {
                    // System.out.println(q);
                    prev[q] = w;
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    public void print(int[] prev, int s, int t) { // 递归打印s->t的路径
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }


    public static void main(String[] args) {
        GraphUndirected graphUndirected = GraphUndirected.buildOne();
        new L1BfsMain(graphUndirected).bfs(0, 7);
    }

}
