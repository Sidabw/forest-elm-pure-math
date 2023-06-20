package com.brew.home.geekbang.p1sortAsearch.search.skip;

import java.util.Random;

/**
 * 1，跳表的一种实现方法，用于练习。跳表中存储的是正整数，并且存储的是不重复的。
 * 2，本类是参考作者zheng ，自己学习，优化了添加方法
 * 3，看完这个，我觉得再看ConcurrentSkipListMap 源码，会有很大收获
 * 230620补充，原始代码已经找不到了....
 * Author：ldb
 */
public class SkipList2 {

    private static final int MAX_LEVEL = 16;
    /**
     * 当前跳表的最大层高
     */
    private int maxLevelHeight = 1;

    /**
     * 带头链表
     */
    private Node head = new Node(MAX_LEVEL);
    private Random r = new Random();

    public Node find(int value) {
        Node p = head;
        // 从最大层开始查找，找到前一节点，通过--i，移动到下层再开始查找
        for (int i = maxLevelHeight - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 找到前一节点
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    /**
     * 优化了作者zheng的插入方法
     *
     * @param value 值
     * @param level 当前层层高。0 表示随机层数，不为0，表示指定层数，指定层数
     *              可以让每次打印结果不变动，这里是为了便于学习理解
     */
    public void insert(int value, int curLevelHeight) {
        // 用0特殊标识
        //因为randomLevel只会返回[1,16]
        //forwards的下标是[0.15]
        if(curLevelHeight == 0) {
            curLevelHeight = head.forwards[0] == null ? 1 : randomLevel();
        }
        // 每次只增加一层，如果条件满足
        if (curLevelHeight > maxLevelHeight) {
            curLevelHeight = ++maxLevelHeight;
        }
        Node newNode = new Node(curLevelHeight);
        newNode.data = value;

        // 层是从下到上的，这里最下层编号是0，最上层编号是15
        // 从最大层开始查找，找到前一节点，通过--i，移动到下层再开始查找
        Node p = head;
        Node preNodes[] = new Node[curLevelHeight];
        for (int i = maxLevelHeight - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 找到前一节点
                p = p.forwards[i];
            }
            // 只把数据写到自己的层里。
            //因为是从最大层maxLevelHeight开始找的，maxLevelHeight>curLevelHeight有时。
            if (curLevelHeight > i) {
                preNodes[i] = p;
            }

        }
        // 把当前节点插进去，链表是怎么插入的来着？
        for (int i = 0; i < curLevelHeight; ++i) {
            newNode.forwards[i] = preNodes[i].forwards[i];
            preNodes[i].forwards[i] = newNode;
        }
    }

    /**
     * 优化了作者zheng的插入方法2
     * @param value 值
     */
    public void insert2(int value) {
        int curLevelHeight = head.forwards[0] == null ? 1 : randomLevel();
        // 每次只增加一层，如果条件满足
        if (curLevelHeight > maxLevelHeight) {
            curLevelHeight = ++maxLevelHeight;
        }
        Node newNode = new Node(curLevelHeight);
        newNode.data = value;
        Node p = head;
        // 从最大层开始查找，找到前一节点，通过--i，移动到下层再开始查找
        for (int i = maxLevelHeight - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                // 找到前一节点
                p = p.forwards[i];
            }
            // maxLevelHeight 会 > curLevelHeight，所以加上判断
            if (curLevelHeight > i) {
                if (p.forwards[i] == null) {
                    p.forwards[i] = newNode;
                } else {
                    Node next = p.forwards[i];
                    p.forwards[i] = newNode;
                    newNode.forwards[i] = next;
                }
            }
        }

    }


    public void delete(int value) {
        Node[] update = new Node[maxLevelHeight];
        Node p = head;
        for (int i = maxLevelHeight - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = maxLevelHeight - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    /**
     * 随机 level 次，如果是奇数层数 +1，防止伪随机
     * 230620补充，这个表示的应该是第一层的概率是1/2，第二层的是1/2 * 1/2，但三层的是....也就是50%的概率返回 1， 25%的概率返回 2， 12.5%的概率返回 3 .
     * 换句话说，一级索引中元素个数应该占原始数据的 50%，二级索引中元素个数占 25%，三级索引12.5% ，一直到最顶层。
     * 按照上面的说法，下面的实现是有问题的，为什么没有任何中断语句呢，先不管了
     * 实际redis是1/4，maxLevel是32.【跳表思想.pdf】
     */
    private int randomLevel() {
        // 返回层高[1,16]
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    /**
     * 打印每个节点数据和最大层数
     */
    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    /**
     * 打印所有数据
     */
    public void printAll_beautiful() {
        Node p = head;
        Node[] c = p.forwards;
        Node[] d = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            do {
                System.out.print((d[i] != null ? d[i].data : null) + ":" + i + "-------");
            } while (d[i] != null && (d = d[i].forwards)[i] != null);
            System.out.println();
            d = c;
        }
    }

    /**
     * 跳表的节点，每个节点记录了当前节点数据和所在层数数据
     */
    public class Node {
         
        private int data = -1;
        /**
         * 表示当前节点位置的下一个节点所有层的数据，从上层切换到下层，就是数组下标-1，
         * forwards[3]表示当前节点在第三层的下一个节点。
         * 
         * 230620补充：
         * 1. forwards[]表示当前节点的索引层
         * 2. 当前实现，索引层最大高度16，forwards下标为[0,15]
         * 3. forwards[]表示的是链表结构，只不过是数组结构而已，不存储数据，只是实际Node的引用
         * 4. 印象笔记，图-5，【3,7,11,19,22,26,37】，实际Node实例只有6个。
         * 5. 一个data+一个forwards[level]构成一个Node实例
         * 6. forwards[0] -> forwards[0] -> forwards[0] -> ... 得到的就是跳表的原始数据。
         * 7. forwards[0]是原始数据的串联，再往上层，就是跳着连起来的索引层了
         */
        private Node forwards[];


        public Node(int level) {
            forwards = new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(forwards.length);
            builder.append(" }");
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList2 list = new SkipList2();
        list.insert(1, 3);
        list.insert(2, 3);
        list.insert(3, 2);
        list.insert(4, 4);
        list.insert(5, 10);
        list.insert(6, 4);
        list.insert(8, 5);
        list.insert(7, 4);
        // list.printAll_beautiful();
        list.printAll();
        System.out.println(list.find(8));
        list.delete(5);
        System.out.println("delete 5");
        list.printAll();







        /**
         * 结果如下：
         * 									    null:15-------
         * 									    null:14-------
         * 									    null:13-------
         * 									    null:12-------
         * 									    null:11-------
         * 									    null:10-------
         * 										   5:9-------
         * 										   5:8-------
         * 										   5:7-------
         * 										   5:6-------
         * 										   5:5-------
         * 										   5:4-------					 8:4-------
         * 							     4:3-------5:3-------6:3-------7:3-------8:3-------
         * 1:2-------2:2-------		     4:2-------5:2-------6:2-------7:2-------8:2-------
         * 1:1-------2:1-------3:1-------4:1-------5:1-------6:1-------7:1-------8:1-------
         * 1:0-------2:0-------3:0-------4:0-------5:0-------6:0-------7:0-------8:0-------
         * { data: 1; levels: 3 } { data: 2; levels: 3 } { data: 3; levels: 2 } { data: 4; levels: 4 }
         * { data: 5; levels: 10 } { data: 6; levels: 4 } { data: 7; levels: 4 } { data: 8; levels: 5 }
         */
        // 优化后insert()

        // SkipList2 list2 = new SkipList2();
        // list2.insert2(1);
        // list2.insert2(2);
        // list2.insert2(6);
        // list2.insert2(7);
        // list2.insert2(8);
        // list2.insert2(3);
        // list2.insert2(4);
        // list2.insert2(5);
        // System.out.println();
        // list2.printAll_beautiful();


    }

}
