package com.brew.home.geekbang.p6algo4.recall;

/**
 * 八皇后问题，程序员小灰
 * <p> 1. 回溯本身就是暴力枚举，但是重要在于"在匹配失败的情况下提前结束（剪枝），回溯到上一层继续"
 * https://mp.weixin.qq.com/s/puk7IAZkSe6FCkZnt0jnSA
 * 橫坐标是x代表列，纵坐标y代表行，什么鬼？？？？？？？？？这个代码已经看不懂了，看year2023包吧
 */

public class Queue8_1_FindFirst {

    public static void main(String[] args) {
        //ATTENTION:↑↑↑↑
        settleQueen(0);
        printChessBoard();
    }

    static final int MAX_NUM = 8;

    static int[][] chessBoard = new int[MAX_NUM][MAX_NUM];

    static boolean check(int x, int y) {
        for (int i = 0; i < y; i++) {
            if (chessBoard[x][i] == 1) {
                return false;
            }
            if (x - 1 - i >= 0 && chessBoard[x - 1 - i][y - 1 - i] == 1) {
                return false;
            }
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
        for(int i=0;i<MAX_NUM;i++) {
            for(int x=0; x<MAX_NUM; x++) {
                chessBoard[x][y] = 0;
            }
            if(check(i,y)){
                chessBoard[i][y] = 1;
                if(settleQueen(y+1)) {
                    return true;
                }
            }
        }
        return false;
    }

    //打印棋盘当前值
    static void printChessBoard(){
        for(int i=0; i<MAX_NUM; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        //小灰原文里的代码是i和j反过来的，搞不明白....
        for(int j=0; j<MAX_NUM; j++) {
            for (int i = 0; i < MAX_NUM; i++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

}

