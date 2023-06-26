package com.brew.home.tmp.day230626;

import java.util.HashMap;
import java.util.Map;

public class LeetCode8 {
    
    public static void main(String[] args) {
        //状态机/自动机的这个还是挺有意思
        //根据当前输入的不同，状态s转变成状态b、状态c或状态s
        //
        System.out.println(new LeetCode8().myAtoi("    999   "));
        System.out.println(new LeetCode8().myAtoi("   -42"));
        System.out.println(new LeetCode8().myAtoi("4193 with words"));
        System.out.println(new LeetCode8().myAtoi("   -4193 with words"));
    }


    private final Map<StateEnum,StateEnum[]> stateMap = new HashMap<StateEnum,StateEnum[]>(){{
        put(StateEnum.START, new StateEnum[]{StateEnum.START,StateEnum.SIGNED,StateEnum.IN_NUM,StateEnum.END});
        put(StateEnum.IN_NUM, new StateEnum[]{StateEnum.END,StateEnum.END,StateEnum.IN_NUM,StateEnum.END});
        put(StateEnum.SIGNED, new StateEnum[]{StateEnum.END,StateEnum.END,StateEnum.IN_NUM,StateEnum.END});
        put(StateEnum.END, new StateEnum[]{StateEnum.END,StateEnum.END,StateEnum.END,StateEnum.END});
    }};

    private int sign = 1;

    private long ans = 0;

    private StateEnum state = StateEnum.START;


    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            state = stateMap.get(state)[getState(cur)];
            if (state == StateEnum.SIGNED) {
                sign = cur == '+' ? 1 : -1;
            } else if (state == StateEnum.IN_NUM) {
                ans = ans * 10 + (cur - '0');//进位
                ans = sign == 1 ? Math.min(ans, (long)Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
                // ans = sign == 1 ? Math.min(ans, (long)Integer.MAX_VALUE) : Math.min(ans, -(long)Integer.MIN_VALUE);
            }
        }
        return (int)(sign * ans);
    }

    private int getState(char c) {
        if (c == ' ') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if(Character.isDigit(c)) {
            return 2;
        } else {
            return 3;
        }
    }


    
    private static enum StateEnum {
        START,SIGNED,IN_NUM,END
    }


}

