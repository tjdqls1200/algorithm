package com.inflearn.dfs;

import java.util.Scanner;

public class 조합_구하기 {
    static int n, m;
    static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer = new int[m];
        DFS(0, 1);
    }

    // 1, 2, 3, 4      [ 2]
    private static void DFS(int L, int s) {
        if (L == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                answer[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
