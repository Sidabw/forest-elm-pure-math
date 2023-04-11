package com.brew.home.tmp.day230411;

import com.brew.home.common.ListNode;

public class LeetCode21 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.buildCustom(1, 2, 4);
        ListNode l2 = ListNode.buildCustom(1, 3, 4);
        
        ListNode result = mergeTwoLists(l1, l2);
        ListNode.printBeautify(result);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //判空
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        //带头空节点
        ListNode head = new ListNode(0);
        //定义一个当前指针。别后面搞来搞去把头丢了
        ListNode cur = head;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }

        if(l1 != null) {
            cur.next = l1;
        } else if (l2 != null) {
            cur.next = l2;
        }
        
        return head.next;
    }
}
