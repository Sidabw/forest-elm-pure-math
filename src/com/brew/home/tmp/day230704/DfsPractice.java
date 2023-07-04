package com.brew.home.tmp.day230704;

import java.util.Arrays;

import com.brew.home.geekbang.p4graph.fromGeekbang.GraphUndirected;

public class DfsPractice extends GraphUndirected {
    
    public static void main(String[] args) {
        
    }

    private boolean found;

    public DfsPractice(GraphUndirected graphUndirected) {
        super(graphUndirected.v, graphUndirected.adj);
    }

    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];

        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        
        recursiveDfs(prev, visited, s, t);

        print(prev, s, t);
    }


    private void recursiveDfs(int[] prev, boolean[] visited, int w, int t) {
        if(found) {
            return;
        }
        if(w == t) {
            found = true;
            return;
        }

        for(int cur: adj[w]) {
            if(!visited[cur]) {
                visited[cur] = true;
                prev[cur] = w;

                recursiveDfs(prev, visited, cur, t);
            }
        }
    }


    private void print(int[] prev, int s, int t) {

        if(prev[t] != -1 && s != t) {
            print(prev, s, prev[t]);
        }

        System.out.println(t+ "     ");

    }

}
