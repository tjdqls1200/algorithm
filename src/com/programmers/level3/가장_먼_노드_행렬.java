package com.programmers.level3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 가장_먼_노드_행렬 {

    public int solution(int n, int[][] edge) {
        int[][] map = new int[n + 1][n + 1];
        int[][] ch = new int[n + 1][n + 1];
        int move = 0;
        int[] answer = new int[n + 1];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            map[a][b] = 1;
        }

        boolean flag;
        int cnt = 0;
        queue.offer(new Point(1, 1));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int l = 0; l < len; l++) {
                Point pos = queue.poll();
                flag = true;
                for (int i = 1; i <= n; i++) {
                    if (map[pos.b][i] == 1 && ch[pos.b][i] == 0) {
                        ch[pos.b][i] = 1;
                        ch[i][pos.b] = 1;
                        queue.offer(new Point(pos.b, i));
                        flag = false;
                    }
                }
                if (flag) {
                    answer[move] += 1;
                }
            }
            move++;
        }
        for (int a = answer.length - 1; a > 0; a++) {
            if (answer[a] > 0) {
                return answer[a];
            }
        }
        return 0;
    }

    private class Point {
        int a;
        int b;

        public Point(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}














