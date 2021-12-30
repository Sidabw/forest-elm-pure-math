package com.brew.home.geekbang.sortAsearch.sort.s1merge.bak.day211205;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class MergeSortBakPractice1 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 3, 4, 8};
        int[] temp = new int[5];
        mergeSort(a, 0, 4, temp);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] origin, int first, int last, int[] tmp) {
        if (first >= last) {
            return;
        }
        int mid = (last + first) / 2;
        mergeSort(origin, first, mid, tmp);
        mergeSort(origin,mid + 1, last, tmp);
        mergeTwoSortedArray(origin, first, mid, last, tmp);
    }

    private static void mergeTwoSortedArray(int[] origin, int first, int mid, int last, int[] tmp) {
        //1. 合并两个有序数组
        int leftIndex = first;
        int rightIndex = mid + 1;
        int tmpArrIndex = 0;
        while (leftIndex <= mid && rightIndex <= last) {
            if (origin[leftIndex] < origin[rightIndex]) {
                tmp[tmpArrIndex++] = origin[leftIndex++];
            } else {
                tmp[tmpArrIndex++] = origin[rightIndex++];
            }
        }
        //2. 处理数组1已经处理完了，数组2还有剩余的情况
        while (leftIndex <= mid) {
            tmp[tmpArrIndex++] = origin[leftIndex++];
        }
        //3. 同上
        while (rightIndex <= last) {
            tmp[tmpArrIndex++] = origin[rightIndex++];
        }
        tmpArrIndex = 0;
        //放到到origin里去
        while (first<=last) {
            origin[first++] = tmp[tmpArrIndex++];
        }
    }
}
