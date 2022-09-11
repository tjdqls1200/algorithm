package com.programmers.level2;

import java.util.*;

public class 프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Print> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Print(priorities[i], i));
        }
        Arrays.sort(priorities);

        int i = priorities.length - 1;
        while (!queue.isEmpty()) {
            Print pos = queue.poll();
            if (priorities[i] == pos.value) {
                answer++;
                i--;
                if (pos.locate == location)
                    break;
            } else {
                queue.offer(pos);
            }
        }
        return answer;
    }

    private class Print {
        int value;
        int locate;

        public Print(int value, int locate) {
            this.value = value;
            this.locate = locate;
        }
    }
}
