package com.brew.home.geekbang.p6algo4.recall;

/**
 * 八皇后问题，程序员小灰
 * <p> 1. 回溯本身就是暴力枚举，但是重要在于"在匹配失败的情况下提前结束（剪枝），回溯到上一层继续"
 * https://mp.weixin.qq.com/s/puk7IAZkSe6FCkZnt0jnSA
 */
public class Queue8_1_FindFirst {

    public static void main(String[] args) {
        Queue8_1_FindFirst queue8 = new Queue8_1_FindFirst();
        queue8.settleQueen(0);
        queue8.printChessBoard();
    }

    static final int MAX_NUM = 8;

    static int[][] chessBoard = new int[MAX_NUM][MAX_NUM];

    //检查落点是否符合规则
    static boolean check(int x, int y) {
        for (int i = 0; i < y; i++) {
            //检查纵向
            if (chessBoard[x][i] == 1) {
                return false;
            }
            //检查左侧斜向
            if (x - 1 - i >= 0 && chessBoard[x - 1 - i][y - 1 - i] == 1) {
                return false;
            }
            //检查右侧斜向
            if (x+1+i < MAX_NUM && chessBoard[x+1+i][y-1-i] == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean settleQueen(int y) {
        //行数超过8，说明已经找出答案
        if(y == MAX_NUM){
            return true;
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
                 2. 递归如果返回true，说明下层已找到解法，无需继续循环
                 */
                if(settleQueen(y+1)) {
                    return true;
                }
            }
        }
        //如果当前行遍历完了，则return false，回溯到前一行。前一行i+1，到下一个格子
        return false;
    }

    //打印棋盘当前值
    static void printChessBoard(){
        for(int j=0; j<MAX_NUM; j++) {
            for (int i = 0; i < MAX_NUM; i++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }
    }

}

