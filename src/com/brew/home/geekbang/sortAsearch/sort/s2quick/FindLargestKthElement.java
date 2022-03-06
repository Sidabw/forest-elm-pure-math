package com.brew.home.geekbang.sortAsearch.sort.s2quick;

import static com.brew.home.geekbang.sortAsearch.sort.s2quick.QuickSort.swap;

/**
 * 找到第K大元素，利用快排思想
 *
 * @author shaogz
 */
public class FindLargestKthElement {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 3, 5, 7, 2, 4, 9, 11, 8};
        int largestK_index = new FindLargestKthElement().findLargestK(arr, 8);
        System.out.println(largestK_index);
    }

    int findLargestK(int[] arr, int k) {
        return find(arr, 0, arr.length -1, k);
    }

    int find(int[] arr, int p, int r, int k) {
        if (p >= r) {
            return -1;
        }
        //import static
        int pivot = partitionReverse(arr, p, r);
        if (pivot + 1 == k) {
            return pivot;
        } else if (pivot + 1 < k) {
            return find(arr, pivot + 1, r, k);
        } else {
            return find(arr, 0, pivot, k);
        }
    }

    int partitionReverse(int[] arr, int p, int r) {
        //相比于QuickSortGeekBang.partition，这里翻过来的，即从大到小排列
        int i = p;
        int j = p;
        while (j < r) {
            if (arr[j] < arr[r]) {
                j++;
            } else {
                swap(i, j, arr);
                i++;
                j++;
            }
        }
        swap(i, r, arr);
        return i;
    }

}
