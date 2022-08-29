package com.example.stack;

import java.util.Scanner;
import java.util.Stack;

public class Stack4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        System.out.println(solution(chars));
    }

    private static int solution(char[] chars) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : chars) {
        //  if (ch >= '0' && ch <= '9') 대신 Character.isDigit()
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(calculate(num1, num2, ch));
            }
        }
        return stack.pop();
    }

    private static int calculate(int num1, int num2, char ch) {
        switch (ch) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }
}
