package com.example.arrayEx;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i = 0; i < (n * 2); i++) {
            if (i < n) {
                arrA[i] = in.nextInt();
            } else {
                arrB[i % n] = in.nextInt();
            }
        }
        for (char x : solution(n, arrA, arrB)) {
            System.out.println(n);
        }
    }

    private static char[] solution(int n, int[] arrA, int[] arrB) {
        char[] result = new char[n];

        // 1:가위 , 2:바위, 3:보
        for (int i = 0; i < n; i++) {
            if (arrA[i] == 1 &&  arrB[i] == 3) {
                result[i] = 'A';
            } else if (arrA[i] == 2 && arrB[i] == 1) {
                result[i] = 'A';
            } else if (arrA[i] == 3 && arrB[i] == 2) {
                result[i] = 'A';
            } else if (arrA[i] == arrB[i]) {
                result[i] = 'D';
            } else {
                result[i] = 'B';
            }
        }
        return result;
    }
}
