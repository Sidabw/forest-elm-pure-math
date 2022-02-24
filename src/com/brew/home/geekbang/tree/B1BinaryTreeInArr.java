package com.brew.home.geekbang.tree;

/**
 * 使用数组存储二叉树
 *
 * @author shaogz
 */
public class B1BinaryTreeInArr {

    public static void main(String[] args) {
        //我们把根节点存储在下标 i = 1 的位置，那左子节点存储在下标 2 * i = 2 的位置，右子节点存储在 2 * i + 1 = 3 的位置。
        Node[] nodes = new Node[11];
        nodes[1] = new Node(1);
        nodes[2] = new Node(2);
        nodes[3] = new Node(3);
        nodes[4] = new Node(4);
        nodes[5] = new Node(5);
        nodes[6] = new Node(6);
        nodes[7] = new Node(7);
        nodes[8] = new Node(8);
        nodes[9] = new Node(9);
        nodes[10] = new Node(10);

        //因为上面是一个完全二叉树，所以出了0角标空着以外，其他角标都有元素
        /*
         1
      2     3
   4     5   6   7
 8  9  10
        */
    }


}
