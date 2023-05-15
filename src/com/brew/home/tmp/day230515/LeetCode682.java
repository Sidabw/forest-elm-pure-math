package com.brew.home.tmp.day230515;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode682 {
    
    public static void main(String[] args) {
        //得：30
        // String[] allScores = Arrays.asList("5", "2", "C", "D", "+").toArray(new String[5]);
        //得：27
        // String[] allScores = Arrays.asList("5","-2","4","C","D","9","+","+").toArray(new String[8]);
        //得：5
        String[] allScores = Arrays.asList("5").toArray(new String[1]);
        int totalScore = getTotalScore(allScores);
        System.out.println(totalScore);
    }

    private static int getTotalScore(String[] allScores) {
        Stack<Integer> realScores = new Stack<>();
        for (String curScore : allScores) {
            if ("+".equals(curScore)) {
                Integer p1 = realScores.pop();
                Integer p2 = realScores.pop();
                Integer p3 = p1 + p2;
                realScores.push(p2);
                realScores.push(p1);
                realScores.push(p3);
            } else if ("D".equals(curScore)) {
                Integer p1 = realScores.pop();
                Integer p2 = p1 * 2;
                realScores.push(p1);
                realScores.push(p2);
            } else if ("C".equals(curScore)) {
                realScores.pop();
            } else {
                realScores.push(Integer.parseInt(curScore));
            }
        }
        int sum =0;
        while(!realScores.empty()) {
            sum += realScores.pop();
        }
        return sum;
    }
}
