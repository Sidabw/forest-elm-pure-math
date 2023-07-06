package com.brew.home.geekbang.p6algo4.dynamic;

public class Knapsack01Practice1 {
    
    public static void main(String[] args) {
        //双十一薅羊毛
        int[] intems = new int[]{20,35,43,11,93,23,45,77,89,2,54,3,21,63,32};
        Knapsack01Practice1.double11advance(intems, intems.length, 200);
    }
    //items 每个商品的价格
    //n items.len
    //w 最高不超过的价格
    //跟0-1背包求最大重量几乎一样，只不过限定条件从重量变成了价格。需要额外打印商品列表。
    public static void double11advance(int[] items, int n, int w) {
        int realW = 3*w + 1; //老板说总价离200最近的，薅羊毛。实际算法上限按3*w+1算，最后去找[w, 3*w+1)
        boolean[][] states = new boolean[n][realW];
        //哨兵
        states[0][0] = true;
        if(items[0] < realW) {
            states[0][items[0]] = true;
        }

        //dp
        for(int i = 1; i < n; i++) {
            //不放
            for(int j = 0; j < realW; j++) {
                if(states[i-1][j]) {
                    states[i][j] = true;
                }
            }
            //放
            for(int j = 0; j < realW - items[i]; j++) {
                if(states[i-1][j]) {
                    states[i][j+items[i]] = true;
                }
            }
        }
        //挑选一个最接近w的
        //index是总价，其范围应在[w, realW)中
        int index = -1;
        for(int j = w; j < realW; j++) {
            if(states[n-1][j]) {
                index = j;
                break;
            }
        }
        if(index == realW) {
            System.out.println("没有挑选到符合条件的商品");
            return;
        }
        //反着往前推，当前状态是由哪些状态转移过来的，找到多个随便挑一个即可
        //正上方转移下来的是没买，左上方转一下来的是买
        for(int i = n - 1; i > 0; i--) {
            if(index - items[i] >=0 && states[i-1][index-items[i]]) {
                System.out.println("购买商品下标：" + i + " 购买商品价格：" + items[i] + " 已累计价格：" + index);
                index -=items[i];
            } else {
                //不买的就不打印了
            }
        }
        //0下标商品买没买
        if(index != 0) {
            System.out.println("购买商品下标：" + 0 + " 购买商品价格：" + items[0] + " 已累计价格：" + index);
        }
    }
}
