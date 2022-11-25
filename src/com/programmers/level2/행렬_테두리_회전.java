package com.programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class 행렬_테두리_회전 {
    static int[][] map;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] ints = new int[4][];
        ints[0] = new int[]{1, 1, 2, 2};
        ints[1] = new int[]{1, 2, 2, 3};
        ints[2] = new int[]{2, 1, 3, 2};
        ints[3] = new int[]{2, 2, 3, 3};


        int[] solution = solution(3, 3, ints);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> answer = new ArrayList<>();

        map = new int[rows + 1][columns + 1];
        int n = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = n;
                n++;
            }
        }

        for (int[] query : queries) {
            Pos pos = new Pos(query[0], query[1]);
            int min = map[pos.y][pos.x];
            int dir = 0;

            while (dir < 4) {
                min = Math.min(min, move(pos, dir));

                if ((pos.y == query[0] && pos.x == query[1] + 1)) {
                    break;
                }
                if ((pos.y == query[2] && pos.x == query[1])
                        || (pos.y == query[2] && pos.x == query[3])
                        || (pos.y == query[0] && pos.x == query[3])) {
                    dir++;
                }
            }
            answer.add(min);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int move(Pos pos, int dir) {
        int a = map[pos.y][pos.x];
        int b = map[pos.y + dy[dir]][pos.x + dx[dir]];
        map[pos.y][pos.x] = b;
        map[pos.y + dy[dir]][pos.x + dx[dir]] = a;

        pos.y = pos.y + dy[dir];
        pos.x = pos.x + dx[dir];

        return b;
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
