package com.brew.home.leetcode;

import static com.brew.home.geekbang.p3tree.binary.b1.B1BinaryTree.buildTree;
import static com.brew.home.geekbang.p3tree.binary.b1.B1BinaryTree.buildTree2;

import com.brew.home.geekbang.p3tree.binary.Node;

public class LeetCode100 {

    public static void main(String[] args) {
        Node r1 = buildTree();
        Node r2 = buildTree2();

        try {
            new LeetCode100().isSameTree(r1, r2);
            System.out.println(true);
        } catch (Exception e) {
            System.out.println(false);
        }

    }

    public void isSameTree(Node p, Node q) {
        if (p == null && q == null) {
            return;
        }
        if (p == null) {
            throw new IllegalStateException("none eq");
        }

        if (q == null) {
            throw new IllegalStateException("none eq");
        }

        isSameTree(p.left, q.left);
        if (p.value != q.value) {
            throw new IllegalStateException("none eq");
        }
        isSameTree(p.right, q.right);

    }
}
