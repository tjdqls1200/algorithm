package com.programmers.level2;

public class 예상_대진표 {
    public int solution(int n, int a, int b) {
        int answer = 1;

        for (int i = 0; i < n / 2; i++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            if (a == b) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
