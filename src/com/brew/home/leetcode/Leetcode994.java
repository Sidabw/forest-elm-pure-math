package com.brew.home.leetcode;

/**
 * @author shaogz
 */
public class Leetcode994 {

    public static void main(String[] args) {
        // //test2
        // System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        // System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        // System.out.println(orangesRotting(new int[][]{{0, 2}}));//0
        // System.out.println(orangesRotting(new int[][]{{0}}));//0
        // System.out.println(orangesRotting(new int[][]{{1}}));//-1
        // System.out.println(orangesRotting(new int[][]{{2}}));//0
        // System.out.println(orangesRotting(new int[][]{{1}, {2}}));//1
        // System.out.println(orangesRotting(new int[][]{{2}, {1}}));//1
    }

    public static int orangesRotting(int[][] grid) {
        if (grid.length == 0) return -1;
        //xia:  将4个正方向的好橘子变成烂橘子，同时计时+1
        int timing = 0;
        while (true) {
            boolean badExist = false;
            boolean preBadExist = false;
            boolean goodExist = false;
            int iLen = grid.length;
            for (int i = 0; i < iLen; i++) {
                int jLen = grid[i].length;
                for (int j = 0; j < jLen; j++) {
                    int cur = grid[i][j];
                    if (cur == 1)
                        goodExist = true;
                    if (cur == 0 || cur == 1 || cur == 3)
                        continue;
                    badExist = true;
                    //此时cur == 2
                    //正4方向
                    int i1 = i - 1;
                    int i2 = i + 1;
                    int j1 = j - 1;
                    int j2 = j + 1;
                    //把所有不越界的新鲜橘子变成准备腐烂橘子
                    if (i1 > -1 && i1 < iLen && grid[i1][j] == 1) {
                        if (grid[i1][j] == 1)
                            goodExist = true;
                        grid[i1][j] = 3;
                        preBadExist = true;
                    }
                    if (i2 > -1 && i2 < iLen && grid[i2][j] == 1) {
                        if (grid[i2][j] == 1)
                            goodExist = true;
                        grid[i2][j] = 3;
                        preBadExist = true;
                    }
                    if (j1 > -1 && j1 < jLen && grid[i][j1] == 1) {
                        if (grid[i][j1] == 1)
                            goodExist = true;
                        grid[i][j1] = 3;
                        preBadExist = true;
                    }
                    if (j2 > -1 && j2 < jLen && grid[i][j2] == 1) {
                        if (grid[i][j2] == 1)
                            goodExist = true;
                        grid[i][j2] = 3;
                        preBadExist = true;
                    }
                }
            }
            //初始化状态下没有1则return0
            if (timing == 0 && !goodExist)
                return timing;
            //遍历一圈没有2，return-1
            if (!badExist)
                return -1;
            //遍历一圈发现没有3了，那就完事了
            if (!preBadExist) {
                //此时表示有一个或几个1永远都不会变成2
                if (goodExist) return -1;
                return timing;
            }
            for (int i = 0; i < iLen; i++) {
                int jLen = grid[i].length;
                for (int j = 0; j < jLen; j++) {
                    int cur = grid[i][j];
                    if (cur == 3)
                        grid[i][j] = 2;
                }
            }
            timing++;
            //shang:
        }

    }


}
