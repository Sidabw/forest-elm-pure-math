package com.brew.home.tmp.day230703;

import com.brew.home.tmp.common.TreeNode;

public class LeetCode226 {
    
    public static void main(String[] args) {
        //反转二叉树
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }

        //从子节点开始反转
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
}
