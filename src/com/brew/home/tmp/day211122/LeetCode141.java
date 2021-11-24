package com.brew.home.tmp.day211122;

import com.brew.home.common.ListNode;

/**
 * @author shaogz
 */
public class LeetCode141 {

    public static void main(String[] args) {
        //链表中环的检测
        // ListNode root = ListNode.buildNormal();
        ListNode root = ListNode.buildCircle();
        boolean isCircleListNode = isCircleListNode(root);
        System.out.println(isCircleListNode);
    }

    private static boolean isCircleListNode(ListNode root) {
        //龟兔赛跑，乌龟🐢往前走一步，兔子🐰往前走两步，俩人遇到了，就说明列表中有环
        if (root == null) {
            return false;
        }
        ListNode nodeTortoise = root;
        ListNode nodeRabbit = root;
        while (true) {
            if (nodeTortoise.next == null) {
                return false;
            }
            nodeTortoise = nodeTortoise.next;

            if (nodeRabbit.next == null || nodeRabbit.next.next == null) {
                return false;
            }
            nodeRabbit = nodeRabbit.next.next;
            if (nodeRabbit == nodeTortoise) {
                return true;
            }
        }
    }
}
