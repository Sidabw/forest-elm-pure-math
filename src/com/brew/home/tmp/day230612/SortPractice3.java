package com.brew.home.tmp.day230612;

import static com.brew.home.geekbang.p1sortAsearch.sort.s5quick.QuickSort.swap;

import java.util.Arrays;


public class SortPractice3 {
    
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 3, 4, 8};
        quickSort(a, 0, 4);
        System.out.println(Arrays.toString(a));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left>=right) {
            return;
        }
        int pirot = partication(arr, left, right);
        quickSort(arr, left, pirot - 1);
        quickSort(arr, pirot + 1, right);
    }

    private static int partication(int[] arr, int left, int r) {
        int i = left;
        int j = left;
        while (j < r) {
            if(arr[j] > arr[r]) {
                j++;
            } else {
                swap(i, j, arr);
                j++;i++;
            }
        }

        swap(i, r, arr);

        return i;
    }
}
