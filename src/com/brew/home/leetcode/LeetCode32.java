package com.brew.home.leetcode;



/**
 *
 */
public class LeetCode32 {

    public static void main(String[] args) {
        //32. 最长有效括号
        //给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

        //输入：s = "(()"
        //输出：2
        //解释：最长有效括号子串是 "()"

        //输入：s = ")()())"
        //输出：4
        //解释：最长有效括号子串是 "()()"

        //输入：s = ""
        //输出：0
        System.out.println(longestValidParentheses("(()") == 2);
        System.out.println(longestValidParentheses(")()())") == 4);
        System.out.println(longestValidParentheses("") == 0);

        System.out.println(longestValidParentheses(")())))(())()(())") == 8);
    }

    public static int longestValidParentheses(String s) {

        int hit = 0;
        char[] a = s.toCharArray();
        for (int i = 0, j = 1; j < a.length; i++, j++) {
            char l = a[i];
            char r = a[j];

            if(l == '(' && r == ')') {
                //命中了就要往前挪两步
                i++;j++;
                hit++;
            }
        }
        return hit*2;
    }

}