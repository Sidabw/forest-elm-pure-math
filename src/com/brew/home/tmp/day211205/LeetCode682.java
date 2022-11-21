package com.brew.home.tmp.day211205;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author shaogz
 */
public class LeetCode682 {

    /**
     * 特殊制棒球比赛
     * <p> 整数 x - 表示本回合新获得分数 x
     * <p> "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
     * <p> "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
     * <p> "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数
     * @param args args
     * @return: void
     * @Author: shaogz
     * @Date: 2021/12/5 11:13 AM
     **/
    public static void main(String[] args) {
        String[] allScores = Arrays.asList("5", "2", "C", "D", "+").toArray(new String[5]);
        // String[] allScores = Arrays.asList("5","-2","4","C","D","9","+","+").toArray(new String[8]);
        // String[] allScores = Arrays.asList("5").toArray(new String[1]);
        int totalScore = getTotalScore(allScores);
        System.out.println(totalScore);
    }

    private static int getTotalScore(String[] allScores) {
        Stack<Integer> allScoresInStack = new Stack<>();

        for (String eachFlag : allScores) {
            if ("C".equals(eachFlag)) {
                allScoresInStack.pop();
            } else if ("D".equals(eachFlag)) {
                Integer topScore = allScoresInStack.peek();
                allScoresInStack.push(topScore * 2);
            } else if ("+".equals(eachFlag)) {
                Integer pop1 = allScoresInStack.pop();
                Integer pop2 = allScoresInStack.pop();
                Integer cur = pop1 + pop2;
                allScoresInStack.push(pop2);
                allScoresInStack.push(pop1);
                allScoresInStack.push(cur);
            } else {
                allScoresInStack.push(Integer.parseInt(eachFlag));
            }
        }

        int totalScore = 0;
        while (!allScoresInStack.empty()) {
            totalScore+=allScoresInStack.pop();
        }
        return totalScore;
    }

}
