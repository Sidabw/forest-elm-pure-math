package com.brew.home.tmp.day230515;

import java.util.Stack;

public class LeetCode155 {
    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());     //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.    
    }

}

class MinStack {
    private Stack<Integer> origin = new Stack<>();
    private Stack<Integer> assist = new Stack<>();

    public MinStack() {
    }
    
    public void push(int val) {
        if(origin.isEmpty()) {
            origin.push(val);
            assist.push(val);
            return;
        }

        origin.push(val);
        int curMin = assist.peek();
        if (val < curMin) {
            assist.push(val);
        } else {
            //这就叫一一对应
            assist.push(curMin);
        }
    }
    
    public void pop() {
        origin.pop();
        assist.pop();
    }
    
    public int top() {
        return origin.peek();
    }
    
    public int getMin() {
        return assist.peek();
    }
}
