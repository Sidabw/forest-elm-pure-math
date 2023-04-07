package com.brew.home.leetcode.list;


import java.util.*;

import com.brew.home.geekbang.p1sortAsearch.sort.s5quick.QuickSortGeekBang;

public class LeetCode15 {

    public static void main(String[] args) {
        //三数之和：：https://leetcode.cn/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/

        //最笨的：三重for循环遍历所有元素,拿到所有3元组后再判重

        //改造一：先排序，后在3重for循环下使用双指针。

        //题意要的是三元组，每一项是具体的数组元素而不是原数组的下标
        //排序后可以更好的解决重复三元组的问题。
        //已找到了a0+b0+c0=0，再往下走时，如果b1=b0，那么b1就要跳过去，c也是一样。

        //双指针部分
        //已找到了a0+b0+c0=0，再往下走时，
        //下一个b1元素，因为b1>b0，所以如果存在c1使得a1+b1+c1=0的话，那么c1<c0
        //双重for循环，但是一重和二重并不是简单的并行关系，而是有"相互关系"此时考虑能否双指针

        System.out.println(1);


    }


    public static List<List<Integer>> threeSum(int[] nums) {
        new QuickSortGeekBang().quick(nums, 0, nums.length-1);
        //费尽心机处理重复元素，打一开始排完序再把重复元素删了不久行了

        LinkedList<Integer> numsSet = new LinkedList<>();
        for (int num : nums) {
            int lastEl;
            try {
                lastEl = numsSet.getLast();
            } catch (NoSuchElementException e) {

            }
            if (numsSet.getLast() != null && numsSet.getLast() == num) {
                continue;
            }
            numsSet.add(num);
        }

        
        



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

                Integer preCval = null;
                for(int c = for3Index; c > b; c--) {
                    if (preCval != null && nums[c] == preCval) {
                        continue;
                    }

                    if (nums[a] + nums[b] + nums[c] == 0) {
                        result.add(Arrays.asList(nums[a], nums[b], nums[c]));
                        preBval = nums[b];
                        preCval = nums[c];
                        break;
                    }


                }
            
                preBval = nums[b];
            }
        }

        return null;
    }
}
