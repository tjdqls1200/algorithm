package com.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2468 {
    static int[][] map;
    static boolean[][] ch;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        ch = new boolean[n][n];
        int H = 1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > H) {
                    H = map[i][j];
                }
            }
        }

        int max = 1;
        for (int h = 1; h < H; h++) {
            max = Math.max(max, flooded(h));
            for (int i = 0; i < n; i++) {
                Arrays.fill(ch[i], false);
            }
        }
        System.out.println(max);
    }


    private static int flooded(int h) {
        int cnt = 0;
        for (int y = 0;  y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] > h && !ch[y][x]) {
                    ch[y][x] = true;
                    safeArea(h, y, x);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void safeArea(int h, int y, int x) {
        int my, mx;
        for (int i = 0; i < 4; i++) {
            my = y + dy[i];
            mx = x + dx[i];
            if (my < 0 || my == n || mx < 0 || mx == n ||
                    ch[my][mx] || map[my][mx] <= h) {
                continue;
            }
            ch[my][mx] = true;
            safeArea(h, my, mx);
        }
    }
}
