package com.brew.home.geekbang.p6algo4.recall.year2023;

public class Queue8_1_FindFirst_2 {
    

    public static void main(String[] args) {
        //使用一维数组解决八皇后问题，详细参考：
        //https://time.geekbang.org/column/article/74287?screen=full
        //感觉更简单的还是找所有吧；找第一个相比于找所有多了一些条件判断
        //代码是一套
        new Queue8_1_FindFirst_2().cal8queen(0);
    }

    private final int[] res = new int[8];
    public boolean cal8queen(int row) {
        if(row == 8) {
            print();
            return true;
        }

        for (int column = 0; column < 8; column++) {
            
            if(isValid(row, column)) {
                res[row] = column;
                boolean done = cal8queen(row+1);
                if(done) return done;
            }

        }
        return false;
    }

    private boolean isValid(int row, int column) {
        //从当前行向上，左上，右上看是否合法。下面都没有自然不用看。
        int leftUp = column-1;
        int rightUp = column+1;
        for(int i = row - 1; i >= 0 ; i--) {

            if(res[i] == column) return false;
            
            if(leftUp>=0) {
                //每行只有一个元素
                if(res[i] == leftUp) return false;
            }

            if(rightUp<8) {
                if(res[i] == rightUp) return false;
            }
            leftUp--;rightUp++;
        }
        return true;
    }

    private void print() {
        for(int row = 0; row < res.length; row++) {
            for(int column = 0; column < 8; column++) {
                if(res[row] == column)
                    System.out.print("Q ");
                else 
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
