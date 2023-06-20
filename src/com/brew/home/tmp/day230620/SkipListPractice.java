package com.brew.home.tmp.day230620;

import java.util.Random;

public class SkipListPractice {

    private static final int MAX_LEVAL = 16;

    private static final Random RANDOM = new Random();

    private int maxLevelHeight = 1;

    private final Node head = new Node(MAX_LEVAL);

    public void insert(int val) {

        int curLevelHeight = random();
        if(curLevelHeight > maxLevelHeight) {
            curLevelHeight = ++maxLevelHeight;
        }

        Node cur = new Node(curLevelHeight);
        cur.val = val;

        //找到前置节点
        Node[] preNodes = new Node[curLevelHeight];
        Node p = head;
        //for循环是索引层从上往下
        for(int i = curLevelHeight - 1 ; i >= 0; i--) {
            //while循环是当前层横着往右找
            while(p.forwards[i] != null && p.forwards[i].val < val) {
                p = p.forwards[i];
            }
            preNodes[i] = p;
        }

        //更新curNode.forwards
        for(int i = 0; i < curLevelHeight; i++) {
            cur.forwards[i] = preNodes[i].forwards[i];
            preNodes[i].forwards[i] = cur;
        }
    }

    public Node find(int val) {
        //还是先找前置节点
        Node p = head;
        for(int i = maxLevelHeight - 1; i >= 0; i--) {
            while(p.forwards[i] != null && p.forwards[i].val < val) {
                p = p.forwards[i];
            }
        }

        if(p.forwards[0] != null && p.forwards[0].val == val) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    private int random() {
        int level = 0;
        for(int i = 0; i < MAX_LEVAL; i++) {
            if(RANDOM.nextInt()%2 == 1) {
                level++;
            }
        }
        return level;
    }

    /**
     * 打印每个节点数据和最大层数
     */
    public void printAll() {
        //copy from SkipList2
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

}

class Node {

    Node[] forwards;

    int val;

    Node(int level) {
        this.forwards = new Node[level];
    }


    @Override
    public String toString() {
        //copy from SkipList2
        StringBuilder builder = new StringBuilder();
        builder.append("{ val: ");
        builder.append(val);
        builder.append("; levels: ");
        builder.append(forwards.length);
        builder.append(" }");
        return builder.toString();
    }

    
    public static void main(String[] args) {
        SkipListPractice list = new SkipListPractice();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(8);
        list.insert(7);
        list.printAll();
        System.out.println("find5:: " + list.find(5));

    }

}
