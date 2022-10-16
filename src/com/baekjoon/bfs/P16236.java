package com.baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16236 {
    static int[][] map;
    static boolean[][] ch;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static Pos shark;
    static int exp, level = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int answer = 0, moved = 1;

        map = new int[n + 1][n + 1];
        ch = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Pos(i, j);
                    map[i][j] = 0;
                }
            }
        }

        while(moved != 0) {
            moved = BFS(n);
            answer += moved;
            for (int i = 0; i <= n; i++) {
                Arrays.fill(ch[i], false);
            }
        }
        System.out.println(answer);

    }

    private static int BFS(int n) {
        Queue<Pos> queue = new LinkedList<>();
        Queue<Pos> canEat = new PriorityQueue<>();
        int moved = 0;

        queue.offer(shark);
        ch[shark.y][shark.x] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Pos pos = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int my = pos.y + dy[i];
                    int mx = pos.x + dx[i];

                    if ((my == 0 || my > n) || (mx == 0 || mx > n) ||
                        (ch[my][mx] || map[my][mx] > level)) {
                        continue;
                    }

                    if (map[my][mx] != 0 && map[my][mx] < level) {
                        canEat.offer(new Pos(my, mx));
                    }

                    ch[my][mx] = true;
                    queue.offer(new Pos(my, mx));
                }
            }
            moved++;
            if (canEat.size() > 0) {
                shark = canEat.poll();
                map[shark.y][shark.x] = 0;
                if (++exp == level) {
                    exp = 0;
                    level++;
                }

                return moved;
            }
        }
        return 0;
    }


    private static class Pos implements Comparable<Pos> {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.y == o.y) {
                return this.x - o.x;
            }

            return this.y - o.y;
        }
    }
}