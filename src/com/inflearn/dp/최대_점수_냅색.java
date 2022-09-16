package com.inflearn.dp;

import java.util.ArrayList;
import java.util.Scanner;

public class 최대_점수_냅색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Problem> problems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            problems.add(new Problem(sc.nextInt(), sc.nextInt()));
        }
        int[] dp = new int[m + 1];

        for (int i = 0; i < n; i++) {
            Problem problem = problems.get(i);
            for (int j =  m; j >= problem.time; j--) {
                dp[j] = Math.max(dp[j], dp[j - problem.time] + problem.score);
            }
        }
        System.out.println(m);
    }

    private static class Problem {
        int score;
        int time;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
