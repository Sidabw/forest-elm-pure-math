package com.brew.home.tmp.day230625;

public class LeetCode344 {
    
    public static void main(String[] args) {
        //https://leetcode.cn/problems/reverse-string/


    }

    public static void reverseString(char[] s) {
        //没什么好玩的解法，就是最笨的双指针就可以了
        for(int i = 0, j = s.length-1; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }

    }
}
