package com.inflearn.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().trim().toCharArray();
        System.out.println(solution(chars));
    }

    // test commit log
    //
    private static String solution(char[] s) {
        Stack<Character> stack = new Stack<>();
        String answer = "NO";
        for (char ch : s) {
            if (ch == '(') {
                stack.push(ch);
                continue;
            }
            if (stack.empty())
                return answer;
            stack.pop();
        }
        if (stack.empty()) {
            answer = "YES";
        }
        return answer;
    }
}