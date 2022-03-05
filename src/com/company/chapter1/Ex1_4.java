package com.company.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex1_4 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = in.next();
        }
        String[] result = solution(n, words);
        for (String word : result) {
            System.out.println(word);
        }
    }

    private static String[] solution(int n, String[] words) {
        for (int i = 0; i < n; i++) {
//            StringBuilder sb = new StringBuilder(words[i]);
//            words[i] = sb.reverse().toString();
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }
        return words;
    }
}

