package com.inflearn.dfs;

import java.util.Scanner;

public class 부분집합_합이_같은 {
    static String answer = "NO";
    static int n;
    static int total = 0;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        DFS(0, 0, arr);
        System.out.println(answer);
    }

    private static void DFS(int L, int sum, int[] arr) {
        if (flag || (sum > total/2)) return;
        if (L == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }
}