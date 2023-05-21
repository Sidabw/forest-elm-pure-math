package com.brew.home.leetcode.limited_linear_list.queue;

public class LeetCode641_2 {
    

    public static void main(String[] args) {
        //写在前面，下面这个代码是错的，没有通过leetcode上的所有测试用例
        //‘循环’双端队列，geekbang上的课程并没有学会
        //下次再学吧...

        //
        /*
         *  true
            true
            true
            true
            true
            true
            true
            true
            5
            6
        */
        // MyCircularDeque2 circularDeque = new MyCircularDeque2(5);
        // System.out.println(circularDeque.insertFront(1));
        // System.out.println(circularDeque.insertLast(2));
        // System.out.println(circularDeque.insertFront(3));
        // System.out.println(circularDeque.insertLast(4));
        // System.out.println(circularDeque.deleteFront());
        // System.out.println(circularDeque.deleteFront());
        // System.out.println(circularDeque.insertLast(5));
        // System.out.println(circularDeque.insertFront(6));
        // System.out.println(circularDeque.getRear());
        // System.out.println(circularDeque.getFront());


        MyCircularDeque2 circularDeque = new MyCircularDeque2(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));			        // 返回 true
        System.out.println(circularDeque.insertLast(2));			        // 返回 true
        System.out.println(circularDeque.insertFront(3));			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
        System.out.println(circularDeque.getRear());  				// 返回 2
        System.out.println(circularDeque.isFull());			        // 返回 true
        System.out.println(circularDeque.deleteLast());			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 返回 true
        System.out.println(circularDeque.getFront());				// 返回 4

    }

    
}


class MyCircularDeque2 {

    private int[] origins;

    private int head = 0;

    private int tail = 0;

    //此时队列内元素数量
    private int size = 0;

    //构造函数,双端队列最大为 k 
    public MyCircularDeque2(int k) {
        origins = new int[k];
    }
    
    //将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        int i;
        if(isEmpty()) {
            i = head;
        } else {
            i = --head>=0 ? head : origins.length - 1;
        }
        origins[i] = value;
        head = i;
        size++;
        return true;
    }
    
    //将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        int i;
        if(isEmpty()) {
            i = tail;
        } else {
            i = ++tail < origins.length ? tail : 0;
        }
        origins[i] = value;
        tail = i;
        size++;
        return true;
    }
    
    //从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }

        head = head + 1 >= origins.length ? 0 : head + 1;
        size--;
        return true;    
    }
    
    //从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }

        tail = tail - 1 < 0 ? origins.length - 1 : tail - 1;
        size--;
        return true;    
    }
    
    //从双端队列头部获得一个元素。如果双端队列为空，返回 -1 
    public int getFront() {
        if(isEmpty()) {
            return -1;
        } else {
            return origins[head];
        }
    }
    
    //获得双端队列的最后一个元素。 如果双端队列为空，返回 -1
    public int getRear() {
        if(isEmpty()) {
            return -1;
        } else {
            return origins[tail];
        }
    }
    
    //若双端队列为空，则返回 true ，否则返回 false
    public boolean isEmpty() {
        return size == 0;
    }
    
    //若双端队列满了，则返回 true ，否则返回 false
    public boolean isFull() {
        return size == origins.length;
    }
}
