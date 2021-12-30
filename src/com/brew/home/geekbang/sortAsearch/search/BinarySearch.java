package com.brew.home.geekbang.sortAsearch.search;

import java.math.BigDecimal;

/**
 * 〈一句话功能简述〉:
 * 〈二分查找【极客时间】〉
 *
 * @author feiyi
 * @create 2020/7/4
 * @since 1.0.0
 */
public class BinarySearch {

    public static void main(String[] args) {
        //元素不重复
        int[] origin = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 12, 15, 18, 29, 36, 58};
        assert binarySearch1(origin, 29) == 11;
        
        //以下测试，元素都是有重复的

        //1.查找第一个值等于给定值的元素
        int[] origin2 = new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        assert binarySearch2(origin2, 8) == 5;
        //2.查找第一个大于等于给定值的元素
        assert binarySearch3(origin2, 7) == 5;
        //3.查找最后一个小于等于给定值的元素
        assert binarySearch4(origin2, 8) == 7;
        //4.
        System.out.println(binarySearch5(5));
        System.out.println("all success!");
    }


    public static int binarySearch1(int[] origin, int target) {
        //基础的二分查找（数组元素不重复）
        int low = 0;
        int high = origin.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (origin[mid] == target) return mid;
            else if (origin[mid] < target) low = mid + 1;
            else if (origin[mid] > target) high = mid - 1;
        }
        return -1;
    }

    public static int binarySearch2(int[] origin, int target){
        //问题：查找第一个值等于给定值的元素(数组内容有重复)
        //思路：找到给定值，判定是否要往前再走一步
        int low = 0;
        int high = origin.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (origin[mid] < target) low = mid + 1;
            else if (origin[mid] > target) high = mid - 1;
            else {
                if ((mid == 0) || origin[mid - 1] != target)
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    
    public static int binarySearch3(int[] origin, int target) {
        //问题：查找第一个大于等于给定值的元素（数组内容有重复）
        //思路：找到给定值，判断是否要往前走一步
        int low = 0;
        int high = origin.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (origin[mid] >= target) {
                if ((mid == 0)||(origin[mid - 1] < target)) return mid;
                else high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearch4(int[] origin, int target) {
        //问题：查找最后一个小于等于给定值的元素（数组内容有重复）
        
        int low = 0;
        int high = origin.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (origin[mid] <= target) {
                //如果我已经是原始有序数组的最后一个元素了，或 我的下一个元素比给定值大了，那就说明我找到了
                if (mid == (origin.length - 1) || origin[mid + 1] > target) {
                    return mid;
                } else{
                    low = mid;
                }
            } else{
                high = mid;
            }
        }

        return -1;
    }

    public static double binarySearch5(int origin) {
        //题目：求一个数的平方根，保留小数点后6位
        //思路：在[0.000000, origin] 内进行二分查找，找到“最后一个小于等于给定值的元素,即（origin）”
        
        //1.构建测试数组
        BigDecimal each = new BigDecimal("0.000000");
        each.setScale(6);
        BigDecimal step = new BigDecimal("0.000001");
        step.setScale(6);

        int arrLen = origin * 1000000;
        BigDecimal[] originArr = new BigDecimal[arrLen + 1];
        for (int i = 0; i <= arrLen; i++) {
            originArr[i] = each;
            each = each.add(step);
            // System.out.println(each.doubleValue());
        }

        //2.开始二分查找
        BigDecimal originDecimal = BigDecimal.valueOf(origin);
        int low = 0;
        int high = arrLen;
        int mid;
        while(low <= high) {
            mid = (low + high)/2;
            System.out.println(mid);
            BigDecimal realOne = originArr[mid].multiply(originArr[mid]);
            if(realOne.compareTo(originDecimal) <= 0) {
                if(mid == arrLen || originArr[mid + 1].multiply(originArr[mid + 1]).compareTo(originDecimal) > 0) {
                    return originArr[mid].doubleValue();
                } else {
                    //FIXME 要是mid已经是0了，这就死循环了
                    low = mid;
                }
            } else {
                high = mid;
            }
        }
        return -1D;
    }

}
