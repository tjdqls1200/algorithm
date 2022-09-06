package com.inflearn.arrayEx;

import java.util.Scanner;

public class Ex10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        n = n + 2;
        int[][] arr = new int[n][n];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[][] arr) {
        int answer = 0;
        int temp = 0;

        int[][] bow = new int[n][n];

        System.out.println("n = " + n);
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                temp = arr[i][j];
                if (temp > arr[i][j - 1] && temp > arr[i][j + 1] &&
                        temp > arr[i - 1][j] && temp > arr[i + 1][j]) {
                    answer++;
                    System.out.println("[i][j] = [" + i + "][" + j + "]");
                }
            }
        }
        return answer;
    }
}
