package com.example.cp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {
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

    private static ArrayList<Integer> solution(int n1, int n2, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int temp = 0;
        int p1 = 0, p2 = 0;


        while (p1 < n1 && p2 < n2) {
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            } else if (arr1[p1] > arr2[p2])
                p2++;
            else
                p1++;
        }
        return answer;
    }
}
