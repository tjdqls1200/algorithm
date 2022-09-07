package com.inflearn.dfs;

import java.util.Scanner;

public class 수열_추측하기 {
    static int n, f;
    static int[] comb;
    static int[] ch;
    static int[] answer;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        f = sc.nextInt();

        ch = new int[n + 1];
        comb = new int[n];
        answer = new int[n];
        for (int i = 0; i < n; i++) {
            comb[i] = combDfs(n - 1, i);
        }
        DFS(0, 0);
        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int combDfs(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        } else {
            return combDfs(n - 1, r - 1) + combDfs(n - 1, r);
        }
    }

    private static void DFS(int L, int sum) {
        if (flag) {
            return;
        }
        if (L == n) {
            if (sum == f) {
                flag = true;
            }
            return;
        } else {
            for (int i = 1; i <= n; i++) {

                if (ch[i] == 0) {
                    ch[i] = 1;
                    if (!flag)
                        answer[L] = i;
                    DFS(L + 1, sum + (answer[L] * comb[L]));
                    ch[i] = 0;
                }
            }
        }
    }
}
