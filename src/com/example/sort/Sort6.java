package com.example.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sort6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : solution(n, arr)) {
            System.out.print(i + " ");
        }
    }

    private static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] clone = arr.clone();
        Arrays.sort(clone);

        for (int i = 0; i < n; i++) {
            if (arr[i] != clone[i]) {
                answer.add(++i);
            }
        }
        return answer;
    }
}
