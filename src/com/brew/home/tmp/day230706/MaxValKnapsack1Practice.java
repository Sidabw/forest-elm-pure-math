package com.brew.home.tmp.day230706;

import java.util.Arrays;

public class MaxValKnapsack1Practice {
    
    public static void main(String[] args) {
        
    }

    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        //求最大价值
        int[][] states = new int[n][w+1];
        for(int[] each: states) {
            Arrays.fill(each, -1);
        }
        //哨兵0
        states[0][0] = 0;
        if(weight[0]<=w) {
            states[0][weight[0]] = value[0];
        }

        //dp
        for(int i = 1; i < n; i++) {
            //不放
            for(int j = 0; j < w + 1; j++) {
                states[i][j] = states[i-1][j];
            }
            //放
            for(int j = 0; j < w - weight[i]; j++) {
                if(states[i-1][j]>=0) {
                    //这个重复是上面那个for造成的
                    int v1 = states[i-1][j] + value[i];
                    if(v1 > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v1;
                    }
                }
            }
        }

        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
        }
        return maxvalue;
    }
}
