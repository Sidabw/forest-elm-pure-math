package com.brew.home.tmp.day230629;

import java.util.LinkedList;
import java.util.Queue;

import com.brew.home.geekbang.p3tree.binary.Node;

public class LeetCode98 {
    
    public static void main(String[] args) {
        System.out.println(11);
    }

    public boolean isValidBST(Node root) {
        //逐层遍历的解法是错误的
        //以下要返回false,但是逐层遍历会返回true
        //看清题目
        /* 
        5
     1     6
          3  7
        */ 
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            if(tmp.left != null) {
                if(tmp.left.value >= tmp.value) {
                    return false;
                }
                queue.offer(tmp.left);    
            }
            if(tmp.right != null) {
                if(tmp.right.value <= tmp.value) {
                    return false;
                }
                queue.offer(tmp.right);
            }
        }
        return true;
    }
}

