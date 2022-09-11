package com.programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int completed = 0;
        int day = 0;

        for (int i = 0; i < progresses.length; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int pos = queue.peek();
            int max = progresses[pos] + (speeds[pos] * day);
            if (max >= 100) {
                queue.poll();
                completed++;
                continue;
            }
            day += (int) Math.ceil((double)(100 - max) / speeds[pos]);
            if (completed != 0) {
                answer.add(completed);
                completed = 0;
            }
        }
        if (completed != 0)
            answer.add(completed);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
