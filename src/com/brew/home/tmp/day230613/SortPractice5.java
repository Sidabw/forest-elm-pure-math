package com.brew.home.tmp.day230613;

import java.util.Arrays;

public class SortPractice5 {
    
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,0,2,3,0,3};
        System.out.println(Arrays.toString(countingSort(arr, 5)));
    }

    private static int[] countingSort(int[] arr, int max) {

        //part-1
        //tmp下标是arr的元素。tmp的值是对应元素出现的次数。
        int[] tmp = new int[max + 1];
        for(int i = 0; i < arr.length; i++) {
            tmp[arr[i]]++;
        }

        //part-2
        //顺序求和，tmp变成：小于等于x的元素的个数
        for(int i = 1; i < tmp.length; i++) {
            tmp[i] += tmp[i-1];
        }

        //part-3
        //倒序遍历arr，根据tmp求得res
        int[]res = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--) {
            int val = arr[i];
            res[--tmp[val]] = val;
        }
        return res;
    }
}
