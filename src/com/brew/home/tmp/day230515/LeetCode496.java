package com.brew.home.tmp.day230515;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode496 {
    
    public static void main(String[] args) {
        // int[] num1 = new int[]{4, 1, 2};
        // int[] num2 = new int[]{1, 3, 4, 2};

        int[] num1 = new int[]{2, 4};
        int[] num2 = new int[]{1, 2, 3, 4};

        int[] result2 = findFirstBiggerEl2(num1, num2);
        System.out.println(Arrays.toString(result2));
    }

    private static int[] findFirstBiggerEl2(int[] nums1, int[] nums2) {
        //哈希表+单调栈(有序的栈。这里是栈顶为最小。)

        //哈希表：当前值map右侧第一个比自己大的值
        //单调栈：记录当前值右侧第一个比自己大的值

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        //问题解决不了时，想想倒叙遍历
        for(int i = nums2.length - 1; i >=0 ; i--) {
            int cur = nums2[i];
            while (!stack.empty() && cur > stack.peek()) {
                stack.pop();
            }

            map.put(cur, stack.empty() ? -1 : stack.peek());
            stack.push(cur);
        }

        int[] res = new int[nums1.length];
        for (int i = 0 ; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
