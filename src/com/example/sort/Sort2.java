package com.example.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 버블 정렬
public class Sort2 {
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
        int last;
        int i = 0;
        while (i < n - 1) {
            last = n - 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    last = j;
                }
            }
            i = last;
        }
        return arr;
    }
}
