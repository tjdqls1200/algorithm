package com.programmers.level2;

public class 점프와_순간이동 {
    public int solution(int n) {
        int battery = 1;

        while (n > 2) {
            if (n % 2 != 0) {
                battery++;
                n--;
            }
            n /= 2;
        }

        return battery;
    }
}
