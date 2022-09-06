package com.inflearn.dfs;

import java.util.Scanner;

public class 중복순열_구하기 {
    static int n, m;
    static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        answer = new int[m];
        DFS(0);
    }

    private static void DFS(int L) {
        if (L == m) {
            for (int num : answer) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                answer[L] = i;
                DFS(L + 1);
            }
        }
    }
}
