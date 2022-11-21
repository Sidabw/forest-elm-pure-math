package com.brew.home.tmp.day211130;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author shaogz
 */
public class LeetCode20 {

    public static void main(String[] args) {

        // String input = "()";
        // String input = "()[]{}";
        // String input = "(]";
        // String input = "([)]";
        // String input = "{[]}";
        // String input = "{[]}}";
        // String input = "{[";
        String input = "(){}}{";
        System.out.println(isValid(input));



    }

    public static boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        char[] chars = s.toCharArray();
        //长度不能为1，第一个字符不能是右括号, 必须为偶数
        if (s.length() == 1 || map.containsKey(chars[0]) || s.length() % 2 != 0) {
            return false;
        }


        Stack<Character> left = new Stack<>();
        left.push(chars[0]);

        for (int i = 1; i < chars.length; i++) {

            if (!map.containsKey(chars[i])) {
                //左括号
                left.push(chars[i]);
            } else {
                if (left.empty()) {
                    return false;
                }
                //右括号
                Character pop = left.pop();
                if (!map.get(chars[i]).equals(pop)) {
                    return false;
                }
            }
        }

        if (left.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
