package com.inflearn.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sort7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        int[][] solution = solution(n, arr);
        for (int i = 0; i < n; i++) {
            System.out.println(solution[i][0] + " " + solution[i][1]);
        }
    }

    private static int[][] solution(int n, int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        return arr;
    }
}
