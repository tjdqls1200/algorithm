package com.example.dfs;

import java.util.Scanner;

public class 부분집합_최대점수_구하기 {
    static int n;
    static int m;
    static int answer = 0;

    public static void main(String[] args) {
        // 얻는 점수, 걸린 시간

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        Problem[] problems = new Problem[n];

        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            int min = sc.nextInt();
            problems[i] = new Problem(score, min);
        }
        DFS(0, 0, 0, problems);
        System.out.println(answer);
    }

    private static void DFS(int L, int sumScore, int sumTime, Problem[] problems) {
        if (sumTime > m) {
            return;
        }
        if (L == n) {
            if (sumScore > answer) {
                answer = sumScore;
            }
            return;
        } else {
            Problem problem = problems[L];
            DFS(L + 1,sumScore + problem.getScore(), sumTime + problem.getMin(), problems);
            DFS(L + 1, sumScore , sumTime, problems);
        }
    }

    private static class Problem {
        private int score;
        private int min;

        public Problem(int score, int min) {
            this.score = score;
            this.min = min;
        }

        public int getMin() {
            return min;
        }

        public int getScore() {
            return score;
        }
    }
}
