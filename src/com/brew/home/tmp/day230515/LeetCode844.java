package com.brew.home.tmp.day230515;

import java.util.Stack;

public class LeetCode844 {
    
    public static void main(String[] args) {
        //true
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        //true
        System.out.println(backspaceCompare("ab##", "c#d#"));
        //true
        System.out.println(backspaceCompare("a##c", "#a#c"));
        //false
        System.out.println(backspaceCompare("a#c", "b"));
    }
    
    public static boolean backspaceCompare(String s, String t) {

        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();

        for (char cur : s.toCharArray()) {
            if (cur != '#') {
                s1.push(cur);
            } else if (s1.empty()){
                continue;
            } else {
                s1.pop();
            }
        }

        for (char cur : t.toCharArray()) {
            if (cur != '#') {
                t1.push(cur);
            } else if (t1.empty()){
                continue;
            } else {
                t1.pop();
            }
        }

        if(s1.size() != t1.size()) {
            return false;
        }
        while (!s1.empty()) {
            if (s1.pop() != t1.pop()) {
                return false;
            }
        }
        return true;
        
    }

}
