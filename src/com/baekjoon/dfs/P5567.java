package com.baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5567 {
    static boolean[] ch;
    static ArrayList<ArrayList<Integer>> relation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        relation = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        ch = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            relation.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation.get(a).add(b);
            relation.get(b).add(a);
        }

        System.out.println(BFS());

    }

    private static int BFS() {
        Queue<Integer> queue = new LinkedList<>();
        int L = 0, cnt = 0;

        ch[1] = true;
        queue.offer(1);

        while (!queue.isEmpty()) {
            if (L == 2) {
                break;
            }

            for (int s = 0; s < queue.size(); s++) {
                int pos = queue.poll();
                ArrayList<Integer> friends = relation.get(pos);

                for (int i = 0; i < friends.size(); i++) {
                    int friend = friends.get(i);
                    if (!ch[friend]) {
                        ch[friend] = true;
                        cnt++;
                        queue.offer(friend);
                    }
                }
            }
            L++;
        }
        return cnt;
    }
}
