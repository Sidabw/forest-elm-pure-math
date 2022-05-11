package com.brew.home.leetcode.linked;

import com.brew.home.common.ListNode;

/**
 * @author shaogz
 */
public class LeetCode2 {

    public static void main(String[] args) {
        ListNode case1p1 = ListNode.buildCustom(2, 4, 3);
        ListNode case1p2 = ListNode.buildCustom(5, 6, 4);
        ListNode res1 = add2nums(case1p1, case1p2);
        assert "[7,0,8]".equals(ListNode.printBeautify(res1));

        ListNode case2p1 = ListNode.buildCustom(0);
        ListNode case2p2 = ListNode.buildCustom(0);
        ListNode res2 = add2nums(case2p1, case2p2);
        assert "[0]".equals(ListNode.printBeautify(res2));

        ListNode case3p1 = ListNode.buildCustom(9,9,9,9,9,9,9);
        ListNode case3p2 = ListNode.buildCustom(9,9,9,9);
        ListNode res3 = add2nums(case3p1, case3p2);
        assert "[8,9,9,9,0,0,0,1]".equals(ListNode.printBeautify(res3));

    }

    private static ListNode add2nums(ListNode n1, ListNode n2){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        //标识是否进位
        boolean isPlus = false;
        while (n1 != null && n2 != null) {
            int curVal = n1.val + n2.val;
            if (isPlus) {
                curVal++;
            }
            int realCurVal = curVal % 10;
            ListNode curNode = new ListNode(realCurVal);
            cur.next = curNode;
            cur = curNode;

            if (curVal/10 > 0) {
                isPlus = true;
            } else {
                isPlus = false;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        while (n1 != null) {
            int curVal = isPlus ? n1.val + 1: n1.val;
            int realCurVal = curVal % 10;
            ListNode curNode = new ListNode(realCurVal);
            cur.next = curNode;
            cur = curNode;

            if (curVal/10 > 0) {
                isPlus = true;
            } else {
                isPlus = false;
            }

            n1 = n1.next;
        }

        while (n2 != null) {
            int curVal = isPlus ? n2.val + 1: n2.val;
            int realCurVal = curVal % 10;
            ListNode curNode = new ListNode(realCurVal);
            cur.next = curNode;
            cur = curNode;

            if (curVal/10 > 0) {
                isPlus = true;
            } else {
                isPlus = false;
            }

            n2 = n2.next;
        }

        if (isPlus) {
            ListNode curNode = new ListNode(1);
            cur.next = curNode;
        }

        return dummyHead.next;
    }
}
