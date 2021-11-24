package com.brew.home.tmp.day211122;

import com.brew.home.common.ListNode;

/**
 * @author shaogz
 */
public class LeetCode206 {

    public static void main(String[] args) {
        //单链表反转
        // ListNode root = ListNode.buildNormal();
        // ListNode root = ListNode.buildNull();
        ListNode root = ListNode.buildOnlyOne();
        ListNode reversed = reverseSingleListNode(root);
        ListNode.printBeautify(reversed);
    }

    private static ListNode reverseSingleListNode(ListNode root) {
        if (root == null) {
            return null;
        }

        ListNode prev = null;
        ListNode cur = root;
        while (cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        cur.next = prev;
        return cur;
    }
}
