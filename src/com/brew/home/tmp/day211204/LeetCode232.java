package com.brew.home.tmp.day211204;

import java.util.Stack;

/**
 * @author shaogz
 */
public class LeetCode232 {

    public static void main(String[] args) {
        //请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
        //注意，是要一个queue，而不是deque

    }

}

class MyqQueue {

    private final Stack<Integer> s1 = new Stack<>();
    private final Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s2.empty()) {
            //此时反转s1
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (s2.empty()) {
            //此时反转s1
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}
