package com.brew.home.geekbang.p3tree.binary;

/**
 * @author shaogz
 */
public class Node {

    public int value;

    public Node left;

    public Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
    }

}
