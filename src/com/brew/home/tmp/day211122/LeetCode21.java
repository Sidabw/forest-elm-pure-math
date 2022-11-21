package com.brew.home.tmp.day211122;

import com.brew.home.common.ListNode;

/**
 * @author shaogz
 */
public class LeetCode21 {

    public static void main(String[] args) {
        ListNode root1 = ListNode.buildCustom(1, 3, 5, 9);
        ListNode root2 = ListNode.buildCustom(2, 6, 12);
        ListNode result = mergeSortedListNode(root1, root2);
        ListNode.printBeautify(result);

    }

    private static ListNode mergeSortedListNode(ListNode root1, ListNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        //init head first
        //不用非得从root1 or root2中拿一个作为result的head，先弄一个假的不就行了
        ListNode resultRoot = new ListNode(0);


        //
        ListNode resultCur = resultRoot;
        while (true) {
            if (root1 == null) {
                resultCur.next = root2;
                return resultRoot.next;
            } else if (root2 == null) {
                resultCur.next = root1;
                return resultRoot.next;
            } else {
                if (root1.val < root2.val) {
                    resultCur.next = root1;
                    root1 = root1.next;
                } else {
                    resultCur.next = root2;
                    root2 = root2.next;
                }
                resultCur = resultCur.next;
            }
        }


    }
}
