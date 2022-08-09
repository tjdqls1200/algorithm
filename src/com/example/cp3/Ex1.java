package com.example.cp3;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) arr1[i] = in.nextInt();
        int n2 = in.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) arr2[i] = in.nextInt();
        for (int x : solution(n1, n2, arr1, arr2)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(int n1, int n2, int[] arr1, int[] arr2) {
        int[] answer = new int[n1 + n2];
        int j = 0, k = 0;
        for (int i = 0; i < n1 + n2; i++) {
            if (j < n1 && arr1[j] <= arr2[k]) {
                answer[i] = arr1[j++];
            } else if (k < n2) {
                answer[i] = arr2[k++];
            }
        }
        return answer;
    }
}
