package com.inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삽입 정렬
public class Sort3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] solution = solution(n, arr);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(solution[i] + " ");
        }
        System.out.println(solution[n - 1]);
    }

    private static int[] solution(int n, int[] arr) {
        int temp = 0;
        int i;
        for (int j = 1; j < n; j++) {
            temp = arr[j];
            for (i = j; i > 0; i--) {
                if (arr[i - 1] > temp)
                    arr[i] = arr[i - 1];
                else
                    break;
            }
            // 삽입
            arr[i] = temp;
        }
        return arr;
    }
}
