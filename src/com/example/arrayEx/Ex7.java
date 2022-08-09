package com.example.arrayEx;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(n, arr));
    }


    private static int solution(int n, int[] arr) {
        int result = 0;
        int score = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                result += score;
                score++;
            } else {
                score = 1;
            }
        }
        return result;
    }
}
