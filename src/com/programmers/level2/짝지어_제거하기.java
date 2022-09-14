package com.programmers.level2;

import java.util.Stack;

public class 짝지어_제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                if (stack.peek() == chars[i]) {
                    stack.pop();
                } else
                    stack.push(chars[i]);
            }
        }
        return (stack.isEmpty()) ? 1 : 0;
    }
}
