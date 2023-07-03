package com.brew.home.tmp.day230703;

import com.brew.home.tmp.common.TreeNode;

public class LeetCode104 {
    
    public static void main(String[] args) {
        
    }

    //深度优先遍历求二叉树最大深度【根节点深度为1】
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = maxDepth(root.left);
        int rHeight = maxDepth(root.right);
        return Math.max(lHeight, rHeight) + 1;
    }
}

