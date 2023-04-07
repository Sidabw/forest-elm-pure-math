package com.brew.home.leetcode.list;


import java.util.*;


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
        System.out.println(new LeetCode15().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            //sidabw批注：在一个固定的a下，原来代码是已经便利了所有可能的b和c了。
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                //sidabw批注：已确定的a和b下，只会有一个c
                //nums[second] + nums[third] + nums[first] > 0
                //因为nums[third]一开始是最大的，然后一直变小变小直到贴近命中值0
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    
}

