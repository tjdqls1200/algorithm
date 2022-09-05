package com.example.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 송아지찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(BFS(s, e));
    }

    private static int BFS(int s, int e) {
        int answer = 0;
        int[] move = {1, -1, 5};
        int[] ch = new int[10001];
        // s = 5, e = 14

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        ch[s] = 1;
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int n = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int next = n + move[j];
                    if (next == e)
                        return L + 1;
                    if (next >= 1 && next <= 10000 && ch[next] == 0) {
                        ch[next] = 1;
                        queue.offer(next);
                    }
                }
            }
            L++;
        }


        return answer;
    }
}
