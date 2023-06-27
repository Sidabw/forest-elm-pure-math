package com.brew.home.tmp.day230627;

import java.util.LinkedList;
import java.util.Queue;

import com.brew.home.geekbang.p3tree.binary.Node;
import com.brew.home.geekbang.p3tree.binary.b1.B1BinaryTree;
import com.brew.home.geekbang.p3tree.binary.b2.B2BinarySearchTree;

public class BinarySearchTreePractice {
    
    public static void main(String[] args) {
        Node root = B2BinarySearchTree.buildBinarySearchTree();
        System.out.print("前序遍历：");
        preOrder(root);
        System.out.println();

        System.out.print("中序遍历：");
        inOrder(root);
        System.out.println();

        System.out.print("后序遍历：");
        postOrder(root);
        System.out.println();

        System.out.print("层级遍历：");
        levelOrder(root);
        System.out.println();



        System.out.print("原始顺序：");
        B1BinaryTree.inOrder(root);
        System.out.println();

        delete230627(root, 12);
        System.out.print("删除12后：");
        
        B1BinaryTree.inOrder(root);
        System.out.println();

        System.out.print("查找17：" + search230627(root, 17));
        System.out.println();

        insert230627(root, 1);
        System.out.print("插入1后：");
        B1BinaryTree.inOrder(root);
        System.out.println();

    }

    private static void preOrder(Node cur) {
        if (cur == null) {
            return;
        }
        System.out.print(cur.value + ",");
        preOrder(cur.left);
        preOrder(cur.right);
    }

    private static void inOrder(Node cur) {
        if (cur == null) {
            return;
        }
        inOrder(cur.left);
        System.out.print(cur.value + ",");
        inOrder(cur.right);
    }

    private static void postOrder(Node cur) {
        if (cur == null) {
            return;
        }
        postOrder(cur.left);
        postOrder(cur.right);
        System.out.print(cur.value + ",");
    }

    private static void levelOrder(Node root) {
        //使用原始队列offerLast,pollFirst实现逐层遍历
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node tmp;
        while((tmp = queue.poll())!=null) {
            System.out.print(tmp.value + ",");
            queue.offer(tmp.left);
            queue.offer(tmp.right);
        }
    }


    private static Node search230627(Node root, int target) {
        Node tmp = root;
        while (tmp != null) {
            if(tmp.value == target) {
                return tmp;
            } else if (tmp.value > target) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        return null;
    }

    private static void insert230627(Node root, int toInsert) {
        Node tmp = root;
        Node previous = root;
        while (tmp != null) {
            previous = tmp;
            if(toInsert < tmp.value) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }

        if(toInsert < previous.value) {
            previous.left = new Node(toInsert);
        } else {
            previous.right = new Node(toInsert);
        }
    }

    private static void delete230627(Node root, int target) {
        //先找到当前节点和当前节点的前驱
        Node tmp = root;
        Node targetNode = null;
        Node targetPrevious = null;
        while(true) {
            if(target < tmp.value) {
                targetPrevious = tmp;
                tmp = tmp.left;
            } else if (target > tmp.value){
                targetPrevious = tmp;
                tmp = tmp.right;
            } else {
                targetNode = tmp;
                break;
            }
        }

        if (targetNode == null) {
            System.out.println("unmatch");
            return;
        }
        //先处理简单的1，targetNode是叶子节点
        if(targetNode.left == null && targetNode.right == null) {
            if(target<targetPrevious.value) {
                targetPrevious.left = null;
            } else {
                targetPrevious.right = null;
            }
            return;
        }
        //再处理简单的2，targetNode只有一个子节点
        if(targetNode.left != null && targetNode.right == null) {
            if(target<targetPrevious.value) {
                targetPrevious.left = targetNode.left;
            } else {
                targetPrevious.right = targetNode.left;
            }
            return;
        } else if (targetNode.left == null && targetNode.right != null) {
            if(target<targetPrevious.value) {
                targetPrevious.left = targetNode.right;
            } else {
                targetPrevious.right = targetNode.right;
            }
            return;
        }
        //再处理稍微麻烦点的3，targetNode有两个子节点
        //此时要去找到右叉的最小节点，替换现有的targetNode
        Node minInRight = targetNode.right;
        Node minInRightPrevious = targetNode.right;
        while(minInRight.left != null) {
            minInRightPrevious = minInRight;
            minInRight = minInRight.left;
        }
        minInRightPrevious.left = null;

        minInRight.right = targetNode.right;
        minInRight.left = targetNode.left;  
        if(target<targetPrevious.value) {
            targetPrevious.left = minInRight;
        } else {
            targetPrevious.right = minInRight;
        }   

    }
}
