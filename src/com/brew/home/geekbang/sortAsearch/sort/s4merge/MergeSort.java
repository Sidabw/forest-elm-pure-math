/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: MergeSort
 * Author:   feiyi
 * Date:     2019/10/23 10:16 AM
 * Description: 归并排序
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.geekbang.sortAsearch.sort.s4merge;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉:
 * <p>〈归并排序
 * <p> 基本思想：
 * <p> 将原始数组一直拆分，拆分到只有1个元素时我们就认为是有序的了，之后一直进行合并2个有序数组的操作。
 * <p>
 * <p> 1。首先考虑下如何将将二个有序数列合并。这个非常简单，只要从比较二个数列的第一个数，谁小就先取谁，取了后就在对应数列中删除这个数。
 * <p> 然后再进行比较，如果有数列为空，那直接将另一个数列的数据依次取出即可。
 * <p> 2。可以将A，B组各自再分成二组。依次类推，当分出来的小组只有一个数据时，可以认为这个小组组内已经达到了有序，然后再合并相邻的二个
 * <p> 小组就可以了。这样通过先 递归 的分解数列，再 合并 数列就完成了归并排序。
 * 〉
 *
 * @author feiyi
 * @create 2019/10/23
 * @since 1.0.0
 */
public class MergeSort {

    public static void main(String[] args) {
//        1。sortedArrayMerged 测试
//        int[] a = new int[]{6, 100, 202};
//        int[] b = new int[]{1, 8, 38, 301};
//        System.out.println(JSONArray.toJSONString(sortedArrayMerged(a,b)));

//        2。sortedArrayMerged2 测试
//        int[] a = new int[]{1, 5, 3, 4, 8};
//        int[] temp = new int[4];
//        sortedArrayMerged2(a, 0, 1, 3, temp);
//        System.out.println(JSONArray.toJSONString(a));
//        System.out.println(JSONArray.toJSONString(temp));

        // int[] a = new int[]{1, 5, 3, 4, 8};
        // //两个有序数组合并的时候使用，不用每次都创建新的temp[]出来
        // int[] temp = new int[5];
        // mergeSort(a, 0, 4, temp);
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(temp));

        int[] a = new int[]{11, 8, 3, 9, 7, 1, 2, 5};
        int[] tmp = new int[8];
        mergeSort(a, 0, 7, tmp);
        //第一次进入sortedArrayMerged2函数时，first=0, mid=0, last=1
        //第二次进入sortedArrayMerged2函数时，first=2, mid=2, last=3
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a, int first, int last, int[] temp) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(a, first, mid, temp);    //左边有序
            mergeSort(a, mid + 1, last, temp); //右边有序
            sortedArrayMerged2(a, first, mid, last, temp); //再将二个有序数列合并
        }
    }

    //合并两个有序数组2
    //将有二个有序数列a[first...mid]和a[mid+1...last]合并。
    //temp只是为了临时存放排序完成后的新数组，重要的还是要根据first-last角标更改原a[]
    public static void sortedArrayMerged2(int[] a, int first, int mid, int last, int[] temp) {
        int i = first, j = mid + 1;
        int k = 0;
        //同时遍历两个数组，合并有序数组
        while (i <= mid && j <= last) {
            if (a[i] < a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        //处理数组1已经到终点了，数组2余下的好多数据
        while (i <= mid)
            temp[k++] = a[i++];
        //同上
        while (j <= last)
            temp[k++] = a[j++];
        //接下来在把原a[]的对应数值替换
        for (i = 0; i < k; i++) {
            a[first++] = temp[i];
        }
    }

}
