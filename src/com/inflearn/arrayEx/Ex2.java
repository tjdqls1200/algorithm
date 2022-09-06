package com.inflearn.arrayEx;

import java.util.Scanner;

public class Ex2 {
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
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > temp) {
                result++;
                temp = arr[i];
            }
        }
        return result;
    }
}
