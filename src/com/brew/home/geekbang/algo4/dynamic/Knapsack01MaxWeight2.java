package com.brew.home.geekbang.algo4.dynamic;

public class Knapsack01MaxWeight2 {

    public static void main(String[] args) {
        //【dp】一维数组解法
        int[] items = {2, 2, 4, 6, 3};
        System.out.println(knapsack2(items, items.length, 9));
    }

    public static int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w+1]; // 默认值false
        states[0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= w) {
          states[items[0]] = true;
        }
        //👆，还是“哨兵”化0号索引物品

        for (int i = 1; i < n; ++i) { // 动态规划
          for (int j = w-items[i]; j >= 0; --j) {
           //把第i个物品放入背包，不放的逻辑干掉了。
           if (states[j]==true) states[j+items[i]] = true;
          }
        }

        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i] == true) return i;
        }
        return 0;
    }

}
