package com.example.cp3;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

    private static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int temp = 0;
        int sum = 0;


        for (int i = 0; i < k; i++) {
            temp += arr[i];
        }
        answer = temp;
        for (int i = k; i < n; i++) {
            temp += (arr[k] - arr[i - k]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
