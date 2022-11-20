package com.brew.home.geekbang.p1sortAsearch.sort.z_others.s9_1pseudo;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author shaogz
 */
public class PseudoSortDemo1 {

    /**
     * <p> 假设我们现在需要对 D，a，F，B，c，A，z 这个字符串进行排序，
     * <p> 要求将其中所有小写字母都排在大写字母的前面，但小写字母内部和大写字母内部不要求有序。
     * <p> 比如经过排序之后为 a，c，z，D，F，B，A，这个如何来实现呢？
     * @param args args
     */
    public static void main(String[] args) {
        pseudo1();
        pseudo2();
    }

    /**
     * 使用桶的思想来解决
     */
    private static void pseudo2() {
        System.out.println("神奇的桶排思想⬇️");
        char[] origin = {'D', 'a', 'F', 'B', 'c', 'A', 'z'};

        LinkedList<Character> lowercaseList = new LinkedList<>();
        LinkedList<Character> uppercaseList = new LinkedList<>();

        for (char each : origin) {
            if (isLowercase(each)) {
                lowercaseList.add(each);
            } else {
                uppercaseList.add(each);
            }
        }

        lowercaseList.forEach(System.out::println);
        uppercaseList.forEach(System.out::println);
    }

    /**
     * <p> 双指针、类似快排的分区；
     * <p> 指针a之前的表示小写。指针b往前走，碰到大写的继续往前走，碰到小写的了，a、b互换，同时a往前走一步、b也继续往前走一步。
     */
    private static void pseudo1() {
        char[] origin = {'D', 'a', 'F', 'B', 'c', 'A', 'z'};
        int i = 0;
        int j = 0;
        while(j < origin.length) {
            if (isLowercase(origin[j])) {
                swap(i++, j++, origin);
            } else {
                j++;
            }
        }
        System.out.println(Arrays.toString(origin));
    }

    private static boolean isLowercase(char c) {
        int ascII = (int)c;
        return ascII >= 97 && ascII <= 122;
    }

    public static void swap(int i, int j, char[] arr) {
        char t;
        t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }


}
