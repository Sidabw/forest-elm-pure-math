package com.brew.home.geekbang.sortAsearch.sort.s6radix;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class RadixSortDemo2 {

    public static void main(String[] args) {
        int[] arr = {151, 259, 360, 91, 115, 706, 34, 858, 2, 0};
        int num = arr.length;
        RadixSortDemo2 r1 = new RadixSortDemo2();
        System.out.println("Before sorting array elements are - ");
        System.out.println(Arrays.toString(arr));
        r1.radixSort(arr, num);
        System.out.println("After applying Radix sort, the array elements are -");
        System.out.println(Arrays.toString(arr));
    }


    void radixSort(int[] arr, int n) {
        int max = getMax(arr, n);
        /*
         * 根据底值(place value)多次执行计数排序
         * 具体来说：
         * 比如说321这个数，怎么第一次拿到1，第二次拿到2
         * 当然是第一次给个1，(321/1)%10 = 1
         * 第二次给个10，(321/10)%10 = 2
         * 第三次给个100，(321/100)%10 = 3
         */
        for (int place = 1; max / place > 0; place *= 10) {
            countingSort(arr, n, place);
        }
    }

    /**
     * 计数排序
     * @param arr 原始数组
     * @param n arr.len
     * @param place 底值（1、10、100、1000...）
     */
    void countingSort(int[] arr, int n, int place) {

        // Calculate count of elements
        //count数组，角标是原始数组的值(0~9)，value是出现的次数
        //(a[i] / place) % 10 即当前值，比如321第一次进来，那就是1
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(arr[i] / place) % 10]++;
        }

        // Calculate cumulative frequency
        //顺序求和
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Place the elements in sorted order
        //from CountingSort：最后一个元素3，在tmp[3]中，是7，即小于等于3的有7个，第7个元素对应的角标：6
        int[] sorted = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sorted[count[(arr[i] / place) % 10] - 1] = arr[i];
            count[(arr[i] / place) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = sorted[i];
        }
    }

    int getMax(int[] a, int n) {
        // get maximum element from the array
        int max = a[0];
        for(int i = 1; i<n; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

}
