package com.company.chapter1;

import java.util.Scanner;

public class Ex1_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution(s));
    }

    private static String solution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String temp = new StringBuilder(str).reverse().toString();

        if (!str.equals(temp)) return "NO";

        return "YES";
    }
}
