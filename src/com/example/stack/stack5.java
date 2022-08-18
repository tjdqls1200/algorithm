package com.example.stack;

import java.util.Scanner;
import java.util.Stack;

public class stack5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        int cnt = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '(') {
                if (chars[i + 1] == '(') { // 막대기
                    stack.push(chars[i]);
                } else if (chars[i + 1] == ')') {
                    cnt += stack.size();
                }
            } else if (chars[i - 1] != '(') {
                stack.pop();
                cnt++;
            }
        }
        if (!stack.empty())
            cnt++;
        return cnt;
    }
}
