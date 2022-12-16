package com.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 게임_맵_최단거리 {
    int[][] maps;
    boolean[][] moved;
    public int solution(int[][] maps) {
        maps = maps;
        moved = new boolean[maps.length][maps[0].length];
        int[] dy = new int[]{0, -1, 0, 1};
        int[] dx = new int[]{-1, 0, 1, 0};

        Queue<Player> players = new LinkedList<>();
        players.offer(new Player(0, 0, 1));
        moved[0][0] = true;

        while (!players.isEmpty()) {
            Player player = players.poll();
            if (isClear(player)) {
                return player.distance;
            }

            for (int i = 0; i < 4; i++) {
                int my = player.y + dy[i];
                int mx = player.x + dx[i];

                if (canMove(my, mx)) {
                    moved[my][mx] = true;
                    players.offer(new Player(my, mx, player.distance + 1));
                }
            }
        }
        return -1;
    }

    private boolean isClear(Player player) {
        return (player.y == maps.length - 1 && player.x == maps[0].length - 1);
    }

    private boolean canMove(int my, int mx) {
        if (mx < 0 || mx == maps[0].length ||
                my < 0 || my == maps.length) {
            return false;
        }

        if (maps[my][mx] == 0 || moved[my][mx]) {
            return false;
        }

        return true;
    }

    static class Player {
        int y;
        int x;
        int distance;

        public Player(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
}
