package com.brew.home.geekbang.p5str.kmp;

/**
 * 字符串匹配算法，kmp
 */
public class KMP {

    public static void main(String[] args) {
        String mainStr = "avadfaeterutysdfgaewhbdaffa";
        String subStr = "ut";
        System.out.println(kmp(mainStr.toCharArray(), mainStr.length(), subStr.toCharArray(), subStr.length()));
    }


    // a, b分别是主串和模式串；n, m分别是主串和模式串的长度。
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            //在遇到坏字符时，模式串要往后移。但是，这个向后移是对比主串的，代码实现上不用考虑。遇到坏字符时，J是一定往前走的
            while (j > 0 && a[i] != b[j]) { // 一直找到a[i]和b[j]
                //进来则表示遇到坏字符了，此时J变成0还是向右移动，由next数组决定
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) { // 找到匹配模式串的了
                return i - m + 1;
            }
        }
        return -1;
    }

    // b表示模式串，m表示模式串的长度
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                //就是文章上面那一句：“查找 b[0, y]的最长匹配后缀子串的问题了”
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }
}
