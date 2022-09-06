package com.inflearn.arrayEx;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int x : solution(n)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(int n) {
        int[] result = new int[n];

        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result;
    }
}
