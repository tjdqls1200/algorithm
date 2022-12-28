package com.baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int deathNumberCount = 0;
        int num = 665;

        while (deathNumberCount < N) {
            ++num;
            if (isDeathNumber(num)) {
                deathNumberCount++;
            }
        }

        System.out.println(num);
    }

    private static boolean isDeathNumber(int num) {
        int continuityNumberOfSix = 0;

        while (num > 1) {
            if (num % 10 != 6) {
                continuityNumberOfSix = -1;
            }
            ++continuityNumberOfSix;
            if (continuityNumberOfSix == 3) {
                return true;
            }
            num /= 10;
        }

        return false;
    }
}
