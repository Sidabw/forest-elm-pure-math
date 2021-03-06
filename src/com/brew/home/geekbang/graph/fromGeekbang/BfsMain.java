package com.brew.home.geekbang.graph.fromGeekbang;

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
public class BfsMain extends Graph{

    public BfsMain(int v) {
        super(v);
    }

    public void bfs(int s, int t) {
        if (s == t) return;

        boolean[] visited = new boolean[v];
        visited[s]=true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int[] prev = new int[v];
        Arrays.fill(prev, -1);

        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int q : adj[w]) {
                if (!visited[q]) {
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
        BfsMain graph = new BfsMain(8);
        //一度
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        //二度
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        //三度
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        //四度
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);


        graph.bfs(0, 7);
    }

}
