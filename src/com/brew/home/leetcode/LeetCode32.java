package com.brew.home.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class LeetCode32 {

    public static void main(String[] args) {
        //!!! 没做出来。
        
        //32. 最长有效括号
        //给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
        //格式正确,指的是：有一个左便对应着一个右，对应的：((())) 这也叫格式正确

        //输入：s = "(()"
        //输出：2
        //解释：最长有效括号子串是 "()"

        //输入：s = ")()())"
        //输出：4
        //解释：最长有效括号子串是 "()()"

        //输入：s = ""
        //输出：0

        // == 2
        System.out.println(longestValidParentheses("(()"));
        // == 4
        System.out.println(longestValidParentheses(")()())"));
        // == 0
        System.out.println(longestValidParentheses(""));
        // == 6
        System.out.println(longestValidParentheses(")())))(())()(())"));
    }

    public static int longestValidParentheses(String s) {
        Deque<Character> stack = new LinkedList<>();
        int res = 0;
        int maxTmp = 0;
        int max = 0;
        for(int i = 0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    res = 0;
                    continue;
                } else{
                    stack.pop();
                    res+=2;
                    maxTmp = Math.max(res, maxTmp);

                    if(stack.isEmpty()) {
                        max = maxTmp;
                    }
                }
            }
        }
        return max;
    }

}