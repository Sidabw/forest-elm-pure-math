package com.brew.home.geekbang.sortAsearch.sort.s5courting;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author shaogz
 */
public class CourtingSort {

    public static void main(String[] args) {
        //步骤
        //1. 顺序遍历原始数组A[8], 得到存储A[8]内每个值的元素个数的数组C[6]；
        // C[6]的下标是A[8]的值，C[6]的值是A[8]内每个值的元素个数
        //2. 对C[5] 顺序求和
        //3. 倒序遍历A[8], 逐个拿到当前元素在c[5]中的值，即小于等于当前元素的个数，进而得到当前元素在有序数组中的位置
        int[] sorted = new CourtingSort().courtingSort(new int[] {2, 5, 3, 0, 2, 3, 0, 3}, 5);
        System.out.println(Arrays.toString(sorted));
    }

    /**
     *
     * @param origin 原始数组
     * @param max 原始数组最大的那个数
     * @return sorted arr
     */
    int[] courtingSort(int[] origin, int max) {
        //得到：C[6]：   2,0,2,3,0,1
        //意思是，值为0的元素有2个，1的有0个，2的有2个，3的有3个，4的有0个，5的有1个
        int[] tmp = new int[max + 1];
        for (int i = 0; i< origin.length; i++) {
            tmp[origin[i]]++;
        }
        //顺序求和，得到：2,2,4,7,7,8
        //意思是，小于等于0的有2个，小于等于1的有2个，小于等于2的有4个,小于等于3的有7个...
        for (int i = 1; i < tmp.length; i++) {
            tmp[i] = tmp[i] + tmp[i - 1];
        }

        //倒序遍历origin
        //最后一个元素3，在tmp[3]中，是7，即小于等于3的有7个，对应有序数组的位置应该是7-1=6
        int[] sorted = new int[origin.length];
        for (int i = origin.length - 1 ; i>=0; i--) {
            int index = tmp[origin[i]] - 1;
            sorted[index] = origin[i];
            tmp[origin[i]]--;
        }
        //倒叙遍历是为了保证计数排序的"稳定性"
        return sorted;
    }
}
