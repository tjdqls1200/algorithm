package com.programmers.level2;

public class 최댓값과_최솟값 {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String num : arr) {
            int temp;
            temp = Integer.parseInt(num);

            max = Math.max(max, temp);
            min = Math.min(min, temp);
        }
        return (min + " " + max);
    }
}
