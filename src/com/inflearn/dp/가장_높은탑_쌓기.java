package com.inflearn.dp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class 가장_높은탑_쌓기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        ArrayList<Brick> bricks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bricks.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        bricks.sort((o1, o2) -> {
            if (o2.w == o1.w) {
                return o2.s - o1.s;
            } else
                return o2.w - o1.w;
        });
        solution(dp, bricks);

        int max = Integer.MIN_VALUE;
        for (int h : dp) {
            max = Math.max(max, h);
        }
        System.out.println(max);
    }

    private static void solution(int[] dp, ArrayList<Brick> bricks) {
        dp[0] = bricks.get(0).h;

        for (int i = 1; i < bricks.size(); i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (bricks.get(j).s > bricks.get(i).s && dp[j] > max)
                    max = dp[j];
            }
            dp[i] = max + bricks.get(i).h;
        }
    }

    private static class Brick {
        int s;
        int h;
        int w;

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }
    }
}
