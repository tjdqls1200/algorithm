package com.inflearn.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 피자_배달거리 {
    static List<Pos> pizza, house;
    static int n, m, len;
    static int comb[];
    static int answer = Integer.MAX_VALUE;

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        pizza = new ArrayList<>();
        house = new ArrayList<>();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int temp = sc.nextInt();
                if (temp == 2) {
                    pizza.add(new Pos(y, x));
                } else if (temp == 1) {
                    house.add(new Pos(y, x));
                }
            }
        }
        comb = new int[m];
        len = pizza.size();
        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Pos h : house) {
                int dis = Integer.MAX_VALUE;
                for (int i : comb) {
                    Pos p = pizza.get(i);
                    dis = Math.min(dis, Math.abs(h.y - p.y) + Math.abs(h.x - p.x));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                comb[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
