package com.brew.home.geekbang.p6algo4.dynamic;

public class MinDist {
    
    public static void main(String[] args) {
        //题目：有一个 n 乘以 n 的矩阵 w[n][n]，每次只能向右或者向下移动一位，从起点到终点每条路径经过的数字加起来作为路径的长度，求最短路径
        //其他参考：课程41或印象笔记
    }

    public int minDistDP(int[][] matrix, int n) {
        //状态转移方程：min_dist(i, j) = w[i][j] + min(min_dist(i, j-1), min_dist(i-1, j))

        int[][] states = new int[n][n];
        //对第一行初始化
        int sumFirstRow = 0;
        for(int i = 0; i < matrix[0].length; i++) {
            sumFirstRow+= matrix[0][i];
            states[0][i] = sumFirstRow;
        }
        //对第一列初始化
        int sumFirstColumn = 0;
        for(int i = 1; i < matrix.length; i++) {
            sumFirstColumn+=matrix[i][0];
            states[i][0] = sumFirstColumn;
        }
        //dp
        //就是一行一行的遍历，参考印象笔记的“二维图表”的图
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                states[i][j] = matrix[i][j] + Math.min(states[i-1][j], states[i][j-1]);
            }
        }

        return states[n-1][n-1];
    }
}
