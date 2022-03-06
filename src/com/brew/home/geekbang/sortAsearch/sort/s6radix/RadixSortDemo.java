package com.brew.home.geekbang.sortAsearch.sort.s6radix;

import com.brew.home.geekbang.sortAsearch.sort.s5courting.bak.CourtingSortBakPractice2;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class RadixSortDemo {

    public static void main(String[] args) {
        //用二维数组表示手机号，第一个[]表示行，第二个[]表示列。
        //用手机号造数据太麻烦了，还是用geekbang原文的例子来实现吧
        char[][] phoneNums = new char[5][3];
        phoneNums[0] = new char[]{'h', 'k', 'e'};
        phoneNums[1] = new char[]{'i', 'b', 'a'};
        phoneNums[2] = new char[]{'h', 'z', 'g'};
        phoneNums[3] = new char[]{'i', 'k', 'f'};
        phoneNums[4] = new char[]{'h', 'a', 'c'};

        radixSort(phoneNums);

        //倒着对每一列执行稳定排序。比如计数排序。【快排是万万不能用的】
        System.out.println(Arrays.toString(phoneNums[0]));
        System.out.println(Arrays.toString(phoneNums[1]));
        System.out.println(Arrays.toString(phoneNums[2]));
        System.out.println(Arrays.toString(phoneNums[3]));
        System.out.println(Arrays.toString(phoneNums[4]));

    }

    private static void radixSort(char[][] phoneNums) {
        for (int i = phoneNums.length - 1; i >= 0; i--) {
            char[] cur = phoneNums[i];
            //用ASCII转一下int和char
            int[] curIntArr = charArr2IntArr(cur);
            //计数排序
            int[] courtingSortRes = new CourtingSortBakPractice2().cs(curIntArr);
            //ASCII
            char[] res = intArr2CharArr(courtingSortRes);
            for (int j = 0; j < cur.length; j++) {
                cur[j] = res[j];
            }
            System.out.println(1);
        }
    }

    private static int[] charArr2IntArr(char[] cur) {
        int[] res = new int[cur.length];
        for (int i = 0; i<cur.length;i++) {
            res[i] = (int)cur[i];
        }
        return res;
    }

    private static char[] intArr2CharArr(int[] curIntArr) {
        char[] res = new char[curIntArr.length];
        for (int i = 0; i < curIntArr.length; i++) {
            res[i] = (char)curIntArr[i];
        }
        return res;
    }

}
