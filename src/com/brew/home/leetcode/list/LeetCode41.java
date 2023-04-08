package com.brew.home.leetcode.list;

public class LeetCode41 {

    public static void main(String[] args) {
        //原题：https://leetcode.cn/problems/first-missing-positive/

        //题解：
        //好好理解这句话：对于一个长度为N的数组，其中没有出现的最小正整数只能在 [1,N+1] 中
        //n即nums.len
        //剩下就是如何利用哈希表的思想，用负数做标记。

        int[] nums = new int[]{1,2,0};
        System.out.println(new LeetCode41().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

    int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
/*
┌──┬──┐xx┌──┬──┬──┬──┬─┬─┬──┐
│  │  │xx│  │  │  │  │3│ │  │
└──┴──┘xx└──┴──┴──┴──┴─┴─┴──┘
 0  1  2                
*/
        //如上，数组里有一个元素值为3，那么就把2号下标的元素标记为负数
        //可以理解为记录了一个元素->下标的关系
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        //同上，把上面的关系反过来，找到结果元素。
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        //返回右侧的第一个
        return n + 1;

    }
}
