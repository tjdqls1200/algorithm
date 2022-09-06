package com.inflearn.arrayEx;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n + 1];

        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[] arr) {
        int result = 0;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                result++;
                for (int j = i; j <= n; j += i) arr[j] = 1;
            }
        }
        return result;
    }
}
