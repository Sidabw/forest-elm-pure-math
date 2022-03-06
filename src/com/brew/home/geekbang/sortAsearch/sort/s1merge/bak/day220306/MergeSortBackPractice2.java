package com.brew.home.geekbang.sortAsearch.sort.s1merge.bak.day220306;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class MergeSortBackPractice2 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 3, 4, 8};
        int[] temp = new int[5];
        new MergeSortBackPractice2().mSort(a, 0, 4, temp);
        System.out.println(Arrays.toString(a));
    }

    void mSort(int[] arr, int first, int last, int[] tmp) {
        if (first >= last) {
            return;
        }
        int mid = (first + last) / 2;
        mSort(arr, first, mid, tmp);
        mSort(arr, mid + 1, last, tmp);
        mSortedArr(arr, first, mid, last, tmp);
    }

    private void mSortedArr(int[] arr, int first, int mid, int last, int[] tmp) {
        int i = first;
        int iEnd = mid;
        int j = mid + 1;
        int jEnd = last;

        int tmpIndex = 0;
        while (i <= iEnd && j <= jEnd) {
            if (arr[i] < arr[j]) {
                tmp[tmpIndex++] = arr[i++];
            } else {
                tmp[tmpIndex++] = arr[j++];
            }
        }

        while (i <= iEnd) {
            tmp[tmpIndex++] = arr[i++];
        }
        while (j <= jEnd) {
            tmp[tmpIndex++] = arr[j++];
        }

        tmpIndex = 0;
        while (first<=last) {
            arr[first++] = tmp[tmpIndex++];
        }
    }
}
