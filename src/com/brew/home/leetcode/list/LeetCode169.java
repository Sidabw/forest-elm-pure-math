package com.brew.home.leetcode.list;

import java.util.HashMap;

public class LeetCode169 {
    
    public static void main(String[] args) {
        //https://leetcode.cn/problems/majority-element/

        //方法一：随机数。每次取一个随机数然后遍历原数组看该数出现的次数是否大于n/2。
        //最坏情况下的时间复杂度为 O(∞)，期望的时间复杂度为 O(n)

        //方法二：排序，然后取n/2下标的元素直接返回。对，直接返回

        //方法三：用hash表，然后打擂台,代码如下

        //方法四：摩尔投票法。思路是既然一定有一个众数并多于n/2，那能不能让这个数和其他数两两相抵，最后剩下的肯定就是哪个众数

        // int[] nums = new int[]{2,2,1,1,1,2,2};
        int[] nums = new int[]{3,2,3};
        System.out.println(new LeetCode169().majorityElement(nums));

    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        int max = -1;
        int maxVal = -1;
        for(int num: nums) {
            Integer val = hashMap.get(num);
            if (val == null) {
                val = 1;
            } else {
                val++;
            }
            hashMap.put(num, val);


            if (val > maxVal) {
                maxVal = val;
                max = num;
            }
            if (val > nums.length/2) {
                return max;
            }
        }
        return max;
    }
}
