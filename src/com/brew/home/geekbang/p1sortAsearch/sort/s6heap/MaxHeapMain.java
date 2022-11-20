package com.brew.home.geekbang.p1sortAsearch.sort.s6heap;

import java.util.Arrays;

/**
 * @author shaogz
 */
public class MaxHeapMain {

    public static void main(String[] args) {
        MaxHeapDemo maxHeap = new MaxHeapDemo(11);
        /*
        * part - 1: test insert & delete
        * 打印出来的数组在草稿纸上画了下，验证了下。
        * */
        maxHeap.insert(3);
        maxHeap.insert(6);
        maxHeap.insert(1);
        maxHeap.insert(10);
        maxHeap.insert(8);
        maxHeap.insert(22);
        maxHeap.insert(12);
        maxHeap.insert(19);
        maxHeap.insert(36);
        maxHeap.insert(76);
        maxHeap.insert(52);
        System.out.println(Arrays.toString(maxHeap.getArr()));

        maxHeap.del();
        System.out.println(Arrays.toString(maxHeap.getArr()));

        /*
        * part-2: test heap-sort
        * */
        MaxHeapDemo maxHeap2 = new MaxHeapDemo(10);
        int[] toS = new int[]{-1, 3, 6, 1, 10, 8, 22, 12, 19, 36, 76, 52};
        maxHeap2.sort(toS);
        System.out.println(Arrays.toString(toS));
    }
}
