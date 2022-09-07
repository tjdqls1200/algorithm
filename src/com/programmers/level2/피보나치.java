package com.programmers.level2;

public class 피보나치 {
    // 배열에 저장을 해둬서 재귀를 끝까지 안 돌게 방지
    static int[] memory;

    public static int solution(int n) {
        memory = new int[n + 1];
        return fibo(n);
    }

    public static int fibo(int n) {
        if (memory[n] > 0) {
            return memory[n];
        }
        if (n == 1 || n == 2) {
            return memory[n] = 1;
        } else {
            // n 값이 커질수록 int형으로 표현 불가능하기 때문에(long 포함) 1234567로 나눈 나머지를 저장
            // (A + B) % C == ((A % C) + (B % C)) % C
            return memory[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
        }
    }
}
