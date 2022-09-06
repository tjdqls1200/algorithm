package com.inflearn.stringEx;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        char[] array = s.toCharArray();
        int lt = 0;
        int rt = s.length() - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(array[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(array[rt])) {
                rt--;
            } else {
                char temp = array[lt];
                array[lt] = array[rt];
                array[rt] = temp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(array);
    }
}
