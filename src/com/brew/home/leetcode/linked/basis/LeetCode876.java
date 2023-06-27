/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode876
 * Author:   feiyi
 * Date:     2020/5/26 5:01 PM
 * Description: 链表的中间结点
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.leetcode.linked.basis;

import com.brew.home.common.ListNode;

/**
 * 〈一句话功能简述〉:
 * 〈链表的中间结点〉
 *
 * @author feiyi
 * @create 2020/5/26
 * @since 1.0.0
 */
public class LeetCode876 {

    /**
     * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * <p>
     * 示例 1：
     * 输入：[1,2,3,4,5]
     * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
     * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
     * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
     * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
     * 示例2：
     * <p>
     * 输入：[1,2,3,4,5,6]
     * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
     * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     * <p>
     * 提示：
     * 给定链表的结点数介于1和100之间。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @since 2.0.5
     * @author feiyi
     *  2020/5/26 5:02 PM
     **/
    public static void main(String[] args){

        //注意：估计是题目描述有误解，后面改了
        //改之前：  * 给定一个带有头结点head的非空单链表，返回链表的中间结点。
        //改之后；  * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
        //所以这跟‘带头节点的单链表’没有一毛钱关系

        // ListNode l1 = ListNode.buildCustom(1, 2);
        ListNode l1 = ListNode.buildCustom(1, 2, 3, 2, 4);
        ListNode res = calMidNode(l1);
        ListNode.printBeautify(res);

    }

    //依然是快慢指针
    private static ListNode calMidNode(ListNode head) {
        if (head == null) {
            return null;
        }
        //傻逼吧。。。  乌龟是快的，兔子是慢的.....
        ListNode nodeTortoise = head;
        ListNode nodeRabbit = head;

        ListNode nodeTortoiseTmp;
        while (true) {
            nodeTortoiseTmp = nodeTortoise.next;
            if (nodeTortoiseTmp == null) {
                return nodeRabbit;
            }
            nodeTortoise = nodeTortoise.next.next;
            if (nodeTortoise == null) {
                return nodeRabbit.next;
            }
            nodeRabbit = nodeRabbit.next;
        }

    }

}
