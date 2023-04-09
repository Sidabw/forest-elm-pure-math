/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode21
 * Author:   feiyi
 * Date:     2020/5/25 9:16 AM
 * Description: 合并两个有序链表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.leetcode.linked.basis;

import com.brew.home.common.ListNode;

/**
 * 〈一句话功能简述〉:
 * 〈合并两个有序链表〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode21 {

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>示例：
     * <p> 输入：1->2->4, 1->3->4
     * <p> 输出：1->1->2->3->4->4
     * 链接：<a href="https://leetcode-cn.com/problems/merge-two-sorted-lists">力扣（LeetCode）21</a>
     * @since 2.0.5
     * @author feiyi
     * @date 2019/7/22 4:51 PM
     **/
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode5;
        listNode5.next = listNode6;
        mergeTwoLists(listNode1, listNode4);

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //判空
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        //用一个带头链表
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if (l1 == null)
            cur.next = l2;
        else
            cur.next = l1;
        return dummyHead.next;
    }
}
