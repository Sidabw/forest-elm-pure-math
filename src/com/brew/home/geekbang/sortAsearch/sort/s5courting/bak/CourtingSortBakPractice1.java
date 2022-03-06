package com.brew.home.geekbang.sortAsearch.sort.s5courting.bak;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class CourtingSortBakPractice1 {

    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        System.out.println(Arrays.toString(new CourtingSortBakPractice1().courtingSort(arr)));
    }

    int[] courtingSort(int[] arr) {
        //得到int max
        int max = -1;
        for (int each : arr) {
            if (each > max) {
                max = each;
            }
        }
        //得到第一个c[6]
        int[] tmpC = new int[max + 1];
        for (int each : arr) {
            tmpC[each]++;
        }

        //对c[6]顺序求和
        for (int i = 1; i < tmpC.length ; i ++) {
            tmpC[i] += tmpC[i-1];
        }

        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i>=0; i--) {
            //当前元素在tmpC的角标
            int index = arr[i];
            //当前元素在有序数组中的角标
            int sortedIndex = tmpC[index] - 1;
            //赋值
            sorted[sortedIndex] = arr[i];
            //小于XX的少了一个
            tmpC[index]--;
        }
        return sorted;
    }
}
