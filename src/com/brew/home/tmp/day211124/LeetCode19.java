package com.brew.home.tmp.day211124;

import com.brew.home.common.ListNode;

/**
 * @author shaogz
 */
public class LeetCode19 {

    /**
     * 删除倒数n节点
     * @param args args
     * 
     * @author shaogz
     *  2021/11/24 10:19 AM
     **/
    public static void main(String[] args) {
        ListNode root = ListNode.buildNormal();
        ListNode result = deleteNthFromEnd(root, 2);
        ListNode.printBeautify(result);
    }

    /**
     *
     * @param root root
     * @param delIndexFromEnd 从1开始
     * @return com.brew.home.common.ListNode
     * @author shaogz
     *  2021/11/24 10:24 AM
     **/
    private static ListNode deleteNthFromEnd(ListNode root, int delIndexFromEnd) {
        //正着遍历一次，得到length，接着得到正数nTh
        ListNode head = root;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        //delIndexFromEnd是从1开始的，delIndexFromStart是从0开始的
        int delIndexFromStart = len - delIndexFromEnd;
        if (delIndexFromStart <= 0) {
            return null;
        }
        //拿到前一个
        int delIndexFromStartPrev = delIndexFromStart - 1;

        int iteratorIndex = 0;
        head = root;
        while (head != null) {
            if (iteratorIndex == delIndexFromStartPrev) {
                head.next = head.next.next;
                return root;
            }
            head = head.next;
            iteratorIndex++;
        }
        return null;
    }

}
