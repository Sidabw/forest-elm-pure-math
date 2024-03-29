/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode844
 * Author:   feiyi
 * Date:     2020/5/28 2:37 PM
 * Description: 比较含退格的字符串
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.leetcode.limited_linear_list;



import java.util.Stack;

/**
 * 〈一句话功能简述〉:
 * 〈比较含退格的字符串〉
 *
 * @author feiyi
 * @create 2020/5/28
 * @since 1.0.0
 */
public class LeetCode844 {


    /**
     * @param
     * @Description 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * 示例 1：
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * <p>
     * 示例 2：
     * 输入：S = "ab##", T = "c#d#"
     * 输出：true
     * 解释：S 和 T 都会变成 “”。
     * <p>
     * 示例 3：
     * 输入：S = "a##c", T = "#a#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “c”。
     * <p>
     * 示例 4：
     * 输入：S = "a#c", T = "b"
     * 输出：false
     * 解释：S 会变成 “c”，但 T 仍然是 “b”。
     * 提示：
     * 1 <= S.length <= 200
     * 1 <= T.length <= 200
     * S 和 T 只含有小写字母以及字符 '#'。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/backspace-string-compare
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * @since 2.0.5
     * @author feiyi
     *  2020/5/28 2:39 PM
     **/
    public static void main(String[] args){
        //true
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        //true
        System.out.println(backspaceCompare("ab##", "c#d#"));
        //true
        System.out.println(backspaceCompare("a##c", "#a#c"));
        //false
        System.out.println(backspaceCompare("a#c", "b"));
    }

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        char[] chars = S.toCharArray();
        for (char each : chars) {
            if (each == '#') {
                if (!s1.empty())
                    s1.pop();
            } else {
                s1.push(each);
            }
        }

        char[] chars2 = T.toCharArray();
        for (char each : chars2) {
            if (each == '#') {
                if (!s2.empty())
                    s2.pop();
            } else {
                s2.push(each);
            }
        }
        if (s1.empty() && s2.empty()) return true;
        if (s1.size() != s2.size()) return false;
        while (!s1.empty()) {
            Character tmp1 = s1.pop();
            Character tmp2 = s2.pop();
            if (!tmp1.equals(tmp2)) return false;
        }
        return true;
    }




    public static boolean backspaceCompare2(String S, String T) {
        //参考官方题解中的双指针+计数器
        //目的在于如何时间复杂度O(n)，空间复杂度O(1)解决该问题。

        //一个字符会不会被‘退格’掉，只看后面有没有#号，而不用管前面。
        //所以可以倒叙遍历
        //S遇到#，则计数器+1，其他则计数器-1，到0停下
        //T同上
        //比较此时此刻S的当前字符和T的当前字符是否相同，不相同则直接结束
        //相同则进入下一轮



        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                //这一轮结束了，比较下
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                //这种情况肯定是返回失败。相当于是S都减完了，你T还余下好多字符。
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
