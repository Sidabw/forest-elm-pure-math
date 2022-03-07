/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: HeapDemo
 * Author:   feiyi
 * Date:     2020/11/3 11:06 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.geekbang.heap;



/**
 * 〈一句话功能简述〉:
 * 〈以下都是基于大顶堆。〉
 *
 * @author feiyi
 * @create 2020/11/3
 * @since 1.0.0
 */
public class HeapDemo {

    /**
     * 从下标为1开始存储数据
     */
    private int[] data;
    /**
     * 已经存储的数据的个数，对应count++;data[count] = val;
     */
    private int count;
    /**
     * 堆的容量。保证堆满了就不插了，对应if (count>=n) return;
     */
    private int n;
    public HeapDemo(int capacity) {
        data = new int[capacity + 1];
        n = capacity;
    }

    /**
     * 往堆中插入数据
     * @param val val
     */
    public void insert(int val) {
        if (count>=n) return;
        count++;
        data[count] = val;
        int i = count;
        //自下而上重构堆
        while (i/2 > 0 && data[i] > data[i/2]) {
            swap(data, i, i/2);
            i = i/2;
        }
    }

    /**
     * 删除堆顶元素
     */
    private void removeMax() {
        if (count == 0) return;
        //对应图中的"把第一个数据和最后一个数据交换位置，再把最后一个数据删掉"
        data[1] = data[count];
        count--;
        //开始重构堆
        heapify();
    }

    private void heapify() {
        int i = 1;
        while (true) {
            int maxPos = i;
            if (i*2 <= n && data[i] < data[i*2]) maxPos = i*2;
            if (i*2+1 <= n && data[maxPos] < data[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            swap(data, i, maxPos);
            i = maxPos;
        }

    }

    private void swap(int[] data, int i, int i1) {
        int tmp = data[i];
        data[i] = data[i1];
        data[i1] = tmp;
    }
}