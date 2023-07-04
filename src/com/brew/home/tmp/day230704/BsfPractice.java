package com.brew.home.tmp.day230704;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.brew.home.geekbang.p4graph.fromGeekbang.GraphUndirected;

public class BsfPractice extends GraphUndirected {
    
    public BsfPractice(GraphUndirected graphUndirected) {
        super(graphUndirected.v, graphUndirected.adj);
    }

    public void bfs(int s, int t) {

        boolean[] visited = new boolean[v];

        int[] prev = new int[v];
        Arrays.fill(prev, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int w : adj[cur]) {
                if(!visited[w]) {
                    prev[w] = cur;
                    if(w == t) {
                        recursivePrint(prev, s, t);
                        return;
                    }

                    visited[w] = true;
                    queue.offer(w);
                }
            }
        }
    }

    private void recursivePrint(int[] prev, int s, int t) {
        if(prev[s] != -1 && s != t) {
            recursivePrint(prev, s, prev[t]);
        }
        System.out.println(t + "");
    }

    public static void main(String[] args) {
        GraphUndirected graphUndirected = GraphUndirected.buildOne();
        new BsfPractice(graphUndirected).bfs(0, 7);
    }
}
