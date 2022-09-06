package com.inflearn.arrayEx;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(n, m ,arr));
    }

    private static int solution(int n, int m, int[][] arr) {
        int answer = 0;
        int pi = 0, pj = 0;
        boolean equals;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                equals = true;
                for (int k = 0; k < m; k++) {
                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i)
                            pi = s;
                        if (arr[k][s] == j)
                            pj = s;
                    }
                    if (pi >= pj) {
                        equals = false;
                        break;
                    }
                }
                if (equals == true) answer++;
            }
        }
        return answer;
    }
}
