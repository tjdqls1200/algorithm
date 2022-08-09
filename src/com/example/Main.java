package com.example;
import java.util.*;

class Main {
    public String solution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String temp = new StringBuilder(str).reverse().toString();
        if (!str.equals(temp)) return "NO";

        return "YES";
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(T.solution(s));
    }
}