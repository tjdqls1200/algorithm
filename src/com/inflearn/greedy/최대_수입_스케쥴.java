package com.inflearn.greedy;

import java.util.*;

public class 최대_수입_스케쥴 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<ScheduleList> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ScheduleList(sc.nextInt(), sc.nextInt()));
        }
        int pay = 0;

        solution(queue, arr, pay);
    }

    private static void solution(Queue<Integer> queue, ArrayList<ScheduleList> arr, int pay) {
        arr.sort((a, b) -> b.day - a.day);
        int last = arr.get(0).day;

        int answer = 0;
        int j = 0;
        for (int i = last; i >= 1; i--) {
            for ( ; j < arr.size(); j++) {
                if (arr.get(j).day < i) break;
                queue.offer(arr.get(j).price);
            }
            if (!queue.isEmpty()) {
                answer += queue.poll();
            }
        }
        System.out.println(answer);
    }

    private static class ScheduleList {
        int price;
        int day;

        public ScheduleList(int price, int day) {
            this.price = price;
            this.day = day;
        }
    }
}
