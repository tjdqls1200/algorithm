package com.inflearn.dfs;

import java.util.Scanner;

public class 부분집합_바둑이승차 {
    static int C;
    static int n;
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0, 0, arr);
        System.out.println(sum);
    }

    private static void DFS(int L, int temp, int[] arr) {
        if (temp > C) {
            return;
        }
        if (L == n) {
            if (temp > sum) {
                sum = temp;
            }
            return;
        } else {
            DFS(L + 1, temp + arr[L], arr);
            DFS(L + 1, temp, arr);
        }
    }
}
