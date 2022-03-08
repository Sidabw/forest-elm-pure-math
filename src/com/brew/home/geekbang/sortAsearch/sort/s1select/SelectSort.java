package com.brew.home.geekbang.sortAsearch.sort.s1select;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class SelectSort {

    public static void main(String[] args) throws Exception {
        int[] arr = {5, 2, 1, 6, 7, 10, 8};
        System.out.println(Arrays.toString(new SelectSort().sort(arr)));
    }

    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
        return arr;
    }
}
