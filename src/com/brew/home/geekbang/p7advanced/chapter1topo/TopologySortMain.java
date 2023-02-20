package com.brew.home.geekbang.p7advanced.chapter1topo;

public class TopologySortMain {

    public static void main(String[] args) {
        TopologySortKahn kahn = TopologySortKahn.buildOne();
        kahn.sort();
        System.out.println();

        TopologySortDfs dfs = TopologySortDfs.buildOne();
        dfs.sort();

        //需要注意的是两种实现在当前的测试数据下结果是不一样的。
        //因为实现不同。
        //一个入度表，一个逆临接表+dfs
        //如图，3和4是有前后的，但3和2其实是没有前后的。

    }
}
