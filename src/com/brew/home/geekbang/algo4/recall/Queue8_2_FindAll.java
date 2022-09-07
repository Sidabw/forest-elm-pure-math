package com.brew.home.geekbang.algo4.recall;

import static com.brew.home.geekbang.algo4.recall.Queue8_1_FindFirst.*;

/**
 * 八皇后，找到所有排列。
 * <p> 1. 回溯本身就是暴力枚举，但是重要在于"在匹配失败的情况下提前结束（剪枝），回溯到上一层继续"。
 * <p> 2. 找到所有排列。到第八层找到正确排列后，只输出结果，不结束。回溯到上一层/上上层.. 继续找。这么倒着继续找的原因，就是枚举所有情况，然后找到所有正确排列
 *
 */
public class Queue8_2_FindAll {

    static int num=0;
    public static void main(String[] args) {
        settleQueen(0);
    }

    static void settleQueen(int y) {
        //行数超过8，说明已经找出答案
        if(y == MAX_NUM){
            printChessBoard();
            System.out.println("<><><><><><><><><><><>got u <><><><><><><><><><><>, " + ++num);
            return;
        }
        //遍历《当前行》，逐一格子验证
        for(int i=0;i<MAX_NUM;i++) {
            //为当前行清零，以免在回溯的时候出现脏数据
            for(int x=0; x<MAX_NUM; x++) {
                chessBoard[x][y] = 0;
            }
            //检查是否符合规则，如果符合，更改元素值并进一步递归
            if(check(i,y)){
                chessBoard[i][y] = 1;
                /*
                 1. settleQueen(y+1) 递归进入下一层
                 2. 下层找到解法后，继续循环
                 */
                settleQueen(y+1);
            }
        }
    }
}
