package com.brew.home.geekbang.sortAsearch.sort.s4merge.bak.day220306;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class MergeSortBakPractice1 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 3, 4, 8};
        int[] temp = new int[5];
        new MergeSortBakPractice1().mergeSort(a, 0, 4, temp);
        System.out.println(Arrays.toString(a));
    }

    void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, tmp);
        mergeSort(arr, mid + 1, right, tmp);
        merge2sortedArr(arr, left, mid, right, tmp);
    }

    private void merge2sortedArr(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left;
        int iEnd = mid;
        int j = mid + 1;
        int jEnd = right;
        //双指针往前走
        int tmpIndex = 0;
        while (i <= iEnd && j <= jEnd) {
            if (arr[i] > arr[j]) {
                tmp[tmpIndex++] = arr[j++];
            } else {
                tmp[tmpIndex++] = arr[i++];
            }
        }

        while (i <= iEnd) {
            tmp[tmpIndex++] = arr[i++];
        }
        while (j <= jEnd) {
            tmp[tmpIndex++] = arr[j++];
        }

        tmpIndex = 0;
        while (left <= right) {
            arr[left++] = tmp[tmpIndex++];
        }

    }

}
