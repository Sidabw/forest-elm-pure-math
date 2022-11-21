package com.brew.home.tmp.day220627;

import com.brew.home.geekbang.p4graph.fromGeekbang.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BfsTest extends Graph {
    public BfsTest(int v) {
        super(v);
    }

    public void bfs(int s, int t) {
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        boolean[] visited = new boolean[v];
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            Integer el = queue.poll();
            for (int each: adj[el]) {
                if (!visited[each]) {
                    prev[each] = el;
                    visited[each] = true;
                    queue.add(each);

                    if (each == t) {
                        print(prev, s, t);
                        return;
                    }
                }
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && s != t) {
            print(prev, s, prev[t]);
        }
        System.out.println(t);
    }

    public static void main(String[] args) {
        BfsTest graph = new BfsTest(8);
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
