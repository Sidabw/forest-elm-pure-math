/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode26
 * Author:   feiyi
 * Date:     2020/5/25 9:15 AM
 * Description: 删除排序数组中的重复项
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.leetcode;



/**
 * 〈一句话功能简述〉:
 * 〈删除排序数组中的重复项〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode26 {

    /**
     * @param
     * @Description 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * <p>
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * <p>
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 说明:
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢?
     * <p>
     * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * <p>
     * 你可以想象内部操作如下:
     * <p>
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     * <p>
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @since 2.0.5
     * @author feiyi
     *  2019/7/17 9:26 PM
     **/
    public static void main(String[] args){
        //[],
        //        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        //        int[] nums = new int[]{0, 0, 0};
        //        int[] nums = new int[]{1, 1, 2};
        int[] nums = new int[]{1, 2};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curOut = nums[0];
        int outIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            int curIn = nums[i];
            if (curIn != curOut) {
                outIndex++;
                nums[outIndex] = curIn;
                curOut = curIn;
            }
        }
        for (int i = 0; i < outIndex + 1; i++) {
            System.out.println(nums[i]);
        }
        return outIndex + 1;
    }

}
