package com.brew.home.tmp.day211124;

import com.brew.home.common.ListNode;

/**
 * @author shaogz
 */
public class LeetCode876 {

    public static void main(String[] args) {
        ListNode normalNode = ListNode.buildNormal();
        ListNode midNodeInNormalNode = calMidNode(normalNode);
        assert "[3,2,4]".equals(ListNode.printBeautify(midNodeInNormalNode));


        ListNode normalDualNode = ListNode.buildNormalDual();
        ListNode midNodeInNormalDualNode = calMidNode(normalDualNode);
        assert "[2,4,6]".equals(ListNode.printBeautify(midNodeInNormalDualNode));


        ListNode nullNode = ListNode.buildNull();
        ListNode midNodeInNullNode = calMidNode(nullNode);
        assert "null".equals(ListNode.printBeautify(midNodeInNullNode));

        ListNode rootWithOnlyOneNode = ListNode.buildOnlyOne();
        ListNode midInOne = calMidNode(rootWithOnlyOneNode);
        assert "[1]".equals(ListNode.printBeautify(midInOne));

        ListNode rootWithOnlyTwoNode = ListNode.buildOnlyTwo();
        ListNode midNode = calMidNode(rootWithOnlyTwoNode);
        assert "[2]".equals(ListNode.printBeautify(midNode));
    }

    private static ListNode calMidNode(ListNode head) {
        if (head == null) {
            return null;
        }
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
