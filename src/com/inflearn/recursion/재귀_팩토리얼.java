package com.inflearn.recursion;

import java.util.Scanner;

public class 재귀_팩토리얼 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(DFS(n));
    }
//test
    private static int DFS(int n) {
        if (n == 0)
            return 1;
        else return n * DFS(n - 1);
    }
}
