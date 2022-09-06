package com.inflearn.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class 경로탐색_인접리스트 {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int n;
    static int answer = 0;


    public static void main(String[] args) {
        graph = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        DFS(1);
    }

    private static void DFS(int v) {

        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                for (int next : graph.get(v)) {
                    if (ch[next] == 0) {
                        ch[next] = 1;
                        DFS(next);
                        ch[next] = 0;
                    }
                }
            }
        }
    }
}
