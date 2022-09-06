package com.inflearn.dfs;

import java.util.*;

public class 동전교환_DFS {
    static int m, n;
    static int answer = Integer.MAX_VALUE;
    static Integer[] coins;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder());
        m = sc.nextInt();
        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int L, int sum) {
        if (sum > m)
            return;
        if (answer <= L)
            return;
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + coins[i]);
            }
        }
    }
}
