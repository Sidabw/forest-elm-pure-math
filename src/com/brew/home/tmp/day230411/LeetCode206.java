package com.brew.home.tmp.day230411;

import com.brew.home.common.ListNode;

public class LeetCode206 {
    
    public static void main(String[] args) {
        // ListNode l1 = ListNode.buildCustom(1);
        ListNode l1 = ListNode.buildCustom(1, 2, 3, 2, 4);

        ListNode.printBeautify(l1);
        ListNode res = reverse(l1);
        ListNode.printBeautify(res);
    }

    public static ListNode reverse(ListNode cur) {
        if (cur == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        
        while (true) {
            //先把next存下来
            next = cur.next;
            //然后再把箭头掰过来
            cur.next =pre;
            pre = cur;
            if (next == null) {
                return cur;
            }
            cur = next;
        }
    }
}
