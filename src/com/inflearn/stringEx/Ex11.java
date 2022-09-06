package com.inflearn.stringEx;

import java.util.Scanner;

public class Ex11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }

    private static String solution(String s) {
        char temp;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        temp = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (temp != s.charAt(i)) {
                sb.append(temp);
                temp = s.charAt(i);
                if (count > 1) {
                    sb.append(count);
                    count = 1;
                }
            } else {
                count++;
            }
        }
        if (temp == s.charAt(s.length() - 1)) {
            sb.append(temp);
            sb.append(count);
        }
        return sb.toString();
    }
}
