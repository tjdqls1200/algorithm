package com.inflearn.recursion;

import java.util.Scanner;

public class 재귀_이진수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        DFS(n);
    }

    private static void DFS(int n) {
        if (n == 0)
            return;
        DFS(n / 2); // 11, 5, 2, 1, 0
        System.out.print(n % 2 + " "); // 1, 0, 1, 1
    }
}
