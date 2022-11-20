package com.brew.home.geekbang.p4graph.fromGeekbang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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

    private void get3DegreeFriends(int w) {
        //这里w表示起点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(w);

        int[] prev = new int[v];
        Arrays.fill(prev, -1);

        boolean[] visited = new boolean[v];
        visited[w]=true;

        int[] res = new int[v];
        Arrays.fill(res, -1);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (int p : adj[cur]) {
                if (!visited[p]){
                    visited[p] = true;
                    prev[p] = cur;
                    getRecurDepth(prev, p);

                    if (recurDepth>=4) {
                        printRes(res);
                        return ;
                    } else {
                        res[p] = recurDepth;
                        recurDepth = 0;
                    }

                    queue.add(p);
                }
            }
        }
    }

    private void getRecurDepth(int[] prev, int a) {
        if (prev[a] != -1) {
            recurDepth++;
            getRecurDepth(prev, prev[a]);
        }
    }

    private void printRes(int[] res) {
        List<Integer> degree1 = new LinkedList<>();
        List<Integer> degree2 = new LinkedList<>();
        List<Integer> degree3 = new LinkedList<>();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == -1) {
                continue;
            } else if (res[i] == 1) {
                degree1.add(i);
            } else if (res[i] == 2) {
                degree2.add(i);
            } else if (res[i] == 3) {
                degree3.add(i);
            }
        }
        System.out.println(degree1);
        System.out.println(degree2);
        System.out.println(degree3);
    }

    public static void main(String[] args) {
        Degree3Test degree3Test = new Degree3Test(8);
        GraphCommon.init(degree3Test);
        degree3Test.get3DegreeFriends(0);
    }
}
