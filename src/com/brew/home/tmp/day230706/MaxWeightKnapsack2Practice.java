package com.brew.home.tmp.day230706;


public class MaxWeightKnapsack2Practice {
    
    public static void main(String[] args) {
        //一维数组求背包最大重量
        //尴尬... 几乎就是把'不放'的逻辑删掉就完事了
        System.out.println(new MaxWeightKnapsack2Practice().knapsack2(new int[]{2, 2, 4, 6, 3}, 9));

    }

    public int knapsack2(int[] weight, int ceiling) {
        int n = weight.length;
        boolean[] states = new boolean[ceiling + 1];
        states[0] = true;
        if(weight[0] <= ceiling) {
            states[weight[0]] = true;
        }

        for(int i = 1; i < n; i++) {
            for(int j = (ceiling - weight[i]); j >= 0; j--) {
                if(states[j]) {
                    states[j + weight[i]] = true;
                }
            }
        }

        for(int i = states.length - 1; i >= 0; i--) {
            if(states[i]) {
                return i;
            }
        }

        return 0;
    }



}
