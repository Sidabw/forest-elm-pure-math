/**
 * Copyright (C), 2018-2021, zenki.ai
 * FileName: BMdemo
 * Author:   feiyi
 * Date:     2021/1/24 6:19 PM
 * Description: 字符串匹配算法BM的代码实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.geekbang.p5str.bm;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉:
 * 〈字符串匹配算法BM的代码实现, 只考虑'坏字符规则'〉
 *  <p> 1. 牢记坏字符的两个规则，一个是该坏字符在模式串中找不到，一个是该坏字符在模式串中找到了。
 *  <p> 2. 提前处理一个bc数组，是为了更快的找到该坏字符在模式串中有没有，在什么位置、
 *  <p> 3. 模式串是倒着匹配的
 *
 * @author feiyi
 * @create 2021/1/24
 * @since 1.0.0
 */
public class BM4BadChar {

    public static void main(String[] args) {
        String mainStr = "avadfaeterutysdfgaewhbdaffa";
        String subStr = "ut";
        System.out.println(new BM4BadChar().bm(mainStr.toCharArray(), mainStr.length(), subStr.toCharArray(), subStr.length()));



        //其他
        char a = 'a';
        char b = '中';//猜测，改成Unicode了？
        System.out.println((int)a);
        System.out.println((int)b);//输出20013
    }

    /**
     * 只考虑坏字符规则的BM字符串匹配，且不考虑si - xi 得一个负数的情况
     * @param a 主串
     * @param n 主串的长度
     * @param b 模式串
     * @param m 模式串的长度
     * @return int
     * @since 2.0.5
     * @author feiyi 2021/1/25 9:50 AM
     **/
    public int bm(char[] a, int n, char[] b, int m) {
        //构建坏字符哈希表
        int[] bc = genBC(b, m);
        int i = 0;
        while (i <= n - m) {
            int j;
            //模式串倒着跟主串匹配
            for (j = m - 1; j >=0 ; j--) {
                //不匹配，此时j即坏字符，j对应的下标即si
                if (a[i+j] != b[j]) {break;}
            }
            //匹配成功
            if (j < 0) {
                return i;
            }
            //此时说明匹配失败，模式串要向右移动，对应的就是i的右移。
            //按照'坏字符'原则，向右移动 si - xi位。没有匹配的情况下就是右移j+1位
            i = i + (j - bc[(int)a[i+j]]);
        }
        return -1;
    }

    private static final int SIZE = 256;

    /**
     * 生成计算xi的ascii数组
     * @param b 模式串
     * @param m 模式串的长度
     * @return void
     * @since 2.0.5
     * @author feiyi 2021/1/24 6:21 PM
     **/
    public static int[] genBC(char[] b, int m) {
        //bc 模式串对应的散列表。用于快速找到该坏字符在模式串中出现的位置。
        int[] bc = new int[SIZE];
        Arrays.fill(bc, -1);
        //将设a是坏字符。a的ascii计作a_ascii, 那么实际用的时候bc[a_ascii]得到的就是坏字符a在模式串中的角标
        for (int i = 0; i < m; i++) {
            int ascii = (int)b[i];
            bc[ascii] = i;
        }
        //正着遍历，有重复的则后面的覆盖前面的，符合预期，避免步子迈大了。
        //上面说了，不考虑负数的情况
        return bc;
    }

}
