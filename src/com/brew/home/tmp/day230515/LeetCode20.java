package com.brew.home.tmp.day230515;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode20 {
    
    public static void main(String[] args) {
    
        //true
        System.out.println(isValid2("{[]}"));
        // true
        System.out.println(isValid2("([][]){{}}"));
        // false
        System.out.println(isValid2("(((([]))}]"));
        // true
        System.out.println(isValid2("()[]{}"));
        // false
        System.out.println(isValid2("(]"));
        // false
        System.out.println(isValid2("}[)]"));
        //false，正确的顺序！！！
        System.out.println(isValid2("([)]"));

    }

    private static boolean isValid2(String str) {
        if (str == null || str.length()==0) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();
        char[] left = new char[]{'{','[', '('};
        char[] right = new char[]{'}',']', ')'};
        char[] charArray = str.toCharArray();
      for (char cur : charArray) {
        boolean inRight = false;
        int indexInRight = -1;
        for(int i = 0; i<right.length;i++) {
            if(right[i] == cur) {
                inRight = true;
                indexInRight = i;
            }
        }
        //左边的
        if(!inRight) {
            stack.push(cur);
            continue;
        }
        //右边的
        if (stack.isEmpty()) {
            return false;
        }
        if (stack.pop() != left[indexInRight]) {
            return false;
        }
      }

        return stack.isEmpty();
    }


}
