package com.example.search;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0;
        int rt = arr.length - 1;
        Arrays.sort(arr);

        while (lt <= rt) {
            int pt = (lt + rt) / 2;

            if (arr[pt] > m) {
                rt = pt - 1;
            } else if (arr[pt] < m) {
                lt = pt + 1;
            } else {
                answer = pt + 1;
                break;
            }
        }
        if (lt == rt && arr[lt] != m)
            answer = -1;
        return answer;
    }
}
