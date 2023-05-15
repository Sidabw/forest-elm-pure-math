package com.brew.home.tmp.day230515;

import java.util.Stack;

public class LeetCode232 {
    
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        //true
        System.out.println(queue.peek() == 1);
        //true
        System.out.println(queue.pop() == 1);
        //false
        System.out.println(queue.empty());
    }
}

class MyQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MyQueue() {

    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        reversalIfNecessary();
        return s2.pop();
    }
    
    public int peek() {
        reversalIfNecessary();
        return s2.peek();
    }
    
    public boolean empty() {
        return s2.empty() && s1.empty();
    }

    private void reversalIfNecessary(){
        //反转
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
        }
    }
}
