package com.brew.home.geekbang.p3tree.binary.b1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用数组存储二叉树
 *
 * @author shaogz
 */
public class B1BinaryTreeInArr {

    public static void main(String[] args) {
        //我们把根节点存储在下标 i = 1 的位置，那左子节点存储在下标 2 * i = 2 的位置，右子节点存储在 2 * i + 1 = 3 的位置。
        ArrNode[] nodes = new ArrNode[11];
        nodes[1] = new ArrNode(1);
        nodes[2] = new ArrNode(2);
        nodes[3] = new ArrNode(3);
        nodes[4] = new ArrNode(4);
        nodes[5] = new ArrNode(5);
        nodes[6] = new ArrNode(6);
        nodes[7] = new ArrNode(7);
        nodes[8] = new ArrNode(8);
        nodes[9] = new ArrNode(9);
        nodes[10] = new ArrNode(10);
        System.out.println(nodes[1].getVal());

        //因为上面是一个完全二叉树，所以出了0角标空着以外，其他角标都有元素
        /*
         1
      2     3
   4     5   6   7
 8  9  10
        */
    }

    public static void print(int[] arr) {
        //assumption：[1, len-1]不会又越界
        //逐层遍历
        int i = 1;
        int n = arr.length - 1;
        //i , 2*i, 2*i+1, ......
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            System.out.print(arr[tmp] + ",");

            int left = tmp * 2;
            if (left > n) {
                continue;
            }
            queue.offer(left);
            queue.offer(left + 1);
        }
    }


    private static class ArrNode {

        private final int val;

        ArrNode(int value) {
            this.val = value;
        }

        public int getVal() {
            return val;
        }
    }


}
