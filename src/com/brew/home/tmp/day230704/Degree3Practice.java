package com.brew.home.tmp.day230704;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.brew.home.geekbang.p4graph.fromGeekbang.GraphUndirected;

public class Degree3Practice extends GraphUndirected{
    
    public Degree3Practice(GraphUndirected graphUndirected) {
        super(graphUndirected.v, graphUndirected.adj);
    }

    private int recursiveDepth;


    public static void main(String[] args) {
        GraphUndirected graphUndirected = GraphUndirected.buildOne();
        new Degree3Practice(graphUndirected).getDegree3(0);
    }

    public void getDegree3(int start) {
        boolean[] visited = new boolean[v];
        visited[start] = true;

        int[] prev = new int[v];
        Arrays.fill(prev, -1);

        int[] res = new int[v];
        Arrays.fill(res, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()) {

            int cur = queue.poll();
            for(int next : adj[cur]) {
                if(!visited[next]) {
                    visited[next] = true;
                    prev[next] = cur;

                    calRecursiveDepth(prev, next, start);
                    if(recursiveDepth >= 4) {
                        print(res);
                        return;
                    } else {
                        res[next] = recursiveDepth;
                        recursiveDepth = 0;
                        queue.offer(next);
                    }
                }
            }
        }

    }

    private void calRecursiveDepth(int[] prev, int cur, int start) {
        if(prev[cur] != -1 && cur != start) {
            recursiveDepth++;
            calRecursiveDepth(prev, prev[cur], start);
        }
    }

    private void print(int[] res) {
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        List<Integer> l3 = new LinkedList<>();

        for(int i =0; i < res.length; i++) {
            int val = res[i];
            if (val == -1) {
                continue;
            } else if (val == 1) {
                l1.add(i);
            } else if (val == 2) {
                l2.add(i);
            } else if (val == 3) {
                l3.add(i);
            }
        }

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
    }



}
