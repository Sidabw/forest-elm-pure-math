package com.brew.home.geekbang.sortAsearch.sort.s2quick;

import java.util.Arrays;

import static com.brew.home.geekbang.sortAsearch.sort.s2quick.QuickSort.swap;

/**
 * @author shaogz
 */
public class QuickSortGeekBang {

    public static void main(String[] args) {
        //测试分区代码，可比较着笔记看
        int[] arr = new int[]{6, 11, 3, 9, 8};
        int i = new QuickSortGeekBang().partition(arr, 0, 4);
        System.out.println(i);
        System.out.println(Arrays.toString(arr));

        //测试整体排序代码
        arr = new int[]{6, 11, 3, 9, 8};
        new QuickSortGeekBang().quick(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }

    void quick(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(arr, p, r);
        quick(arr, p, q - 1);
        quick(arr, q + 1, r);
    }

    int partition(int[] arr, int p, int r) {
        int i = p;
        int j = p;
        while(j < r) {
            if (arr[j] > arr[r]) {
                //比较 j 位置元素和 r 位置元素
                //大于  r 位置元素的不处理，i 保持不动，j 继续往前走
                j++;
            } else {
                //小于 r 位置元素的放到 i 的位置上（即arr[i] 和 arr[j] 互换），然后 i 往前走一步，j 也往前走一步
                swap(i, j, arr);
                j++;
                i++;
            }
        }
        swap(i, j , arr);
        return i;
    }

}
