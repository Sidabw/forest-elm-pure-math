package com.brew.home.leetcode.list;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.brew.home.geekbang.p1sortAsearch.sort.s5quick.QuickSortGeekBang;

public class LeetCode15 {

    public static void main(String[] args) {
        //最笨的：三重for循环遍历所有元素,拿到所有3元组后再判重

        //改造一：先排序，后在3重for循环下使用双指针。
        //a + b + c = 0
        //下一个b1元素，因为b1>b，所以如果存在c1使得a+b1+c1=0的话，那么c1<c
        //双指针：双重for循环，但是一重和二重并不是简单的并行关系，而是有"相互关系"此时考虑能否双指针

        System.out.println(1);


    }


    public static List<List<Integer>> threeSum(int[] nums) {
        new QuickSortGeekBang().quick(nums, 0, nums.length-1);

        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        for (int a = 0; a < nums.length - 2; a++) {

            Integer preBval = null;
            for(int b = 1; b < nums.length - 1; b++) {
                if (preBval != null && preBval == nums[b]) {
                    continue;
                }

                
                int for3Index;
                if(!result.isEmpty()) {
                    Integer c0 = result.getLast().get(2);
                    for3Index = c0;
                } else {
                    for3Index = nums.length - 1;
                }

                for(int c = for3Index; c > b; c--) {

                    if (nums[a] + nums[b] + nums[c] == 0) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[c]));
                        break;
                    }


                }
            
                preBval = nums[b];
            }
        }

        return null;
    }
}
