package com.brew.home.geekbang.p1sortAsearch.sort.s5quick.bak.day220306;

import java.util.Arrays;

import static com.brew.home.geekbang.p1sortAsearch.sort.s5quick.QuickSort.swap;

/**
 * @author shaogz
 */
public class QuickSortPractice1 {

    public static void main(String[] args) {
        //测试整体排序代码
        int[] arr = new int[]{6, 11, 3, 9, 8};
        new QuickSortPractice1().quickSort(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }

    void quickSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int pivot = qSortPartition(arr, p, r);
        quickSort(arr, p, pivot - 1);
        quickSort(arr, pivot + 1, r);
    }

    int qSortPartition(int[] arr, int p, int r) {
        int i = p;
        int j = p;
        //默认是把最后一个元素，即 r 角标元素作为分区点
        while (j < r) {
            if (arr[j] < arr[r]) {
                swap(i, j, arr);
                i++;j++;
            } else {
                j++;
            }
        }
        swap(i, r, arr);
        return i;
    }
}
