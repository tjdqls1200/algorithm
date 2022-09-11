package com.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    static int L;
    static boolean flag = false;
    static int[][] ch;

    public int solution(int n, int[][] computers) {
        ch = new int[n][n];
        L = 1;
        for (int i = 0; i < n; i++) {
            flag = false;
            BFS(i, n, computers);
            if (flag)
                L++;
        }
        return L - 1;
    }

    private static void BFS(int i, int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int j = 0; j < n; j++) {
                if (computers[p][j] == 1 && ch[p][j] == 0) {
                    flag = true;
                    ch[p][j] = L;
                    ch[j][p] = L;
                    queue.offer(j);
                }
            }
        }
    }
}