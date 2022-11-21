package com.brew.home.tmp.day211204;


import java.util.Stack;

/**
 * @author shaogz
 */
public class LeetCode155 {

    public static void main(String[] args) {
        //最小栈 O(1) 时间内找到最小值
        //关键在于，使用一个辅助栈，该辅助栈的元素与原始栈的元素一一对应，表示当前元素对应的最小值
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        //      --> 返回 -3
        minStack.getMin();
        minStack.pop();
        //      --> 返回 0
        minStack.top();
        //      --> 返回 -2
        minStack.getMin();
    }

}

class MinStack2 {

    private final Stack<Integer> origin = new Stack<>();

    private final Stack<Integer> assist = new Stack<>();

    public void push(Integer element) {
        origin.push(element);
        if (assist.empty()) {
            assist.push(element);
            return;
        }
        //当前辅助栈 栈顶元素
        Integer assistStackTop = assist.peek();
        if (element < assistStackTop) {
            assist.push(element);
        } else {
            assist.push(assistStackTop);
        }
    }

    public Integer pop() {
        assist.pop();
        return origin.pop();
    }

    public Integer top() {
        return origin.peek();
    }

    public Integer getMin() {
        return assist.peek();
    }
}