package com.brew.home.leetcode.limited_linear_list;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode150 {
    
    public static void main(String[] args) {
        //有关什么是‘逆波兰表达法’和示例输入输出，参考原题地址：
        //https://leetcode.cn/problems/evaluate-reverse-polish-notation/

        //9
        System.out.println(new LeetCode150().evalRPN(new String[]{"2","1","+","3","*"}));
        //6
        System.out.println(new LeetCode150().evalRPN(new String[]{"4","13","5","/","+"}));
        //22
        System.out.println(new LeetCode150().evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
        
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String each : tokens) {
            int p3;
            if ("+".equals(each)) {
                p3 = stack.pop() + stack.pop();
            } else if ("-".equals(each)) {
                int p1 = stack.pop();
                int p2 = stack.pop();
                p3 = p2 - p1;
            } else if ("/".equals(each)) {
                int p1 = stack.pop();
                int p2 = stack.pop();
                p3 = p2 / p1;
            } else if ("*".equals(each)) {
                p3 = stack.pop() * stack.pop();
            } else {
                p3 = Integer.parseInt(each);
            }
            stack.push(p3);
        }
        return stack.pop();
    }


}
