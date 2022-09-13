package com.programmers.level1;

public class 최소직사각형 {
    public int solution(int[][] sizes) {
        int x_max = 0;
        int y_max = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            x_max = Math.max(x_max, sizes[i][0]);
            y_max = Math.max(y_max, sizes[i][1]);
        }
        return x_max * y_max;
    }
}
