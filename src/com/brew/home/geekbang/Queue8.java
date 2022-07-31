package com.brew.home.geekbang;

/**
 * 八皇后问题，程序员小灰
 * https://mp.weixin.qq.com/s/puk7IAZkSe6FCkZnt0jnSA
 */
public class Queue8 {

    static final int MAX_NUM = 8;

    int[][] chessBoard = new int[MAX_NUM][MAX_NUM];

    //检查落点是否符合规则
    boolean check(int x, int y) {
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

    boolean settleQueen(int y) {
        //行数超过8，说明已经找出答案
        if(y == MAX_NUM){
            return true;
        }
        //遍历当前行，逐一格子验证
        for(int i=0;i<MAX_NUM;i++) {
            //为当前行清零，以免在回溯的时候出现脏数据
            for(int x=0; x<MAX_NUM; x++) {
                chessBoard[x][y] = 0;
            }
            //检查是否符合规则，如果符合，更改元素值并进一步递归
            if(check(i,y)){
                chessBoard[i][y] = 1;
                //递归如果返回true，说明下层已找到解法，无需继续循环
                if(settleQueen(y+1)) {
                    return true;
                }
            }
        }
        return false;
    }

    //打印棋盘当前值
    void printChessBoard(){
        for(int j=0; j<MAX_NUM; j++) {
            for (int i = 0; i < MAX_NUM; i++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.settleQueen(0);
        queue8.printChessBoard();
    }
}

