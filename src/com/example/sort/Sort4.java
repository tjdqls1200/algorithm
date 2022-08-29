package com.example.sort;

import java.util.Scanner;

public class Sort4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (Integer integer : solution(s, n, arr)) {
            System.out.print(integer + " ");
        }
    }

    private static int[] solution(int s, int n, int[] arr) {
        int[] cashe = new int[s];
        int i, j, k;
        for (i = 0; i < n; i++) {
            for (k = 0; k < s; k++) {
                if (cashe[k] == arr[i])
                    break;
            }
            if (k == s)
                k = s - 1;
            for (j = k; j > 0; j--) {
                cashe[j] = cashe[j - 1];
            }
            cashe[0] = arr[i];
        }
        return cashe;
    }
}
