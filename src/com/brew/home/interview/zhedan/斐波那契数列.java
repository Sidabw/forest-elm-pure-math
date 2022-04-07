package com.brew.home.interview.zhedan;

/**
 * @author shaogz
 */
public class 斐波那契数列 {

    public static void main(String[] args) {
        System.out.println(getRes(10));
    }

    public static int getRes(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        return getRes(num - 1) + getRes(num  - 2);
    }
}
