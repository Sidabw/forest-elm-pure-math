package com.brew.home.geekbang.sortAsearch.sort.s2insert;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 6, 7, 10, 8, 3};
        new InsertSort().insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序，a表示数组，n表示数组大小
     * @param a arr
     * @param n arr.len
     */
    public void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    // 数据移动
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            // 插入数据
            a[j+1] = value;
        }
    }
}
