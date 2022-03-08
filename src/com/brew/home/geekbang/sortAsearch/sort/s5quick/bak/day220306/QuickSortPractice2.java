package com.brew.home.geekbang.sortAsearch.sort.s5quick.bak.day220306;

import java.util.Arrays;

import static com.brew.home.geekbang.sortAsearch.sort.s5quick.QuickSort.swap;

/**
 * @author shaogz
 */
public class QuickSortPractice2 {

    public static void main(String[] args) {
        int[] arr = new int[] {5, 23, 2, 1, 7, 12, 90, 3};
        new QuickSortPractice2().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    void quickSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int pivot = qsPartition(arr, p, r);
        quickSort(arr, p, pivot - 1);
        quickSort(arr, pivot + 1, r);
    }

    int qsPartition(int[] arr, int p, int r) {
        int i = p;
        int j = p;
        while (j < r) {
            if (arr[j] < arr[r]) {
                swap(j++, i++, arr);
            } else {
                j++;
            }
        }
        swap(i, r, arr);
        return i;
    }
}
