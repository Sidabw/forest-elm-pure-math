package com.brew.home.tmp.day230411;

import com.brew.home.common.ListNode;

public class LeetCode876 {
    public static void main(String[] args) {
        
        System.out.println(calMidNode(null));
        
    }
    private static ListNode calMidNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
