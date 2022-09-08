package com.inflearn.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
    static int n, m;
    static int[][] map;
    static int[][] ch;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        ch = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();
        int answer = 0;
        boolean flag = true;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] == 0) {
                    answer = - 1;
                    flag = false;
                }
            }
        }
        if (flag) {
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (answer < ch[y][x]) {
                        answer = ch[y][x];
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean check() {
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void BFS() {
        Queue<Pos> queue = new LinkedList<>();

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (map[y][x] == 1) {
                    queue.offer(new Pos(y, x));
                }
            }
        }
        boolean flag;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];

                if (ny >= 0 && ny < m &&
                        nx >= 0 && nx < n) {
                    if (map[pos.y][pos.x] == 1 &&
                        map[ny][nx] == 0) {

                        map[ny][nx] = 1;
                        ch[ny][nx] = ch[pos.y][pos.x] + 1;
                        queue.offer(new Pos(ny, nx));
                    }
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
