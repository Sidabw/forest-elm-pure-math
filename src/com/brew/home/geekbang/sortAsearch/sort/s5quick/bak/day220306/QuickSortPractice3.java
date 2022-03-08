package com.brew.home.geekbang.sortAsearch.sort.s5quick.bak.day220306;

import java.util.Arrays;

import static com.brew.home.geekbang.sortAsearch.sort.s5quick.QuickSort.swap;

/**
 * @author shaogz
 */
public class QuickSortPractice3 {

    public static void main(String[] args) {
        int[] arr = new int[] {4, 1, 2, 6, 9,7, 3, 8};
        new QuickSortPractice3().qs(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    void qs(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(arr, left, right);
        qs(arr, left, pivot - 1);
        qs(arr, pivot + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int i = left;
        int j = left;
        int r = right;

        while (j < r) {
            if (arr[j] < arr[r]) {
                swap(i++, j++, arr);
            } else {
                j++;
            }
        }

        swap(i, r, arr);
        return i;
    }
}
