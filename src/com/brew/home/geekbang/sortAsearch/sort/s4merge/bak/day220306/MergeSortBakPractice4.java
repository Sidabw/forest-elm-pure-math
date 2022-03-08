package com.brew.home.geekbang.sortAsearch.sort.s4merge.bak.day220306;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class MergeSortBakPractice4 {

    public static void main(String[] args) {
        int[] arr = new int[] {10, 2, 32, 1, 56, 8, 12};
        new MergeSortBakPractice4().ms(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    void ms(int[] arr, int left, int right, int[] tmp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        ms(arr, left, mid, tmp);
        ms(arr, mid + 1, right, tmp);
        m2sa(arr, left, mid, right, tmp);
    }

    private void m2sa(int[] arr, int left, int mid, int right, int[] tmp) {
        int ls = left;
        int le = mid;
        int rs = mid + 1;
        int re = right;

        int ti = 0;
        while (ls <= le && rs <= re) {
            if (arr[ls] < arr[rs]) {
                tmp[ti++] = arr[ls++];
            } else {
                tmp[ti++] = arr[rs++];
            }
        }

        while (ls <= le) {
            tmp[ti++] = arr[ls++];
        }

        while (rs <= re) {
            tmp[ti++] = arr[rs++];
        }

        ti = 0;
        while (left <= right) {
            arr[left++] = tmp[ti++];
        }
    }
}
