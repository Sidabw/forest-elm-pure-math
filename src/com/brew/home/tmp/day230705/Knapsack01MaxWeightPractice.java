package com.brew.home.tmp.day230705;

public class Knapsack01MaxWeightPractice {
    
    public static void main(String[] args) {
        
    }

    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = {2, 2, 4, 6, 3};// 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    public void f(int i, int cw) {
        if(cw == w || i ==n) {
            if(cw>maxW) {
                maxW = cw;
            }
            return;
        }
        //不装
        f(i+1, cw);
        //装
        int cwTmp = weight[i+1] + cw;
        if(cwTmp <= w) {
            f(i+1, cwTmp);
        }
    }

}
