package com.brew.home.tmp.day230618;

public class SearchPractice {
    
    public static void main(String[] args) {
        int[] origin2 = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        search1(origin2, 8);
        search2(origin2, 7);
        search3(origin2, 7);
    }

    //数组有重复，查找第一个等于
    private static void search1(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while(low <= high) {
            mid = (low + high)/2;
            if(arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                if(mid == 0 || arr[mid-1] < target) {
                    System.out.println(mid);
                    return;
                } else {
                    high = mid;
                }
            }
        }
    }

    //数组有重复，查找第一个大于等于
    private static void search2(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while(low <= high) {
            mid = (low + high)/2;
            if(arr[mid] < target) {
                low = mid + 1;
            } else {
                if(mid == 0 || arr[mid-1] < target) {
                    System.out.println(mid);
                    return;
                } else {
                    high = mid -1;
                }
            }
        }
    }

    //数组有重复，查找第一个小于等于
    private static void search3(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while(low<=high) {
            mid = (low + high)/2;
            if(arr[mid] > target) {
                high = mid - 1;
            } else {
                if(mid == arr.length - 1 || arr[mid + 1] > target) {
                    System.out.println(mid);
                    return;
                } else {
                    low = mid + 1;
                }
            }
        }

    }


}
