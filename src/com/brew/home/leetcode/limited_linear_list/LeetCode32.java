package com.brew.home.leetcode.limited_linear_list;

import java.util.Deque;
import java.util.LinkedList;

/**
 *
 */
public class LeetCode32 {

    public static void main(String[] args) {
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
        // == 10
        System.out.println(longestValidParentheses(")())))(())()(())"));
    }

    public static int longestValidParentheses(String s) {
        //两个地方可能必要疑惑，一个是为什么要push(-1)，另外一个是Math.max怎么还能拿下标左比较
        //关键在于，我们要保证：栈底元素为：最后一个没有被匹配的右括号的下标
        //")))()"拿这个例子，看一下，走到0下标时max和stack的值，走到1时...走到4时，最后看到4-2时，就明白上面那句话什么意思了。
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

}