package com.brew.home.tmp.day230612;

import java.util.Random;
import static com.brew.home.geekbang.p1sortAsearch.sort.s5quick.QuickSort.swap;

public class SortPractice4 {
    
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 3, 5, 7, 2, 4, 9, 11, 8};
        System.out.println(find(arr, 0, arr.length-1, 2));
        
    }


    private static int find(int[] arr, int p, int r, int k) {
        int pirot = particationReverse(arr, p, r);
        if(pirot + 1 == k) {
            return arr[pirot];
        } else if (pirot + 1 < k) {
            return find(arr, pirot + 1, r, k);
        } else {
            return find(arr, p, pirot - 1, k);
        }

    }

    private static int particationReverse(int[] arr, int p, int r) {
        int randome = new Random().nextInt(r - p + 1) + p;
        swap(randome, r, arr);

        int i = p;
        int j = p;

        while(j < r) {
            if(arr[j] < arr[r]) {
                j++;
            } else {
                swap(i, j, arr);
                j++;i++;
            }
        }
        swap(i, r, arr);
        return i;
    }

}
