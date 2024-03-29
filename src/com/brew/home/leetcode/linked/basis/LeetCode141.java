/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode141
 * Author:   feiyi
 * Date:     2020/5/26 10:31 AM
 * Description: 环形链表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.leetcode.linked.basis;

import com.brew.home.common.ListNode;

/**
 * 〈一句话功能简述〉:
 * 〈环形链表〉
 *
 * @author feiyi
 * @create 2020/5/26
 * @since 1.0.0
 */
public class LeetCode141 {

    public static void main(String[] args){
        //141:   https://leetcode.cn/problems/linked-list-cycle/

        // ListNode l1 = ListNode.buildCircle();
        ListNode l1 = ListNode.buildNormal();
        System.out.println(hasCycle(l1));

    }

    //解题1
    //本来的想法是算每一个元素hashcode，然后进行判断。官网解题是使用一个HashSet<ListNode>,并使用其contains和add方法。当然本质
    //上还是算的hashcode

    //解题2
    //使用快慢指针法。有个问题，一次迈两步的那个人一定会追上一次迈一步的那个人吗，答案是一定会，而且是在下一次就会追上。为什么，画个圈
    // ，一个个的坑，一个人一次跳一个坑，一个人一次跳两个坑。等到第二个人快要追上第一个人的时候，只会有两种情况，一是2在1的后面一个坑，
    // 那么再跳一次就追上了，另外一种情况，2在1的前面一个坑，那其实上一次跳2就已经追上1了。
    // 至于2在1后面2个坑或3个坑，画一画就知道，只是多跳一次的问题而已。
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return false;
        //一人先跳一次
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        for (; ; ) {
            //必须是拿引用直接比较，不可以取值eq
            if (slow == null || fast == null) return false;
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next;
            if (fast == null) return false;
            fast = fast.next;
        }
    }

}
