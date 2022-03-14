package com.company.chapter1;

import java.util.Scanner;

public class Ex1_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution(s));
    }

    private static String solution(String str) {
        int start = 0;
        int end = str.length() - 1;
        str = str.toUpperCase();
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return "NO";
            }
            start++;
            end--;
        }
        return "YES";
    }

}
