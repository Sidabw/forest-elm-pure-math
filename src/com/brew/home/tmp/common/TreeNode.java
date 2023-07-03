package com.brew.home.tmp.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
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

