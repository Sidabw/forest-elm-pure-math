package com.brew.home.geekbang.p6algo4.dynamic;

public class CalStrSimilarity1 {

    public static void main(String[] args) {
        //计算字符串相似程度：莱文斯坦回溯实现
        
    }

    private char[] a = "mitcmu".toCharArray();
    private char[] b = "mtacnu".toCharArray();
    private int n = a.length;
    private int m = b.length;
    
    private int min_dist = Integer.MIN_VALUE;

    //lwstBT(0,0,0)调用。i和j分别代表a和b的当前index
    public void lwstBT(int i, int j, int edist) {
        if(i==n || j == m) {
            if (i < n) {
                edist = edist + (n-i);
            }
            if(j < m) {
                edist = edist + (m-j);
            }
            if (edist < min_dist) {
                min_dist = edist;
            }
            return;
        }

        if(a[i] == b[i]) {
            lwstBT(i+1, j+1, edist);
            return;
        }
        //两者不相等，分三叉不同情况，详细参考笔记
        lwstBT(i+1, j, edist+1);
        lwstBT(i, j+1, edist+1);
        lwstBT(i+1, j+1, edist+1);
    }

}