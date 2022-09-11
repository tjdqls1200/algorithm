package com.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int second = 0, bridgeWeight = 0;

        Queue<Integer> queue = new LinkedList<>();
        int[] move = new int[bridge_length + 1];

        for (int truck : truck_weights) {
            queue.offer(truck);
        }

        while (!queue.isEmpty()) {
            if (move[bridge_length] != 0)
                bridgeWeight -= move[bridge_length];

            int waitTruck = queue.peek();
            if (bridgeWeight + waitTruck <= weight) {
                queue.poll();
                bridgeWeight += waitTruck;
                // wait 상태
                move[0] = waitTruck;

            }
            for (int i = bridge_length - 1; i >= 0; i--) {
                move[i + 1] = move[i];
                move[i] = 0;
            }
            second++;
        }
        for (int i = 1; i <= bridge_length; i++) {
            if (move[i] != 0) {
                second += (bridge_length + 1 - i);
                break;
            }
        }
        return second;
    }
}
