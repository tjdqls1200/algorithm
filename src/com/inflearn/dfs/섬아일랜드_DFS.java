package com.inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬아일랜드_DFS {
    static int[][] map;
    static int[][] ch;
    static int n;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, - 1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        ch = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    if (ch[i][j] == 0) {
                        ch[i][j] = 1;
                        answer++;
                    }
                    DFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void DFS(int y, int x) {
        if (map[y][x] == 0) {
            return;
        } else {
            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n &&
                    map[ny][nx] == 1 && ch[ny][nx] == 0) {
                    ch[ny][nx] = 1;
                    DFS(ny, nx);
                }
            }
        }
    }
}
