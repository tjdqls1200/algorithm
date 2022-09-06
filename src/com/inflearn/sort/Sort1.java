package com.inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 선택 정렬
public class Sort1 {
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
        int idx = 0;
        for (int i = 0; i < n - 1; i++) {
            idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx]  = temp;
        }
        return arr;
    }
}
