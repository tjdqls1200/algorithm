package com.inflearn.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬아일랜드_BFS {
    static int[][] map;
    static int n;
    static int answer = 0;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                    answer++;
                    BFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void BFS(int y, int x) {
        Queue<Pos> queue = new LinkedList<>();

        queue.offer(new Pos(y, x));
        while (!queue.isEmpty()) {
            Pos pos = queue.poll();

            for (int i = 0; i < 8; i++) {
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];

                if (ny >= 0 && ny < n &&
                    nx >= 0 && nx < n &&
                    map[ny][nx] == 1) {

                    map[ny][nx] = 0;
                    queue.offer(new Pos(ny, nx));
                }
            }
        }
    }

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
