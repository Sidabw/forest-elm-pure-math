package com.brew.home.tmp.day230704;

import java.util.Arrays;

public class LeetCode36 {
    
    public static void main(String[] args) {
        //有效的数独，题解：
        //https://leetcode.cn/problems/valid-sudoku/solutions/1001859/you-xiao-de-shu-du-by-leetcode-solution-50m6/

        //对于int[][][] subboxes部分，可以理解为一个黑框包起来的就是一个元素，所以是int[3][3]的二维数组，但每个元素实际是9个值，所以变成了int[3][3][9]
    }

    public boolean isValidSudoku(char[][] board) {

        int[][][] subboxes = new int[3][3][9];
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

                if (index != -1 && ++subboxes[i / 3][j / 3][index] > 1) {
                    return false;
                }
            }
        }

        //最后没做...
        
        return true;
    }

    private int getIntVal(char c) {
        if(c == '.') {
            return -1;
        }
        return c - '1';
    }
}
