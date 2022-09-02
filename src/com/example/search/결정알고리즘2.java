package com.example.search;

import java.util.Arrays;
import java.util.Scanner;

public class 결정알고리즘2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }

    private static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        // 최대 거리, 최소 거리
        int lt = arr[0];
        int rt = arr[n - 1] - arr[0];

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= m) {
                answer = mid;
                lt = mid + 1;
            }
            else {
                rt = mid - 1;
            }
        }

        return answer;
    }

    private static int count(int[] arr, int mid) {
        int point = arr[0];
        int temp = 0;
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - point >= mid) {
                cnt++;
                point = arr[i];
            }
        }
        return cnt;
    }
}
