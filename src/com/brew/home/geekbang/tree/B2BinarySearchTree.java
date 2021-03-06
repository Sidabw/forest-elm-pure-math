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
package com.brew.home.geekbang.tree;


/**
 * 〈一句话功能简述〉:
 * 〈二叉查找树的插入、查找、删除（logn）〉
 *
 * @author feiyi
 * @create 2020/6/27
 * @since 1.0.0
 */
public class B2BinarySearchTree {

    public static void main(String[] args) {
        Node root = buildBinarySearchTree();
        Node target = new Node(12);
        search(root, target);
//        delete(root, target);
//        B1BinaryTree.inOrder(root);
//         insert(root, 13);
        B1BinaryTree.inOrder(root);
    }

    private static void search(Node root, Node target) {
        if (root == null) {
            System.out.println("not found! root null!");
        } else if (root.value == target.value) {
            System.out.println("found! root value:: " + root.value);
        } else if (target.value < root.value) {
            search(root.left, target);
        } else {
            search(root.right, target);
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

    private static void delete(Node root, Node target) {
        //第一种情况：删除的节点没有子节点
        //第二种情况：删除的节点有一个子节点
        //第三种情况：删除的节点有两个子节点(找到右子树的最小值替换之)
        int targetValue = target.value;
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
            Node minP = p.right;
            Node minPP = p;
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
