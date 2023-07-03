package com.brew.home.tmp.day230630;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode98 {
    
    public static void main(String[] args) {
        TreeNode r = TreeNode.build1();
        System.out.println(new LeetCode98().isValidBST(r));
        System.out.println(new LeetCode98().isValidBST2(r));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        System.out.println("cur " + node.val + " lower " + lower + " upper " + upper);
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public boolean isValidBST2(TreeNode root) {
        return postR(root);
    }

    Queue<Integer> oneElQueue = new LinkedList<>();
    private boolean postR(TreeNode node) {
        if(node == null) {
            return true;
        }

        boolean res1 = postR(node.left);
        if(!res1) {
            return res1;
        }

        if(oneElQueue.isEmpty() || oneElQueue.poll() < node.val) {
            oneElQueue.offer(node.val);
        } else {
            return false;
        }

        boolean res2 = postR(node.right);
        if(!res2) {
            return res2;
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

    public static TreeNode build1() {
                /* 
        5
     1     6
          3  7
        */ 

        TreeNode root = new TreeNode(5);
        TreeNode left1 = new TreeNode(1);
        TreeNode right1 = new TreeNode(6);
        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(3);
        TreeNode right2 = new TreeNode(7);
        right1.left = left2;
        right1.right = right2;

        return root;
    }
}
