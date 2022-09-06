package com.programmers.level2;

import java.util.Scanner;

public class 하노이탑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Hanoi(n, 1, 2, 3);
    }

    private static void Hanoi(int n, int from, int other, int to) {
        if (n == 1) {
            // N이 한개가 되면 이동
            System.out.println(from + " " + to);
            return;
        } else {
            // n-1개를 (n == 1이 될 때까지) from에서 other로 이동
            Hanoi(n - 1, from, to, other);
            System.out.println(from + " " + to);
            Hanoi(n - 1, other, from, to);
        }
    }
}
