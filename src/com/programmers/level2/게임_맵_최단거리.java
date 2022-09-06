package com.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
    static int[][] graph;
    static int[][] ch;

    public int solution(int[][] maps) {
        int answer = Integer.MAX_VALUE;
        int x_length = maps[0].length;
        int y_length = maps.length;
        ch = new int[y_length + 1][x_length + 1];
        graph = new int[y_length + 1][x_length + 1];

        for (int i = 1; i <= y_length; i++) {
            for (int j = 1; j <= x_length; j++) {
                graph[i][j] = maps[i - 1][j - 1];
            }
        }
        Queue<Pos> q = new LinkedList<>();
        Pos start = new Pos(1, 1, 1);
        q.offer(start);

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Pos pos = q.poll();
                if (pos.y == y_length && pos.x == x_length) {
                    answer = Math.min(answer, pos.move);
                } else {
                    // 이동 가능하고 체크가 안된 경우
                    if (graph[pos.y][pos.x] == 1 && ch[pos.y][pos.x] == 0) {
                        // 이동 체크
                        ch[pos.y][pos.x] = 1;
                        // 일단 4방향 전부 Queue 삽입하고 poll에서 거름
                        if (pos.y < y_length) q.offer(new Pos(pos.y + 1, pos.x, pos.move + 1));
                        if (pos.y > 1) q.offer(new Pos(pos.y - 1, pos.x, pos.move + 1));
                        if (pos.x < x_length) q.offer(new Pos(pos.y, pos.x + 1, pos.move + 1));
                        if (pos.x > 1) q.offer(new Pos(pos.y, pos.x - 1, pos.move + 1));
                    }
                }
            }
        }
        // 도착하지 못하는 경우
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer;
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
