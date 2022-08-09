package com.example.arrayEx;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

    private static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            int res = 0;
            while (temp > 0) {
                res *= 10;
                res += temp % 10;
                temp /= 10;
            }
            if (isPrime(res)) result.add(res);
        }
        return result;
    }

    private static boolean isPrime(int res) {
        if (res == 1) return false;

        for (int i = 2; i < res; i++) {
            if (res % i == 0) return false;
        }
        return true;
    }
}
