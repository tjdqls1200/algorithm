package com.company.chapter1;

import java.util.Scanner;

public class Ex1_9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution(s));
    }

    private static int solution(String str) {
        int answer = 0;
        str.replaceAll("[^0-9]","");
        return answer;
    }
}
