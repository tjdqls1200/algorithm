package com.inflearn.arrayEx;

import java.util.Scanner;

public class Ex11  {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[][] arr) {
        int answer = 0;
        int temp;
        int high = 0;
        for (int k = 0; k < n; k++) {
            temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 5; j++) {
                    if (arr[k][j] == arr[i][j]) {
                        temp++;
                        break;
                    }
                }
            }
            if (temp > high) {
                high = temp;
                answer = k + 1;
            }
        }

        return answer;
    }

}
