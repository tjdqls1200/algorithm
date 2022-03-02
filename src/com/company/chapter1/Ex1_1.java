package com.company.chapter1;
import java.util.*;

class Ex1_1 {
    public static int solution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for (char c : str.toCharArray()) {
            if (c == t) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char t = in.nextLine().charAt(0);
        System.out.println(solution(str, t));
    }
}