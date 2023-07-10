package com.brew.home.geekbang.p6algo4.dynamic;

public class CalStrSimilarity2 {
    
    public static void main(String[] args) {
        //计算字符串相似程度：莱文斯坦DP实现

    }
    public int lwstDP(char[] a, int n, char[] b, int m) { 
        int[][] minDist = new int[n][m];
        //初始化第一行
        minDist[0][0] = a[0] == b[0] ? 0 : 1;
        for(int j = 1; j < m; j++) {
            if(a[0] == b[j]) {
                //a[0]==b[4] minDist[0][4] = 4 可以理解为把前面的都删掉，得一个4
                minDist[0][j] = j;
            } else {
                minDist[0][j] = minDist[0][j-1] + 1;
            }
        }

        //初始化第一列
        for(int i = 1; i < n; i++) {
            if(b[0] == a[i]) {
                minDist[i][0] = i;
            } else {
                minDist[i][0] = minDist[i-1][0] + 1;
            }
        }

        //dp
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(a[i] == b[j]) {
                    minDist[i][i] = min(minDist[i-1][j] + 1, minDist[i][j-1] + 1, minDist[i-1][j-1]);
                } else {
                    minDist[i][i] = min(minDist[i-1][j] + 1, minDist[i][j-1] + 1, minDist[i-1][j-1] + 1);
                }
            }
        }

        return minDist[n-1][m-1];
    }

    private int min(int x, int y, int z) {
        int res = Integer.MAX_VALUE;
        if(x < res) {
            res = x;
        }
        if(y < res) {
            res = y;
        }
        if (z < res) {
            res = z;
        }
        return res;
    }

}
