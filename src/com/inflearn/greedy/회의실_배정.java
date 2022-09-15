package com.inflearn.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class 회의실_배정 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Conference> conferences = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            conferences.add(new Conference(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(solution(n, conferences));

    }

    private static int solution(int n, ArrayList<Conference> conferences) {
        conferences.sort((o1, o2) -> {
            if (o1.start == o2.start)
                return o1.end - o2.end;
            else
                return o1.start - o2.start;
        });
        int cnt = 1;

        Conference conf = conferences.get(0);
        for (int i = 1; i < n; i++) {
            Conference next = conferences.get(i);
            if (conf.end > next.end) {
                conf = next;
            } else if (conf.end <= next.start) {
                conf = next;
                cnt++;
            }
        }
        return cnt;
    }

    private static class Conference {
        int start;
        int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
