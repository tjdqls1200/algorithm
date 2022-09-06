package com.inflearn.arrayEx;

import java.util.*;

public class Ex8 {
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


    private static int[] solution(int n, int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int[] result = new int[n];
        int rank = 1;
        int t = 0;

        for (int val : arr) {
            set.add(val);
        }
        for (Integer val : set) {
            for (int i = 0; i < n; i++) {
                if (val.equals(arr[i])) {
                    result[i] = rank;
                    t++;
                }
            }
            rank += t;
            t = 0;
        }
        return result;
    }
}
