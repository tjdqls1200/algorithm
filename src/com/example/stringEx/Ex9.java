package com.example.stringEx;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution(s));
    }

    private static int solution(String str) {
        int answer = 0;
//        1.
//        str = str.replaceAll("[^0-9]", "");
//        answer = Integer.valueOf(str);
        for (char c : str.toCharArray()) {
            if (c>=48 && c<=57) answer = answer*10 + (c - 48);
        }

        return answer;
    }
}
