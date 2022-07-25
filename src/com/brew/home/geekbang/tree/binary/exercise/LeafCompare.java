package com.brew.home.geekbang.tree.binary.exercise;

import com.brew.home.geekbang.tree.binary.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 比较两颗二叉树的叶子结点是否相同
 *
 * @author shaogz
 */
public class LeafCompare {

    public static void main(String[] args) {
        Node root1 = buildTree1();
        Node root2 = buildTree2();
        System.out.println(com(root1, root2));
    }


    private static List<Integer> res = new ArrayList<>();

    private static void getLeaf(Node root) {
        if (root == null) return;
        getLeaf(root.left);
        getLeaf(root.right);
        if (root.left == null && root.right == null)
            res.add(root.value);
    }

    //这是啥。。。。
    public static boolean com(Node root1, Node root2) {
        getLeaf(root1);
        ArrayList<Integer> leaf1 = new ArrayList<>(res);
        res.clear();

        getLeaf(root2);
        ArrayList<Integer> leaf2 = new ArrayList<>(res);
        res.clear();

        if (leaf1.size() != leaf2.size()){
            return false;
        }
        for (int i = 0; i < leaf1.size(); i++) {
            int i1 = leaf1.get(i);
            int i2 = leaf2.get(i);
            if (i1 != i2) {
                return false;
            }
        }
        return true;
    }

    /**
     * 声明：这只是一个二叉树，不是二叉搜索树
     * <p>
     * 10
     * 6        11
     * 3    7   9   12
     * @return: com.Java.math.tree.Node
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/6/27 3:35 PM
     **/
    public static Node buildTree1() {
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

        return root;
    }

    /**
     * 声明：这只是一个二叉树，不是二叉搜索树
     * <p>
     * 10
     * 6        11
     * 3    7   9   12
     * @return: com.Java.math.tree.Node
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/6/27 3:35 PM
     **/
    public static Node buildTree2() {
        Node root = new Node(8);
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

        return root;
    }

}
