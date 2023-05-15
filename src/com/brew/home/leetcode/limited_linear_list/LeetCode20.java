/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: LeetCode20
 * Author:   feiyi
 * Date:     2020/5/25 9:14 AM
 * Description: 有效的括号
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.brew.home.leetcode.limited_linear_list;



import java.util.Stack;

/**
 * 〈一句话功能简述〉:
 * 〈有效的括号〉
 *
 * @author feiyi
 * @create 2020/5/25
 * @since 1.0.0
 */
public class LeetCode20 {
    /**
     * @param
     * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "()"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: "{[]}"
     * 输出: true
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return: void
     * @since: 2.0.5
     * @Author: feiyi
     * @Date: 2019/7/17 11:52 AM
     **/
    public static void main(String[] args){
       
        //true
        System.out.println(isValid2("{[]}"));
        // true
        System.out.println(isValid2("([][]){{}}"));
        // false
        System.out.println(isValid2("(((([]))}]"));
        // true
        System.out.println(isValid2("()[]{}"));
        // false
        System.out.println(isValid2("(]"));
        // false
        System.out.println(isValid2("}[)]"));
        //false，正确的顺序！！！
        System.out.println(isValid2("([)]"));
    }

    public static boolean isValid2(String origin) {
        //使用Stack来解决这个问题。
        char[] chars = origin.toCharArray();
        Stack<Object> objectStack = new Stack<>();
        char[] charsLeft = new char[]{'(', '[', '{'};
        char[] charsRight = new char[]{')', ']', '}'};
        for (char each : chars) {
            //push if cur char is left
            boolean isLeft = false;
            for (char e1 : charsLeft) {
                if (e1 == each) {
                    isLeft = true;
                    break;
                }
            }

            if (isLeft) {
                objectStack.push(each);
            } else {
                //此时说明是右括号.现在要找到对应的左括号是什么。
                int leftIndex = 0;
                for (int i = 0; i < charsRight.length; i++) {
                    if (charsRight[i] == each) {
                        leftIndex = i;
                        break;
                    }
                }
                char oppositeLeft = charsLeft[leftIndex];
                //1.查看objectstatck中有对应的左括号吗，有的话取出，没有的话直接return false
                //要以正确的顺序闭合，所以直接取栈顶就可以了。
                if (objectStack.empty()) return false;
                boolean yes = ((char) objectStack.pop()) == oppositeLeft;
                if (!yes) return false;//此时说明就没有对应的
            }
        }
        //最后是空的就说明 没问题
        return objectStack.empty();
    }

}
