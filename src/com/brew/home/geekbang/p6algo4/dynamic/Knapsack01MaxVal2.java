package com.brew.home.geekbang.p6algo4.dynamic;

public class Knapsack01MaxVal2 {

    public static void main(String[] args) {
        //0-1 knapsack， 求最大价值， 一维数组解法
        int[] items = {2, 2, 4, 6, 3};
        int[] value = {3, 4, 8, 9, 6};
        //求出最大价值是18，对应重量应该是：2, 4，3吧
        System.out.println(knapsack4(items, value, items.length, 9));
    }

    public static int knapsack4(int[] weight, int[] value, int n, int w) {
        int[] maxVales = new int[w+1];
        if (weight[0] <=w ) {
            maxVales[weight[0]] = value[0];
        }
        //以上，哨兵0下标

        for (int i = 1; i<n; i++) {
            for (int j = w - weight[i] ; j>=0; j--) {
                //weight[i] 当前这个物品的重量
                //value[i] 当前这个物品的价值
                //j表示的累加的重量，maxVales[]表示的是累加的价值

                //表示把上层的状态转移下来，
                int v1 = maxVales[j] + value[i];
                int v2 = maxVales[j+weight[i]];
                if (v1 > v2) {
                    maxVales[j+weight[i]] = v1;
                }
            }
        }

        int max = -1;
        for (int each : maxVales) {
            if (each > max) max = each;
        }
        return max;
    }
}
