package com.brew.home.geekbang.p6algo4.divide_conquer;

import java.util.Arrays;

public class CalReversedOrderCount {
    
    public static void main(String[] args) {
        //求逆序对个数
        //跟归并排序几乎一样的代码，
        //因为本质上，求逆序对个数，就是一个数组拆两边，左右都各自有序，合并时计算右边比左边小的个数。所以跟归并一样。
        CalReversedOrderCount obj = new CalReversedOrderCount(new int[]{2, 4, 3, 1, 5, 6});
        System.out.println(obj.cal());
        System.out.println(Arrays.toString(obj.arr));
    }

    private final int[] arr;

    private final int[] tmp;
    private int count = 0;

    private CalReversedOrderCount(int[] arr) {
        this.arr = arr;
        this.tmp = new int[arr.length];
    }

    public int cal() {
        mergeSort(0, arr.length - 1);
        return count;
    }

    private void mergeSort(int first, int last){
        if(first>=last) {
            return;
        }
        int mid = (first + last)/2;
        mergeSort(first, mid);
        mergeSort(mid + 1, last);
        merge(first, mid, last);
    }

    private void merge(int first, int mid, int last) {
        int lStart = first, rStart = mid+1, tIndex = first;
        
        while(lStart <= mid && rStart <= last) {
            if(arr[lStart] < arr[rStart]) {
                tmp[tIndex++] = arr[lStart++];
            } else {
                tmp[tIndex++] = arr[rStart++];
                count+= (mid - lStart + 1);//发现逆序对, 注意不是count++
            }
        }

        while(lStart <= mid) {
            tmp[tIndex++] = arr[lStart++];
        }

        while(rStart <= last) {
            tmp[tIndex++] = arr[rStart++];
        }

        for(int i = first; i <= last; i++) {
            arr[i] = tmp[i];
        }
    }
}
