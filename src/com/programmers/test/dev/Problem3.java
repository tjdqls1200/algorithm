package com.programmers.test.dev;

import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {
    static int[][] map;
    static boolean[][] open;
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int score = 0;

    public int solution(int N, int[][] mine, int[] P) {
        map = new int[N + 1][N + 1];
        open = new boolean[N + 1][N + 1];

        for (int[] m : mine) {
            int my = m[0];
            int mx = m[1];
            map[my][mx] = Integer.MIN_VALUE;
            for (int i = 0; i < 8; i++) {
                int ny = my + dy[i];
                int nx = mx + dx[i];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                    map[ny][nx]++;
                }
            }
        }
        BFS(N, P);
        return score;
    }
    private void BFS(int n, int[] P) {
        Queue<Pos> player = new LinkedList<>();
        player.offer(new Pos(P[0], P[1]));
        open[P[0]][P[1]] = true;
        score++;

        while (!player.isEmpty()) {
            int len = player.size();
            for (int l = 0; l < len; l++) {
                Pos pos = player.poll();
                for (int i = 0; i < 8; i++) {
                    int ny = pos.y + dy[i];
                    int nx = pos.x + dx[i];
                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                        if (open[ny][nx] || map[ny][nx] < 0)
                            continue;
                        if (map[ny][nx] == 0)
                            player.offer(new Pos(ny, nx));
                        open[ny][nx] = true;
                        score++;
                    }
                }
            }
        }
    }

    private class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
