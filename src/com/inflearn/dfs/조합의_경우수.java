package com.inflearn.dfs;

import java.util.Scanner;

public class 조합의_경우수 {
    static int[][] memory;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        memory = new int[n + 1][r + 1];
        //nCr = (n-1)C(r-1) + (n-1)Cr
        System.out.println(DFS(n, r));
    }

    private static int DFS(int n, int r) {
        if (n == r || r == 0) {
            memory[n][r] = 1;
            return 1;
        } else {
            return memory[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }
    }
}
