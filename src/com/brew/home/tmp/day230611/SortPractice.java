package com.brew.home.tmp.day230611;

import static com.brew.home.geekbang.p1sortAsearch.sort.s5quick.QuickSort.swap;

import java.util.Arrays;

public class SortPractice {
    

    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 6, 7, 10, 8};
        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(selectSort(arr)));
        System.out.println(Arrays.toString(insertSort(arr)));
        System.out.println(Arrays.toString(shellSort(arr)));
    }

    private static int[] bubbleSort(int[] arr) {
        arr = Arrays.copyOf(arr, arr.length);
        for(int i = 0; i < arr.length; i++) {

            boolean compareFlag = false;
            //每次挑选一个最大的放到‘最右边’
            for(int j = 0; j < arr.length - 1 - i; j++) {
                
                if(arr[j] > arr[j+1]) {
                    swap(j,j+1,arr);
                    compareFlag = true;
                }
                
            }

            if(!compareFlag) {
                return arr;
            }
        }
        return arr;
    }

    private static int[] selectSort(int[] arr) {
        arr = Arrays.copyOf(arr, arr.length);
        for(int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                swap(i, minIndex, arr);
            }

        }
        return arr;
    }

    private static int[] insertSort(int[] arr) {
        arr = Arrays.copyOf(arr, arr.length);

        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i -1;
            for (; j>=0; j--) {
                if(arr[j] > value) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }
        return arr;
    }

    private static int[] shellSort(int[] arr) {
        arr = Arrays.copyOf(arr, arr.length);
        
        for (int gap = arr.length/2 ; gap >0; gap/=2) {
            for(int i = gap; i < arr.length; i++) {
                int j = i;
                while(j-gap>=0 && arr[j] < arr[j-gap]) {
                    swap(j, j-gap, arr);
                    j-=gap;
                }
            }
        }

        return arr;
    }
}
