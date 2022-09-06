package com.inflearn.arrayEx;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[][] arr) {
        int result = 0;
        int sum1, sum2;

        for (int i = 0; i < n; i++) {
            sum1=sum2=0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            result = Math.max(result, sum1);
            result = Math.max(result, sum2);
        }
        sum1=sum2=0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - 1 - i];
        }
        result = Math.max(result, sum1);
        result = Math.max(result, sum2);

        return result;
    }
}
