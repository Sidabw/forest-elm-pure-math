package com.brew.home.geekbang.p1sortAsearch.sort.s6heap;

import static com.brew.home.geekbang.p1sortAsearch.sort.s5quick.QuickSort.swap;

/**
 * 大顶堆
 * @author shaogz
 */
public class MaxHeapDemo {

    /**
     * 原始数据。从1开始。
     */
    private int[] arr;
    /**
     * 总共能存储数据的个数。
     * 插入数据时判断是否：扩容 or 结束。
     * 如果说的是已经创建好的堆，这个n就是最后一个元素的角标
     */
    private int n;

    /**
     * 最后一个叶子节点的角标
     */
    private int lastLeafIndex;

    /**
     * 构建一个大顶堆
     * @param capacity capacity
     */
    public MaxHeapDemo(int capacity) {
        this.arr = new int[capacity + 1];
        this.n = capacity;
        this.lastLeafIndex = 0;
    }

    /**
     * 插入元素
     * @param val val
     */
    public void insert(int val) {
        if (++lastLeafIndex > n) {
            System.out.println("time to Capacity expansion");
            return;
        }
        //先放到最后一个叶子节点上，
        arr[lastLeafIndex] = val;
        //再开始向上堆化
        int i = lastLeafIndex;
        while (i/2 > 0 && arr[i] > arr[i/2]) {
            swap(i, i/2, arr);
            i = i/2;
        }
    }

    /**
     * 删除大顶堆的...大顶
     */
    public void del() {
        System.out.println(arr[1] + " del..");
        arr[1] = arr[lastLeafIndex--];
        //开始堆化
        heapify(1, --n);
    }

    public int[] getArr() {
        return this.arr;
    }

    public void sort(int[] arr) {
        this.arr = arr;
        //因为这里的实现都是0角标是空着的
        this.n = arr.length - 1;
        buildHeap();

        int k = n;
        while (k > 1) {
            swap( 1, k--, arr);
            heapify(1, k);
        }
    }

    /**
     * 从最后一个非叶子节点(n/2)，从后往前，自上而下建堆。
     */
    private void buildHeap() {
        for (int i = n/2; i >= 1; --i) {
            heapify(i, n);
        }
    }

    /**
     * 对start角标元素 到 end 角标元素堆化
     * @param start node-index-start
     * @param end node-index-end
     */
    private void heapify(int start, int end) {
        int i = start;
        while (true) {
            int toSwap = i;
            if ((2 * i) <= end && arr[i] < arr[2 * i]) {
                toSwap = 2 * i;
            }
            if ((2 * i + 1) <= end && arr[toSwap] < arr[2 * i + 1]) {
                toSwap = 2 * i + 1;
            }
            if (i == toSwap) {
                break;
            }
            swap(i, toSwap, arr);
            i = toSwap;
        }
    }
}

