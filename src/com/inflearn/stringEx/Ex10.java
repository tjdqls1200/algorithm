package com.inflearn.stringEx;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        char input2 = in.next().charAt(0);

        for (int i : solution(input1, input2)) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    private static int[] solution(String s, char c) {
        int[] answer = new int[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                answer[i] = 0;
                j = 0;
            } else {
                j++;
                answer[i] = j;
            }
        }
        j = 0;
        for (int i = s.length() - 1; i >=0; i--) {
            if (s.charAt(i) == c) {
                j = 0;
            } else {
                j++;
                answer[i] = Math.min(answer[i], j);
            }
        }
        return answer;
    }
}
