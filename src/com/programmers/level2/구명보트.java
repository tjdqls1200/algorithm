package com.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int sum = 0;
        int i = 0;
        Arrays.sort(people);

        Deque<Integer> deque = new LinkedList();

        for (int person : people) {
            deque.offer(person);
        }

        int temp = 0;
        while (!deque.isEmpty()) {
            temp += deque.pollLast();
            if (!deque.isEmpty() && temp + deque.peekFirst() <= limit) {
                temp += deque.pollFirst();
            }
            temp = 0;
            answer++;
        }
        return answer;
    }
}
