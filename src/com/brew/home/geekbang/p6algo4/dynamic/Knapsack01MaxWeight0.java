package com.brew.home.geekbang.p6algo4.dynamic;

public class Knapsack01MaxWeight0 {

    public static void main(String[] args) {
        //0-1 knapsack， 提供一组重量不同的物品，提供背包最大承受重量，求该组物品在不超重的前提下的最大重量，
        //回溯解法
        Knapsack01MaxWeight0 knapsack01MaxWeight0 = new Knapsack01MaxWeight0();
        knapsack01MaxWeight0.f(0,0);
        System.out.println(knapsack01MaxWeight0.getMaxW());
    }

    // 回溯算法实现。注意：输入的变量都定义成了成员变量。
    private int maxW = Integer.MIN_VALUE; // 结果放到maxW中
    private int[] weight = {2, 2, 4, 6, 3};// 物品重量
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    public void f(int i, int cw) { // 调用f(0, 0)
        if (cw == w || i == n) { // cw==w表示装满了，i==n表示物品都考察完了
            if (cw > maxW) maxW = cw;
            return;
        }
        f(i+1, cw); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i+1,cw + weight[i]); // 选择装第i个物品
        }
    }

    //多一层调用栈但是更简洁的写法
    public void f2(int i, int cw) {
        if(cw >= w || i == n) {
            if(cw > maxW) maxW = cw;
        }
        f2(i+1, cw);//不装
        f2(i+1, cw+weight[i]);//装
    }

    public int getMaxW() {
        return maxW;
    }
}
