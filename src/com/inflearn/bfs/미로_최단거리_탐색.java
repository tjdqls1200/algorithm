package com.inflearn.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_최단거리_탐색 {
    static int[][] map;
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

        System.out.println(BFS());
    }

    private static int BFS() {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(1, 1, 0));
        while (!queue.isEmpty()) {
            int len = queue.size();
            Pos pos = queue.poll();
            if (pos.x == 7 && pos.y == 7) {
                return pos.move;
            }
            for (int j = 0; j < len; j++) {
                for (int i = 0; i < 4; i++) {
                    int ny = pos.y + dy[i];
                    int nx = pos.x + dx[i];

                    if (ny >= 1 && ny <= 7 &&
                        nx >= 1 && nx <= 7 &&
                        map[ny][nx] == 0) {
                        map[ny][nx] = 1;
                        queue.offer(new Pos(ny, nx, pos.move + 1));
                    }
                }
            }
        }
        return -1;
    }

    private static class Pos {
        int y;
        int x;
        int move;

        public Pos(int y, int x, int move) {
            this.y = y;
            this.x = x;
            this.move = move;
        }
    }
}
