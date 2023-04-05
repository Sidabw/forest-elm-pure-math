package com.brew.home.geekbang.p1sortAsearch.sort.s5quick;

import java.util.Arrays;

import static com.brew.home.geekbang.p1sortAsearch.sort.s5quick.QuickSort.swap;

/**
 * @author shaogz
 */
public class QuickSortGeekBang {

    public static void main(String[] args) {
        //测试整体排序代码
        int[] arr = new int[]{6, 11, 3, 9, 8};
        new QuickSortGeekBang().quick(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }

    public void quick(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(arr, p, r);
        quick(arr, p, q - 1);
        quick(arr, q + 1, r);
    }

    /**
     * <p> 1. 两个指针i、j，一个pivot默认就是 r 指针元素
     * <p> 2. j指针元素和r指针元素比较，j大的那j就往前走
     * <p> 3. j小的，交换i 和 j，此时j和i都往前走
     * <p> 4. 最后交换i和r
     * @param arr 原始数组
     * @param p left
     * @param r right
     * @return pivot
     */
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
