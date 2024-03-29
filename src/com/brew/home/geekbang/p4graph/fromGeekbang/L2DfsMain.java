package com.brew.home.geekbang.p4graph.fromGeekbang;

import java.util.Arrays;

public class L2DfsMain extends GraphUndirected {

    /**
     * 相比BFS多了的一个变量，用于跳出递归
     */
    private boolean found;

    public L2DfsMain(GraphUndirected graphUndirected) {
        super(graphUndirected.v, graphUndirected.adj);
    }

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
        GraphUndirected graphUndirected = GraphUndirected.buildOne();
        new L2DfsMain(graphUndirected).dfs(0, 7);
    }
}
