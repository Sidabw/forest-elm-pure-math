package com.brew.home.geekbang.graph.fromGeekbang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DfsMain extends Graph{

    public DfsMain(int v) {
        super(v);
    }

    /**
     * 相比BFS多了的一个变量，用于跳出递归
     */
    private boolean found;

    public void dfs(int w, int t) {
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        Arrays.fill(prev, -1);

        recurDfs(visited, prev, w, t);

        print(prev, w, t);
    }

    private void recurDfs(boolean[] visited, int[] prev, int w, int t) {
        if (found) {
            return;
        }
        if (w == t) {
            found = true;
            return;
        }

        for (Integer each: adj[w]) {
            prev[each] = w;
            if (!visited[each]) {
                visited[each] = true;
                recurDfs(visited, prev, each, t);
            }
        }

    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        DfsMain graph = new DfsMain(8);
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


        graph.dfs(0, 7);
    }
}
