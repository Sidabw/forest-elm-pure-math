/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: BinaryTreeDemo
 * Author:   feiyi
 * Date:     2020/6/26 12:29 PM
 * Description: 二叉树学习Demo
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.geekbang.p3tree.binary.b1;

import java.util.ArrayDeque;
import java.util.Queue;

import com.brew.home.geekbang.p3tree.binary.Node;

/**
 * 〈一句话功能简述〉:
 * 〈二叉树学习Demo〉
 *
 * @author feiyi
 * @create 2020/6/26
 * @since 1.0.0
 */
public class B1BinaryTree {

    public static void main(String[] args) {
        //中序输出有序数组非本节内容，移步B2BinarySearchTree
        Node root = buildTree();
        preOrder(root);
        System.out.println("^preOrder^------------------------------------------");
        System.out.println();
        System.out.println();

        inOrder(root);
        System.out.println("^inOrder^------------------------------------------");
        System.out.println();
        System.out.println();

        postOrder(root);
        System.out.println("^postOrder^------------------------------------------");
        System.out.println();
        System.out.println();

        levelOrder(root);
        System.out.println("^levelOrder^------------------------------------------");
    }

    //前序遍历(先打印当前节点，再打印左子树，再打印右子树)
    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + ",");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历（先打印左子树，再打印本身，再打印右子树）
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + ",");
        inOrder(root.right);
    }

    //后序遍历（先打印左子树，再打印右子树，再打印本身）
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + ",");
    }

    //分层遍历
    public static void levelOrder(Node root) {
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            Node poll = nodes.poll();
            System.out.print(poll.value + ",");
            if (poll.left != null) {
                nodes.offer(poll.left);
            }
            if (poll.right != null) {
                nodes.offer(poll.right);
            }
        }
    }

    /**
     * 声明：这只是一个二叉树，不是二叉搜索树
     * @return com.Java.math.tree.Node
     * @since 2.0.5
     * @author feiyi 2020/6/27 3:35 PM
     **/
    public static Node buildTree() {
        /*
        10
     6      11
   3   7   9  12
 2
        */
        Node root = new Node(10);
        Node left1 = new Node(6);
        Node right1 = new Node(11);
        root.left = left1;
        root.right = right1;

        Node left2 = new Node(3);
        Node right2 = new Node(7);
        left1.left = left2;
        left1.right = right2;

        Node left3 = new Node(9);
        Node right3 = new Node(12);
        right1.left = left3;
        right1.right = right3;

        Node left4 = new Node(2);
        left2.left = left4;
        return root;
    }

    public static Node buildTree2() {
        /*
        10
     6      11
   3   7   9  13
 2
        */
        Node root = new Node(10);
        Node left1 = new Node(6);
        Node right1 = new Node(11);
        root.left = left1;
        root.right = right1;

        Node left2 = new Node(3);
        Node right2 = new Node(7);
        left1.left = left2;
        left1.right = right2;

        Node left3 = new Node(9);
        Node right3 = new Node(13);
        right1.left = left3;
        right1.right = right3;

        Node left4 = new Node(2);
        left2.left = left4;
        return root;
    }
}


