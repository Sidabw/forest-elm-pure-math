/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode232
 * Author:   feiyi
 * Date:     2020/5/28 11:52 AM
 * Description: 用栈实现队列
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.leetcode.limited_linear_list;

import java.util.Stack;

/**
 * 〈一句话功能简述〉:
 * 〈用栈实现队列〉
 *
 * @author feiyi
 * @create 2020/5/28
 * @since 1.0.0
 */
public class LeetCode232 {

    //半个小时。。  而且还是看了答案又写的情况。。
    public static void main(String[] args){
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        assert queue.peek() == 1;
        boolean popped = queue.pop() == 1;
        assert popped;
        assert !queue.empty();
    }

}

class MyQueue {

    private final Stack<Integer> s1 = new Stack<>();
    private final Stack<Integer> s2 = new Stack<>();
    int front = 0;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (s1.empty()) front = x;
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    //出队的时候又发生了push没关系，就push到s1里就可以了，只要在s2空了的情况下再去反转s1就ok。
    public int pop() {
        if (s2.empty()) {
            //反转s1，写入s2
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /**
     * Get the front element.
     * <p> 感觉这个字段没必要吧，类似pop的操作即可
     */
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        System.out.println("is empty?");
        return s2.empty() && s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


class MyStack {

    int[] content = new int[8];

    int index = -1;

    public void push(int val) {
        index++;
        content[index] = val;
    }

    public int top() {
        return content[index];
    }

    public int pop() {
        return content[index--];
    }

    public boolean empty() {
        return index < 0;
    }

}