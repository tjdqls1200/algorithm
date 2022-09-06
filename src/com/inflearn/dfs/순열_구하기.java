package com.inflearn.dfs;

import java.util.Scanner;

public class 순열_구하기 {
    static int n, m;
    static int[] pm, ch, arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new int[n];
        pm = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0, arr);
    }

    private static void DFS(int L, int[] arr) {
        if (L == m) {
            for (int num : pm) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    DFS(L + 1, arr);
                    ch[i] = 0;
                }
            }
        }
    }
}
