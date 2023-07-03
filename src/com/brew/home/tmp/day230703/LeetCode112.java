package com.brew.home.tmp.day230703;

import com.brew.home.tmp.common.TreeNode;

public class LeetCode112 {
    
    public static void main(String[] args) {
        //求路径总和
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right
        , targetSum - root.val);
    }
}

