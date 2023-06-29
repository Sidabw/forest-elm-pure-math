package com.brew.home.tmp.day230629;

import java.util.LinkedList;
import java.util.Queue;

import com.brew.home.geekbang.p3tree.binary.Node;

public class LeetCode98 {
    
    public static void main(String[] args) {
        System.out.println(11);
    }

    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if(tmp.left != null) {
                if(tmp.left.val >= tmp.val) {
                    return false;
                }
                queue.offer(tmp.left);    
            }
            if(tmp.right != null) {
                if(tmp.right.val <= tmp.val) {
                    return false;
                }
                queue.offer(tmp.right);
            }
        }
        return true;
    }
}

 class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

