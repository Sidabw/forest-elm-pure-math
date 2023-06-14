package com.brew.home.tmp.day230614;

public class SortPractice6 {
    
    public static void main(String[] args) {
        
    }




    private static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int place = 1; max/place>0;place*=10) {
            courtingSort(arr, place);
        }

    }

    private static void courtingSort(int[] arr, int place) {
        //part-1
        int[] tmp = new int[10];
        for(int i = 0; i < arr.length; i++) {
            tmp[(arr[i]/10)%10]++;
        }

        //part-2
        for(int i = 1; i < tmp.length; i++) {
            tmp[i]+=tmp[i-1];
        }

        //part-3
        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[tmp[(arr[i] / place) % 10] - 1] = arr[i];
            tmp[(arr[i] / place) % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
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
