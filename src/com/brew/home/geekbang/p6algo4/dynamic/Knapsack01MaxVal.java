package com.brew.home.geekbang.p6algo4.dynamic;

public class Knapsack01MaxVal {

    public static void main(String[] args) {
        //0-1 knapsack， 求最大价值， 二维数组解法
        int[] items = {2, 2, 4, 6, 3};
        int[] value = {3, 4, 8, 9, 6};
        //求出最大价值是18，对应重量应该是：2, 4，3吧
        System.out.println(knapsack3(items, value, items.length, 9));
    }

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w+1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        //以上，“哨兵”0号下标物品

        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) { // 选择第i个物品
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    //对于重复的，选价值大的。在i着一层，j+weight[i]是会出现重复的。
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
        }
        return maxvalue;
    }
}
