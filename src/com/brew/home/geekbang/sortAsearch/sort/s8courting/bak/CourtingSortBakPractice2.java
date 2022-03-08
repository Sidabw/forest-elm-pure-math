package com.brew.home.geekbang.sortAsearch.sort.s8courting.bak;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class CourtingSortBakPractice2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourtingSortBakPractice2().cs(new int[] {2, 5, 3, 0, 2, 3, 0, 3})));
    }

    public int[] cs(int[] arr) {
        //找到max
        int max = -1;
        for (int each : arr) {
            if (each > max) {
                max = each;
            }
        }

        // inti tmpC
        int[] tmpC = new int[max + 1];
        for (int each : arr) {
            tmpC[each]++;
        }

        //courting tmpC
        for (int i = 1; i < tmpC.length; i++) {
            tmpC[i]+=tmpC[i - 1];
        }

        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int indexInSortedArr = tmpC[arr[i]] - 1;
            sorted[indexInSortedArr] = arr[i];
            tmpC[arr[i]]--;
        }
        return sorted;
    }
}
