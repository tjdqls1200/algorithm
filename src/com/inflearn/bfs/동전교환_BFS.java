package com.inflearn.bfs;

import java.util.*;

public class 동전교환_BFS {
    static int m, n;
    static int L = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        m = sc.nextInt();
        Arrays.sort(coins, Collections.reverseOrder());
        BFS(coins);
        System.out.println(L);
    }

    private static void BFS(Integer[] coins) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int pos = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (pos + coins[j] == m) {
                        L++;
                        return;
                    }
                    queue.offer(pos + coins[j]);
                }
            }
            L++;
        }
    }
}
