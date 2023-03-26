package com.brew.home.leetcode.list;

public class LeetCode15 {

    public static void main(String[] args) {
        //最笨的：三重for循环遍历所有元素,拿到所有3元组后再判重

        //改造一：先排序，后在3重for循环下使用双指针。
        //a + b + c = 0
        //下一个b1元素，因为b1>b，所以如果存在c1使得a+b1+c1=0的话，那么c1<c
        //双指针：双重for循环，但是一重和二重并不是简单的并行关系，而是有"相互关系"此时考虑能否双指针

        System.out.println(1);

    }
}
