package com.brew.home.tmp.day211205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author shaogz
 */
public class LeetCode496 {

    /**
     * 496,  下一个更大元素
     * @param args 🤓
     * 
     * @author shaogz
     *  2021/12/5 11:50 AM
     **/
    public static void main(String[] args) {
        // int[] num1 = new int[]{4, 1, 2};
        // int[] num2 = new int[]{1, 3, 4, 2};

        int[] num1 = new int[]{2, 4};
        int[] num2 = new int[]{1, 2, 3, 4};

        //O(mn)解法
        int[] result = findFirstBiggerEl(num1, num2);
        System.out.println(Arrays.toString(result));

        int[] result2 = findFirstBiggerEl2(num1, num2);
        System.out.println(Arrays.toString(result2));

    }

    /**
     * <p>使用单调栈+哈希表来解决。
     * <p>从后往前遍历nums2，找到当前元素右边第一个比自己大的，放到栈顶，并存储在哈希表中
     * <p>单调栈，降序排序，边构建边用
     * @param nums1 子集
     * @param nums2 全集
     * @return int[] 
     * @author shaogz
     *  2021/12/5 1:31 PM
     **/
    private static int[] findFirstBiggerEl2(int[] nums1, int[] nums2) {
        Stack<Integer> stackAsc = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1 ; i>=0; i--) {
            int curValue = nums2[i];
            while (!stackAsc.isEmpty() && curValue > stackAsc.peek()) {
                stackAsc.pop();
            }
            map.put(curValue, stackAsc.isEmpty() ? -1 : stackAsc.peek());
            stackAsc.push(curValue);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    private static int[] findFirstBiggerEl(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            int curInN2 = nums2[i];
            int n1Index = -1;
            for (int j = 0; j < nums1.length; j++) {
                if (curInN2 == nums1[j]) {
                    n1Index = j;
                }
            }
            if (n1Index == -1) {
                continue;
            }
            int n1IndexValue = -1;
            for (int x = i; x < nums2.length; x++) {
                if (nums2[x] > curInN2) {
                    n1IndexValue = nums2[x];
                    break;
                }
            }
            result[n1Index] = n1IndexValue;
        }
        return result;
    }
}
