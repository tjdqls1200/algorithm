package com.inflearn.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 재귀_파보나치 {
    static int[] fibo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        fibo = new int[n + 1];
        DFS(n);
        for (int i = 1; i<= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    private static int DFS(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1)
            return fibo[n] = 1;
        else if (n == 2)
            return fibo[n] = 1;
        return fibo[n] = DFS(n - 2) + DFS(n - 1);
        // n=3) fibo[3] = DFS(1) + DFS(2) -> 1 + 1 = 2
        // n=4) fibo[4] = DFS(2) + (DFS(1) + DFS(2)) -> 1 + 2 = 3
        // n=5) fibo[5] = (DFS(1) + DFS(2)) + (DFS(2) + (DFS(1) + DFS(2))) -> 2 + 3 = 5
    }
}
