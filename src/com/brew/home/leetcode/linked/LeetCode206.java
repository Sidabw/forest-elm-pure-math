/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode206
 * Author:   feiyi
 * Date:     2020/5/26 9:32 AM
 * Description: 反转链表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.leetcode.linked;



import com.brew.home.common.ListNode;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉:
 * 〈反转链表〉
 *
 * @author feiyi
 * @create 2020/5/26
 * @since 1.0.0
 */
public class LeetCode206 {

    /**
     * @param
     * @Description 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2020/5/26 9:33 AM
     **/
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        //        ListNode listNode2 = new ListNode(2);
        //        ListNode listNode3 = new ListNode(3);
        //        ListNode listNode4 = new ListNode(2);
        //        ListNode listNode5 = new ListNode(4);
        //        listNode1.setNext(listNode2);
        //        listNode2.setNext(listNode3);
        //        listNode3.setNext(listNode4);
        //        listNode4.setNext(listNode5);

        //        ListNode listNode = reverseList(listNode1);
        //        System.out.println(listNode);

        ListNode res = reverseList2(listNode1);
        System.out.println(res);
    }

    //输入: 1->2->3->4->5->NULL
    //输出: 5->4->3->2->1->NULL
    public static ListNode reverseList2(ListNode cur) {
        //在遍历的过程中，改变指针的方向。
        if (cur == null) return null;

        ListNode pre = null;
        ListNode next = null;
        for (; ; ) {
            next = cur.next;
            cur.next = pre;//当前节点向后指，改为向前指
            pre = cur;//当前的cur下，就是下一个节点的pre;
            if (next == null) return cur;
            cur = next;
        }

        //画图的tmp
        //两个箭头，分别是如何遍历、如何反转，对应代码的1 4 5三行和 2 3 两行
    }
}
