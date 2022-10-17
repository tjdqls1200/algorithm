package com.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15651 {
    static boolean[] ch;
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        ch = new boolean[n + 1];

        DFS(0, arr);
        System.out.println(sb.toString());
    }

    private static void DFS(int L, int[] arr) {
        if (L == m) {
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[L] = i;
            DFS(L + 1, arr);
        }
    }
}
