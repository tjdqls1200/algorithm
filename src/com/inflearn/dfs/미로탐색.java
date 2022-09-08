package com.inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int[][] map;
    static int answer = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[8][8];
        for (int i = 1; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 1;
            while (st.hasMoreTokens()) {
                map[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        map[1][1] = 1;
        DFS(1, 1);
        System.out.println(answer);
    }

    private static void DFS(int y, int x) {
        if (y == 7 && x == 7) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 1 && ny <= 7 &&
                        nx >= 1 && nx <= 7 &&
                        map[ny][nx] == 0) {
                    map[ny][nx] = 1;
                    DFS(ny, nx);
                    map[ny][nx] = 0;
                }
            }
        }
    }
}

