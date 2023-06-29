package com.brew.home.tmp.day230629;

import static com.brew.home.geekbang.p1sortAsearch.sort.s5quick.QuickSort.swap;

import java.util.Arrays;

import com.brew.home.geekbang.p3tree.binary.b1.B1BinaryTreeInArr;

public class MaxHeapPractice {
    
    public static void main(String[] args) {
     //插入、删除、排序[建堆、排序]   

     MaxHeapPractice maxHeap = new MaxHeapPractice(7);
     maxHeap.insert(23);
     maxHeap.insert(6);
     maxHeap.insert(11);
     maxHeap.insert(4);
     maxHeap.insert(9);
     maxHeap.insert(40);
    
     System.out.print("原始顺序: ");
     B1BinaryTreeInArr.print(maxHeap.arr);
     System.out.println();
     System.out.println();

     maxHeap.del();
     System.out.print("删除堆顶元素后：");
     B1BinaryTreeInArr.print(maxHeap.arr);
     System.out.println();
     System.out.println();

     maxHeap.insert(12);
     System.out.print("重新插入元素12后：");
     B1BinaryTreeInArr.print(maxHeap.arr);
     System.out.println();
     System.out.println();

     maxHeap.sort();
     System.out.print("排序后：");
     System.out.println(Arrays.toString(maxHeap.arr));

    }

    private int lastLeafIndex;

    private final int[] arr;

    public MaxHeapPractice(int n) {
        // this.n = 1;
        this.lastLeafIndex = 1;
        this.arr = new int[n+1];
    }

    public void insert(int val) {
        arr[++lastLeafIndex] = val;
        int i = lastLeafIndex;
        //自下而上堆化
        while(i/2 > 0 && arr[i/2] < arr[i]) {
            swap(i, i/2, arr);
            i/=2;
        }
    }

    public void del() {
        //删除堆顶元素，自上而下堆化
        System.out.println("del " + arr[1]);
        arr[1] = arr[lastLeafIndex--];

        arr[lastLeafIndex+1] = -1;//临时填充下，打印的时候就知道这个删除了

        //自上而下，对[1, lastLeafIndex]进行堆化
        heapfy(1, lastLeafIndex);
    }

    public void sort() {
        //TODO 数组二叉树，打印

        //从最后一个非叶子节点(n/2)开始，从后往前遍历，自上而下堆化
        int n = lastLeafIndex;
        int i=n/2;
        while(i > 0) {
            heapfy(i--, n);
        }

        int k = lastLeafIndex;
        while(k > 0) {
            //1 和 n 互换
            //对[1, n-1]进行堆化
            swap(1, k--, arr);
            heapfy(1, k);
        }
    }

    private void heapfy(int start, int end) {
        int i = start;
        int toSwap = -1;
        while(true) {
            int left = i * 2;
            if(left <= end && arr[left] > arr[i]) {
                toSwap = left;
            }
            int right = i * 2 + 1;
            if(right <= end && arr[right] > arr[i]) {
                toSwap = right;
            }
            if(toSwap == -1) {
                System.out.println("[" + start + "," + end + "]" + "heapfy finished");
                return;
            }
            swap(i, toSwap, arr);
            i = toSwap;
            toSwap = -1;
        }
    }

}
