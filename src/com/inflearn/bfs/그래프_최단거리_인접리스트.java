package com.inflearn.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 그래프_최단거리_인접리스트 {
    static int[] ch;
    static int[] dis;
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        ch = new int[n + 1];
        dis = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        BFS(1);
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int pos = queue.poll();
                for (int nx : graph.get(pos)) {
                    if (ch[nx] == 0) {
                        dis[nx] = dis[pos] + 1;
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
        }
    }
}
