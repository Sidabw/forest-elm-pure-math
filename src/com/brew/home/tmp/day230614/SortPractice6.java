package com.brew.home.tmp.day230614;

public class SortPractice6 {
    
    public static void main(String[] args) {
        
    }




    private static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int place = 1; max/place>0;place*=10) {
            courtingSort(arr, arr.length, place);
        }

    }

    private static void courtingSort(int[] arr, int n, int place) {
        //...
    }

    

    private static int getMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

}
