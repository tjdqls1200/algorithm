package com.example.recursion;

import java.util.Scanner;

public class 재귀_스택프레임 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        //깊이 우선 탐색 (재귀)
        DFS(n);
    }

    private static void DFS(int n) {
        if (n == 0)
            return;
        DFS(--n);
        System.out.println(n);
    }
}
