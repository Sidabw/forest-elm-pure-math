package com.brew.home.common;

/**
 * @author shaogz
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode buildNull(){
        return null;
    }

    public static ListNode buildOnlyOne() {
        return new ListNode(1);
    }


    public static ListNode buildOnlyTwo() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        return node1;
    }

    /**
     * 1,2,3,2,4
     * @return: com.brew.home.common.ListNode
     * @Author: shaogz
     * @Date: 2021/11/22 5:15 PM
     **/
    public static ListNode buildNormal() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        return node1;
    }

    /**
     * 构建一个双数的链表:1,2,3,2,4,6
     * @return: com.brew.home.common.ListNode
     * @Author: shaogz
     * @Date: 2021/11/24 11:16 AM
     **/
    public static ListNode buildNormalDual() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        return node1;
    }

    public static ListNode buildCircle() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        return node1;
    }

    public static ListNode buildCustom(int... values) {
        ListNode root = new ListNode(values[0]);
        ListNode cur = root;
        for (int i = 1; i< values.length; i++) {
            ListNode next = new ListNode(values[i]);
            cur.next = next;
            cur = next;
        }
        return root;
    }

    public static String printBeautify(ListNode root) {
        StringBuilder resBuilder = new StringBuilder();
        String result;
        if (root == null) {
            resBuilder.append("null");
            result = resBuilder.toString();
            System.out.println(result);
            return result;
        }

        resBuilder.append("[");
        while (true) {
            resBuilder.append(root.val);
            root = root.next;
            if (root == null) {
                resBuilder.append("]");
                result = resBuilder.toString();
                System.out.println(result);
                return result;
            } else {
                resBuilder.append(",");
            }
        }
    }
}

