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

        // int[] nums = new int[]{0,0,0};
        // int[] nums = new int[]{0,1,1};
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        // int[] nums = new int[]{-1,-1,-1,-2,-2,1,0,0,1,3,3,3,5};
        // int[] nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        // int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(nums));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        new QuickSortGeekBang().quick(nums, 0, nums.length-1);
        if(nums.length<3) {
            return Collections.emptyList();
        }

        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for (int a = 0; a < nums.length - 2; a++) {
            int for3Index = nums.length-1;    
            for(int b = a+1; b < nums.length - 1; b++) {

                for(int c = for3Index; c > b; c--) {

                    //找到命中了
                    if (nums[a] + nums[b] + nums[c] == 0) {

                        //过滤掉重复的
                        boolean repeated = false;
                        if(!result.isEmpty()) {
                            for(int d = result.size()-1; d >=0 ;d--) {
                                if(result.get(d).get(0) != nums[a]) {
                                    break;
                                }

                                if(result.get(d).get(1) == nums[b] && result.get(d).get(2) == nums[c]) {
                                    repeated = true;
                                }
                            }
                        }
                        if(repeated) {
                            continue;
                        }
                        
                        //没有重复的，yes!!!
                        result.add(Arrays.asList(nums[a], nums[b], nums[c]));
                        for3Index = c;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
