package com.programmers.level2;

public class 멀리_뛰기 {
    static int[][] ch;
    public long solution(int n) {
        long answer = 0;
        ch = new int[n+1][n+1];

        int r = 0;
        int max = n / 2;

        while (r <= max) {
            answer += DFS(n, r);
            n--;
            r++;
        }
        return answer % 1234567;
    }

    private int DFS(int n, int r) {
        if (ch[n][r] != 0)
            return ch[n][r];
        if (n == r || r == 0) {
            return ch[n][r] = 1;
        } else {
            return ch[n][r] = (DFS(n - 1, r - 1) + DFS(n - 1, r)) % 1234567;
        }
    }
}
