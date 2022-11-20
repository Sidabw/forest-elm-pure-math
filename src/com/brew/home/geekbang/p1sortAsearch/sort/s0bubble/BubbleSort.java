package com.brew.home.geekbang.p1sortAsearch.sort.s0bubble;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 6, 7, 10, 8};
        new BubbleSort().bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序，a表示数组，n表示数组大小
     * @param a arr
     * @param n arr.len
     */
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                // 交换
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
    }
}
