package com.brew.home.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode70 {
    
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

    private static final Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
    }

    public  static int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n ==2) {
            return 2;
        } else {
            int x1;
            if ( map.containsKey(n - 1)) {
                x1 = map.get(n - 1);
            } else {
                x1 = climbStairs(n - 1);
                map.put(n - 1, x1);
            }

            int x2;
            if ( map.containsKey(n - 2)) {
                x2 = map.get(n - 2);
            } else {
                x2 = climbStairs(n - 2);
                map.put(n - 2, x2);
            }
            return x1 + x2;
        }
    }
}
