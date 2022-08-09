package com.example.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine(), br.readLine()));
    }

    private static String solution(String str1, String str2) throws IOException {
        String answer = "NO";
        HashMap<String, HashMap<Character, Integer>> map = new HashMap<>();
        map.put(str1, new HashMap<>());
        map.put(str2, new HashMap<>());
        for (String s : map.keySet()) {
            HashMap<Character, Integer> sub = map.get(s);
            for (char c : s.toCharArray()) {
                sub.put(c, sub.getOrDefault(c, 0) + 1);
            }
        }
        HashMap<Character, Integer> sub1 = map.get(str1);
        HashMap<Character, Integer> sub2 = map.get(str2);
        if (sub2.equals(sub1)) {
            answer = "YES";
        }
        return answer;
    }
}
