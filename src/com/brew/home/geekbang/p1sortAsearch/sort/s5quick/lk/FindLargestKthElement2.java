package com.brew.home.geekbang.p1sortAsearch.sort.s5quick.lk;

import java.util.Random;

/**
 * 找到第K大元素，利用快排思想
 *
 * @author shaogz
 */
public class FindLargestKthElement2 {

    public static void main(String[] args) {
        //leet-code 215 官方解释
        //与第一个的不同，
        //1. 标准快排，所以kthLargest 只能 nums.len - k
        //2. 使用随机数，来实现真正的O(n). 防止，每次分成1 n-1 然后又向n-1查询...
        int[] arr = new int[]{6, 1, 3, 5, 7, 2, 4, 9, 11, 8};
        int largestK_index = new FindLargestKthElement2().findKthLargest(arr, 2);
        System.out.println(largestK_index);
    }

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else if(q < index){
            return quickSelect(a, q + 1, r, index);
        } else {
            return quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        //小的在左，大的在右
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
