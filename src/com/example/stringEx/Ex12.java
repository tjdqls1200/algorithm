package com.example.stringEx;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        System.out.println(solution(n, s));
    }

    public static String solution(int n, String str) {
        StringBuilder sb = new StringBuilder();
        double num = 0;
        int i = 0;
        for (;n > 0; n--) {
            for (int j = 6; j >= 0; j--) {
                if (str.charAt(i) == '#') {
                    num += Math.pow(2, j);
                }
                i++;
            }
            sb.appendCodePoint((int)num);
            num = 0;
        }
        return sb.toString();
    }
}
