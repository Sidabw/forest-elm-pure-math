package com.brew.home.geekbang.sortAsearch.sort.s3shell;

import java.util.Arrays;

import static com.brew.home.geekbang.sortAsearch.sort.s5quick.QuickSort.swap;

/**
 * 希尔排序
 * https://www.cnblogs.com/chengxiao/p/6104371.html
 * https://www.runoob.com/w3cnote_genre/algorithm
 * https://www.geeksforgeeks.org/shellsort/
 * @author shaogz
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 7, 9, 8, 3, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     * @param arr arr
     */
    public static void sort(int []arr){
        //增量gap，并逐步缩小增量. gap：4 -> 2 -> 1 -> 0 结束
        for(int gap=arr.length/2; gap>0; gap/=2){
            /*
             * 从第gap个元素，逐个对其所在组进行直接插入排序操作
             * 虽然从希尔排序的理解上来说，我们是按照组处理的，但在代码实现上，实际上上是组与组交叉着来的(i++)
             * 但是，比较肯定还是组内比较(arr[j]<arr[j-gap], j++)
             * while 循环 和 j-=gap 是存粹的操作一个组的数据，
             * 即在一个组内通过比较、交换，保证小的在左边（往回比，把未排序序列 插入到 已排序序列中）【插入排序】
             */
            for(int i=gap; i<arr.length; i++){
                /*
                * j 是当前元素
                * j - p 是与j 比较的元素
                * */
                int j = i;
                while(j-gap>=0 && arr[j]<arr[j-gap]){
                    //插入排序采用交换法
                    swap(j,j-gap, arr);
                    j-=gap;
                }
            }
        }
    }


}
