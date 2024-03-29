/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: QuickSort
 * Author:   feiyi
 * Date:     2019/12/16 7:39 PM
 * Description: 快速排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.geekbang.p1sortAsearch.sort.s5quick;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉:
 * 〈<p> 快排，快速排序
 * <p> 参考：https://blog.csdn.net/shujuelin/article/details/82423852〉
 * <p> 感觉没有极客时间上那个好理解，分区代码简单呢...
 * @author feiyi
 * @create 2019/12/16
 * @since 1.0.0
 */
public class QuickSort {

    public static void main(String[] args){
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //原文代码
    public static void quickSort2(int[] arr, int low, int high) {
        int i, j, temp, t;

        if (low > high) return;
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];
        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) j--;
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) i++;
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;

        //递归调用左半数组
        quickSort2(arr, low, j - 1);
        //递归调用右半数组
        quickSort2(arr, j + 1, high);
    }

    public static void swap(int i, int j, int[] arr) {
        int t;
        t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

}
