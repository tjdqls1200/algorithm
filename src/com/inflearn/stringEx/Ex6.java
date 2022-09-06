package com.inflearn.stringEx;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution(s));
    }

    private static StringBuilder solution(String str) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == i) {
                answer.append(c);
            }
        }
        return answer;
    }

}
