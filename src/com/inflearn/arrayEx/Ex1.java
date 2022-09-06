package com.inflearn.arrayEx;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int x : solution(n, arr)) {
            System.out.println(x + " ");
        }
    }
    public static ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                result.add(arr[i]);
            }
        }
        return result;
    }
}
