package com.brew.home.tmp.day230626;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode151 {
    
    public static void main(String[] args) {
        //https://leetcode.cn/problems/reverse-words-in-a-string/


        //思路一：自己实现或者用现成的api
        //1、先split
        //2、将split[]进行reverse操作
        //3、对reverse[]进行join空格操作，结束

        //思路二：双端队列
        System.out.println(new LeetCode151().reverseWords("   a good   example   "));

    }

    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();
        
        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

}
