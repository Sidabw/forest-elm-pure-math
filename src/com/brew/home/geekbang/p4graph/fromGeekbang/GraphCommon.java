package com.brew.home.geekbang.p4graph.fromGeekbang;

public class GraphCommon {

    public static void init(Graph graph) {

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

    }
}
