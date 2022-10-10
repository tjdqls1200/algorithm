package com.baekjoon.simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11403 {
    public static ArrayList<ArrayList<Integer>> arr;
    public static boolean[][] ch;
    public static int from = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>(n + 1);
        ch = new boolean[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> arrIn = arr.get(i);
            for (int j = 1; j <= n; j++) {
                if ("1".equals(st.nextToken())) {
                    arrIn.add(j);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            DFS(i);
            from++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append((ch[i][j]) ? "1 " : "0 ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void DFS(int i) {
        ArrayList<Integer> arrIn = arr.get(i);
        for (int j = 0; j < arrIn.size(); j++) {
            int to = arrIn.get(j);
            if (!ch[from][to]) {
                ch[from][to] = true;
                DFS(to);
            }
        }
    }

}
