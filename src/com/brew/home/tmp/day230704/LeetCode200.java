package com.brew.home.tmp.day230704;

public class LeetCode200 {
    
    public static void main(String[] args) {
        //题解：
        //https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
        
    }

    public int numIslands(char[][] grid) {

        int count = 0;

        for(int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;

    }

    private void dfs(char[][] grid, int r, int c) {
        if(!isInArea(grid, r, c)) {
            return;
        }
        if(grid[r][c] != '1') {
            return;
        }
        //表示遍历过，避免重复遍历。
        grid[r][c] = '2';

        //四个叉的dfs
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }

    private boolean isInArea(char[][] grid, int r, int c) {
        //r row, c column
        return r >=0 && r < grid.length && c >=0 && c < grid[0].length;
    }
}
