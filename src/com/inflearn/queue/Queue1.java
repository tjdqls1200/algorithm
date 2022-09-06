package com.inflearn.queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Queue1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(solution(n, k));
    }

    private static Integer solution(int n, int k) {
        java.util.Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            for (int j = 1; j < k; j++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.poll();
    }
}
