package com.inflearn.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그래프_최단거리_인접행렬 {
    static int[][] graph;
    static int[] ch;
    static int[] answer;
    static int n;
    static int m;
    static int L = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        answer = new int[n + 1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
        }
        ch[1] = 1;
        BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                // 2
                int pos = queue.poll();
                for (int j = 1; j <= n; j++) {
                    if (graph[pos][j] == 1 && ch[j] == 0) {
                        ch[j] = 1;
                        answer[j] = L;
                        queue.offer(j);
                    }
                }
            }
            L++;
        }
    }
}
