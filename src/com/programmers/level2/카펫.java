package com.programmers.level2;

import java.util.ArrayList;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        ArrayList<Integer> arr = new ArrayList<>();
        // 24
        // a*2 + b*2 = 12
        // (1, 11) (2, 10), (3, 9) (4, 8), (5, 7), (6, 6)
        //   9       16,      21     6*4


        for (int y = 1; y < brown; y++) {
            int x = brown - (y * 2);
            if (x % 2 == 0) {
                x /= 2;
                int empty = (x - 2) * y;
                if (empty == yellow && x >= y + 2) {
                    answer = new int[]{x, y+2};
                }
            }

        }
        return answer;
    }
}
