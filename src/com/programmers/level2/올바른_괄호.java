package com.programmers.level2;

import java.util.Stack;

public class 올바른_괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            // 다음 문자가 ')' 인데 스택도 비어있지 않고 '(' 쌍이 맞을 경우 pop
            else if (!stack.isEmpty() && stack.peek() == '(')  {
                stack.pop();
            }
            // 다음 문자가 ')' 인데 스택이 비어있거나 '(' 쌍이 맞지 않을 경우 return
            else {
                return false;
            }
        }
        // pop 되지 않은 '(' 가 있는 경우 false
        if (!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}
