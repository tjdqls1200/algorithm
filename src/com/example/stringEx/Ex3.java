package com.example.stringEx;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(solution(str));
        //System.out.println(solution2(str));
    }

    private static String solution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        int pos;

        while ((pos = str.indexOf(' ')) != -1) {
            String temp = str.substring(0, pos);
            int len = temp.length();
            if (m < len) {
                m = len;
                answer = temp;
            }
            str = str.substring(++pos);
        }
        if (str.length() > m) {
            answer = str;
        }
        return answer;
    }


    private static String solution2(String str) {
        String answer="";
        String[] strings = str.split(" ");

        int temp = strings[0].length();
        int result = 0;

        for (int i = 1; i < strings.length; i++) {
            if (strings[i].length() > temp) {
                temp = strings[i].length();
                result = i;
            }
        }
        return strings[result];
    }
}
