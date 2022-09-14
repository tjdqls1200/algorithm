package com.programmers.level2;

public class N개의_최소공배수 {
    public static void main(String[] args) {
        int a = solution(new int[]{2,6,8,14});
        System.out.println(a);
    }
    public static int solution(int[] arr) {

        int max = arr[arr.length - 1];
        int i = 0;
        int temp = max;
        while (i < arr.length) {
            if (temp % arr[i] != 0) {
                i = -1;
                temp = temp + max;
            }
            i++;
        }
        return temp;
    }
}
