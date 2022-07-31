package com.brew.home.geekbang.str.bm;


import java.util.Arrays;

/**
 * 字符串匹配算法BM的代码实现, 完整实现
 * <p>  实际上就是坏字符跟好后缀都来一次，取个大的。
 * <p>
 * <p> 字符串匹配算法BM的代码实现, 只考虑'好后缀规则', 牢记：
 * <p> 1. 完整的好后缀能否在模式串中再找到一个
 * <p> 2. 拿好后缀的后缀子串去跟模式串的前缀子串去比。
 * <p> 3. suffix prefix 两个数组来实现上面两个规则；注意数组的下标，代表的后缀子串的长度。很巧妙
 * @author shaogz
 * @create 2022/7/13
 * @since 1.0.0
 */
public class BM {

    public static void main(String[] args) {
        String mainStr = "avadfaeterutysdfgaewhbdaffa";
        String subStr = "ut";
        System.out.println(new BM().bm(mainStr.toCharArray(), mainStr.length(), subStr.toCharArray(), subStr.length()));
    }

    // a,b表示主串和模式串；n，m表示主串和模式串的长度。
    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = BM4BadChar.genBC(b, m);// 构建坏字符哈希表
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0; // j表示主串与模式串匹配的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
                if (a[i+j] != b[j]) break; // 坏字符对应模式串中的下标是j
            }
            if (j < 0) {
                return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            }
            int x = j - bc[(int)a[i+j]];
            int y = 0;
            if (j < m-1) { // 如果有好后缀的话
                y = moveByGS(j, m, suffix, prefix);
            }
            i = i + Math.max(x, y);
        }
        return -1;
    }

    // j表示坏字符对应的模式串中的字符下标; m表示模式串长度
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j; // 好后缀长度
        if (suffix[k] != -1) return j - suffix[k] +1;
        for (int r = j+2; r <= m-1; ++r) {
            if (prefix[m-r] == true) {
                return r;
            }
        }
        return m;
    }

    // b表示模式串，m表示长度，suffix，prefix数组事先申请好了
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        // 初始化
        Arrays.fill(suffix, -1);
        Arrays.fill(prefix, false);

        for (int i = 0; i < m - 1; ++i) { // b[0, i]
            int j = i;
            int k = 0; // 公共后缀子串长度
            //看图generateGS.png
            while (j >= 0 && b[j] == b[m-1-k]) { // 与b[0, m-1]求公共后缀子串
                --j;
                ++k;
                suffix[k] = j+1; //j+1表示公共后缀子串在b[0, i]中的起始下标
            }
            if (j == -1) prefix[k] = true; //如果公共后缀子串也是模式串的前缀子串
        }
    }


}
