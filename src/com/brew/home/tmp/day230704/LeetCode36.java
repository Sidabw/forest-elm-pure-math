package com.brew.home.tmp.day230704;

import java.util.Arrays;

public class LeetCode36 {
    
    public static void main(String[] args) {
        
    }

    public boolean isValidSudoku(char[][] board) {

        for(int i = 0 ; i < board.length; i++) {

            char[] curRow = board[i];
            
        }

        for(int i = 0 ; i < 9; i++) {
            int[] tmp = new int[9];//对应下标[0,8]
            Arrays.fill(tmp, 0);

            int[] tmp2 = new int[9];//对应下标[0,8]
            Arrays.fill(tmp2, 0);
            for(int j = 0 ; j < 9; j++) {
                //每一行
                char cur = board[i][j];
                int index= getIntVal(cur);
                if(index != -1 && ++tmp[index] > 1) {
                    return false;
                }
                //每一列
                char cur2 = board[j][i];
                int index2= getIntVal(cur2);
                if(index2 != -1 && ++tmp2[index2] > 1) {
                    return false;
                }
            }
        }

        //最后没做...
        //https://leetcode.cn/problems/valid-sudoku/solutions/1001859/you-xiao-de-shu-du-by-leetcode-solution-50m6/
        return false;
        //board[1][1]，board[1][2]，board[1][3]
    }

    private int getIntVal(char c) {
        if(c == '.') {
            return -1;
        }
        return c - '1';
    }
}
