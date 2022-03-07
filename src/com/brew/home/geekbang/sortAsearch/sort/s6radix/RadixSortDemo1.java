package com.brew.home.geekbang.sortAsearch.sort.s6radix;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class RadixSortDemo1 {

    public static void main(String[] args) {
        /*
        * 这个代码没看懂，mod每次都要*10，
        * 但是counter的定义是： int[][] counter = new int[mod * 2][0];
        * 说好的多次计数排序呢？
        * from：https://www.runoob.com/w3cnote/radix-sort.html
        * */
        int[] arr = {321, 6, 12, 53, 46};
        System.out.println(Arrays.toString(radixSort(arr, 3)));
    }

    private static int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            //这里的0是初始化，后面arrayAppend会往里追加(new int[])
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr arr
     * @param value value
     */
    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
