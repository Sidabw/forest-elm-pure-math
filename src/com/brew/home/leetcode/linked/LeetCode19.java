/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode19
 * Author:   feiyi
 * Date:     2020/5/26 11:19 AM
 * Description: Remove Nth Node From End of List
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.leetcode.linked;

import com.brew.home.common.ListNode;

/**
 * 〈一句话功能简述〉:
 * 〈Remove Nth Node From End of List〉
 *
 * @author feiyi
 * @create 2020/5/26
 * @since 1.0.0
 */
public class LeetCode19 {

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        //        ListNode listNode3 = new ListNode(3);
        //        ListNode listNode4 = new ListNode(2);
        //        ListNode listNode5 = new ListNode(4);
        listNode1.next = listNode2;
        //        listNode2.setNext(listNode3);
        //        listNode3.setNext(listNode4);
        //        listNode4.setNext(listNode5);
        ListNode res = removeNthFromEnd(listNode1, 1);
        System.out.println(res);
    }

    //思路1
    //pass one， 拿到 linked list 的size，对应计算出n-th from start
    //pass two，删除n-th元素

    //思路2
    //pass one，遍历的同时压入栈
    //pass two，对栈一直执行pop操作，直到拿到待删除节点的前置节点。
    //总结，都是2n的时间复杂度，顶多第二种处理起来优雅写；

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        if (size == 1) return null;//既然保证n一定是有效的，那么...
        int indexFromStart = size - n;//index start from 0
        if (indexFromStart == 0) return head.next;
        int curIndex = 0;
        cur = head;
        ListNode pre = cur;
        for (; ; ) {
            if (curIndex == indexFromStart) {
                pre.next = cur.next;
                return head;
            }
            curIndex++;
            pre = cur;
            cur = cur.next;
        }
    }
}
