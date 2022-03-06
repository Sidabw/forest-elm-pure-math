package com.brew.home.geekbang.sortAsearch.sort.s1merge.bak.day220306;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class MergeSortBakPractice3 {

    public static void main(String[] args) {
        int[] arr = new int[] {5, 23, 2, 1, 7, 12, 90, 3};
        new MergeSortBakPractice3().mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, tmp);
        mergeSort(arr, mid + 1, right, tmp);
        m2sArr(arr, left, mid, right, tmp);
    }

    private void m2sArr(int[] arr, int left, int mid, int right, int[] tmp) {
        int tmpIndex= 0;
        int lStart = left;
        int lEnd = mid;
        int rStart = mid + 1;
        int rEnd = right;

        while (lStart <= lEnd && rStart <= rEnd) {
            if (arr[lStart] < arr[rStart]) {
                tmp[tmpIndex++] = arr[lStart++];
            } else {
                tmp[tmpIndex++] = arr[rStart++];
            }
        }

        while (lStart <= lEnd) {
            tmp[tmpIndex++] = arr[lStart++];
        }

        while (rStart <= rEnd) {
            tmp[tmpIndex++] = arr[rStart++];
        }

        tmpIndex = 0;
        while (left <= right) {
            arr[left++] = tmp[tmpIndex++];
        }

    }

}
