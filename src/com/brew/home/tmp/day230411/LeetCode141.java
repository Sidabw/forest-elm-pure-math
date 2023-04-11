package com.brew.home.tmp.day230411;

import com.brew.home.common.ListNode;

public class LeetCode141 {
    
    public static void main(String[] args) {
        ListNode l1 = ListNode.buildCircle();
        // ListNode l1 = ListNode.buildNormal();
        System.out.println(hasCycle(l1));
    }

    public static boolean hasCycle(ListNode l1) {
        //双指针
        if(l1 == null || l1.next == null || l1.next.next == null) {
            return false;
        }

        ListNode tortoise = l1.next;
        ListNode rabbit = l1.next.next;

        while (true) {
            if (tortoise == rabbit) {
                return true;
            }
            tortoise = tortoise.next;
            if (tortoise.next == null) {
                return false;
            }
            rabbit = rabbit.next;
            if (rabbit == null) {
                return false;
            }
            rabbit = rabbit.next;
            if (rabbit == null) {
                return false;
            }
        }
    }
}
