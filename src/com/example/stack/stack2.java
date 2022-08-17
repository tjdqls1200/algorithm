package com.example.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class stack2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(solution(s));
    }

    private static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                continue;
            }
            if (!stack.empty()) {
                if (ch == ')')
                    stack.pop();
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
