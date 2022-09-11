package com.programmers.level2;

import java.util.HashMap;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }

        for (String kind : map.keySet()) {
            int n = map.get(kind);
            //nC1 + nC0
            answer *= (n + 1);
        }

        return answer - 1;
    }
}
