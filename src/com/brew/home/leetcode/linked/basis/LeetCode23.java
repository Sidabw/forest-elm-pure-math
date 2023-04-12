package com.brew.home.leetcode.linked.basis;

import java.util.Arrays;

import com.brew.home.common.ListNode;

public class LeetCode23 {
    
    public static void main(String[] args) {
        
        // ListNode[] lists = Arrays.asList(ListNode.buildCustom(1, 4, 5), ListNode.buildCustom(1, 3, 6), ListNode.buildCustom(2, 6)).toArray(new ListNode[]{});
        ListNode[] lists = new ListNode[]{};
        ListNode res = mergeKLists(lists);
        ListNode.printBeautify(res);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        
        //每次都遍历ListNode[]的所有头节点，找到最小的，记录下来，进入下一次便利。
        
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while(true) {

            ListNode indexNode = null;
            int index = 0;
            for(int i = 0; i< lists.length; i++) {
                if(lists[i] == null) {
                    continue;
                }

                if (indexNode == null || indexNode.val > lists[i].val) {
                    indexNode = lists[i];
                    index = i;
                    continue;
                }
            }

            if (indexNode != null) {
                cur.next = indexNode;
                lists[index] = indexNode.next;
                cur = cur.next;
            } else {
                return dummyHead.next;
            }
        }

    }

}
