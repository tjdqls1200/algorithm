package com.example.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        String str = new StringTokenizer(br.readLine()).nextToken();
        System.out.println(solution(n, str));
    }

    private static char solution(int n, String str) {
        Map<Character, Integer> map = new HashMap<>();
        char answer = ' ';
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            Integer temp = map.get(key);
            if (temp > max) {
                max = temp;
                answer = key;
            }
        }
        return answer;
    }
}