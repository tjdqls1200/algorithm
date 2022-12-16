package com.programmers.level3;

public class 네트워크 {
    static boolean[] network;
    static int[][] computers;

    public int solution(int n, int[][] computer) {
        computers = computer;
        network = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!network[i]) {
                count++;
            }
            dfs(n, i);
        }

        return count;
    }

    private void dfs(int n, int i) {
        network[i] = true;

        for (int j = 0; j < n; j++) {
            if (!network[j] && computers[i][j] == 1) {
                dfs(n, j);
            }
        }
    }
}