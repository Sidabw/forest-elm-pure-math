/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: BinarySearchTreeDemo
 * Author:   feiyi
 * Date:     2020/6/27 8:53 AM
 * Description: 二叉搜索树
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.geekbang.p3tree.binary.b2;

import com.brew.home.geekbang.p3tree.binary.Node;
import com.brew.home.geekbang.p3tree.binary.b1.B1BinaryTree;

/**
 * 〈一句话功能简述〉:
 * 〈二叉查找树的插入、查找、删除（logn）〉
 * 20230302补充：上面说的logn是指平衡二叉查找树。
 * 20230627补充：这里的插入、查找、删除只是demo代码，没有考虑重复的情况，暂时也不用考虑了，可以看笔记比较简单。
 * @author feiyi
 * @create 2020/6/27
 * @since 1.0.0
 */
public class B2BinarySearchTree {

    public static void main(String[] args) {
        Node root = buildBinarySearchTree();
        System.out.print("原始顺序：");
        B1BinaryTree.inOrder(root);
        System.out.println();

        
        insert(root, 13);
        System.out.print("insert13后：");
        B1BinaryTree.inOrder(root);
        System.out.println();


        System.out.print("查找12：");
        search(root, 12);


        delete(root, 12);
        System.out.print("删除12后：");
        B1BinaryTree.inOrder(root);
        System.out.println();

    }

    private static void search(Node root, int targetVal) {
        if (root == null) {
            System.out.println("not found! root null!");
        } else if (root.value == targetVal) {
            System.out.println("found! root value:: " + root.value);
        } else if (targetVal < root.value) {
            search(root.left, targetVal);
        } else {
            search(root.right, targetVal);
        }
    }

    //返回根节点
    private static Node insert(Node root, int target) {
        if (root == null) {
            return new Node(target);
        }
        Node p = root;
        while (true) {
            if (target < p.value) {
                if (p.left == null) {
                    p.left = new Node(target);
                    return root;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(target);
                    return root;
                }
                p = p.right;
            }
        }
    }

    private static void delete(Node root, int targetValue) {
        //第一种情况：删除的节点没有子节点
        //第二种情况：删除的节点有一个子节点
        //第三种情况：删除的节点有两个子节点(找到右子树的最小值替换之)

        //1.找到当前节点和当前节点的父节点
        Node p = root;
        Node pp = null;
        while (p != null && p.value != targetValue) {
            pp = p;
            if (targetValue < p.value) {
                p = p.left;
            } else{
                p = p.right;
            }
        }
        if (p == null) {
            return;//没有找到
        }

        //2,对有两个节点的情况进行特殊处理
        if (p.left != null && p.right != null) {
            //找右子树的最小值
            Node minPP = p;
            Node minP = p.right;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            //只是进行值的替换
            p.value = minP.value;
            //对p和pp进行篡改，使得往下进行的逻辑依旧是"删除节点是叶子节点或者仅有一个节点。"
            p = minP;
            pp = minPP;
        }

        //3.删除节点是叶子节点或者仅有一个节点。
        Node child;//p的child
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            //此时说明p是叶子节点
            child = null;
        }
        if (pp == null) {
            //此时表示删除的是根节点。且该树只有一个节点。
            root = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }


    public static Node buildBinarySearchTree() {
        /*
        10
     6      15
   3   7   12  17
 2
        */
        Node root = new Node(10);
        Node left1 = new Node(6);
        Node right1 = new Node(15);
        root.left = left1;
        root.right = right1;

        Node left2 = new Node(3);
        Node right2 = new Node(7);
        left1.left = left2;
        left1.right = right2;

        Node left3 = new Node(12);
        Node right3 = new Node(17);
        right1.left = left3;
        right1.right = right3;

        Node left4 = new Node(2);
        left2.left = left4;
        return root;
    }

}
