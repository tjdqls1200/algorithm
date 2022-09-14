package com.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 두_큐의합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        int cnt = 0;
        int temp;

        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        if ((sum1 + sum2) % 2 != 0)
            return -1;

        while (sum1 != sum2) {
            if (cnt > 300000) {
                return -1;
            }
            cnt++;
            if (!q1.isEmpty() && sum1 > sum2) {
                temp = q1.poll();
                q2.offer(temp);
                sum1 -= temp;
                sum2 += temp;
            } else if (!q2.isEmpty() && sum1 < sum2) {
                temp = q2.poll();
                q1.offer(temp);
                sum1 += temp;
                sum2 -= temp;
            }
        }
        return cnt;
    }
}
