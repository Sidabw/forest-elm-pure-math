package com.brew.home.geekbang.p6algo4.dynamic;

public class Knapsack01MaxWeight1 {

    public static void main(String[] args) {
        //【dp】提供一组重量不同的物品，提供背包最大承受重量，求该组物品在不超重的前提下的最大重量，
        // 二维数组解法，完整注释版参考Evernote
        System.out.println(new Knapsack01MaxWeight1().knapsack(new int[]{2, 2, 4, 6, 3}, 9));
    }

    public int knapsack(int[] weight, int ceiling) {
        int n = weight.length;
        boolean[][] states = new boolean[n][ceiling + 1];

        states[0][0] = true;
        if(weight[0] <= ceiling) {
            states[0][weight[0]] = true;
        }

        for(int i = 1; i < n; i++) {

            //不放
            for(int j = 0; j < states[i].length; j++) {
                if(states[i-1][j]) {
                    states[i][j] = true;
                }
            }

            //放
            for(int j = 0; j <= ceiling - weight[i]; j++) {
                if(states[i-1][j]) {
                    states[i][j+weight[i]] = true;
                }
            }
        }

        boolean[] lastState = states[states.length - 1];
        for(int i = lastState.length - 1; i >=0; i--) {
            if(lastState[i]) {
                return i;
            }
        }
        return 0;
    }
}
