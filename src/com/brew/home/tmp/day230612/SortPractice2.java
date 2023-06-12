package com.brew.home.tmp.day230612;

import java.util.Arrays;

public class SortPractice2 {
    
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 3, 4, 8};
        int[] temp = new int[5];
        mergeSort(a, 0, 4, temp);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if(left >= right) {
            return;
        }
        int mid = (left + right)/2;
        mergeSort(arr, left, mid, tmp);
        mergeSort(arr, mid + 1, right, tmp);
        merge(arr, left, mid, right, tmp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        int s1 = left;
        int s2 = mid;

        int r1 = mid + 1;
        int r2 = right;

        int t1 = 0;
        while (s1 <= s2 && r1 <= r2) {
            if(arr[s1] < arr[r1]) {
                tmp[t1] = arr[s1];
                s1++;
            } else{
                tmp[t1] = arr[r1];
                r1++;
            }
            t1++;
        }

        while(s1<=s2) {
            tmp[t1++] = arr[s1++];
        }

        while(r1<=r2) {
            tmp[t1++] = arr[r1++];
        }

        for(int i = 0; i < t1; ) {
            arr[left++] = tmp[i++];
        }
    }
}
