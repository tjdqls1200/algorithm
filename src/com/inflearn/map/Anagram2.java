package com.inflearn.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Anagram2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        System.out.println(solution(s, t));
    }

    private static int solution(String s, String t) {
        int answer = 0;
        HashMap<Character, Integer> mainMap = new HashMap<>();
        HashMap<Character, Integer> equalsMap = new HashMap<>();
        int lt = 0, rt;

        for (char c : t.toCharArray())
            equalsMap.put(c, equalsMap.getOrDefault(c, 0) + 1);
        char[] chars = s.toCharArray();
        for (rt = 0; rt < t.length() - 1; rt++)
            mainMap.put(chars[rt], mainMap.getOrDefault(chars[rt], 0) + 1);

        for (rt = t.length() - 1; rt < s.length(); rt++, lt++) {
            mainMap.put(chars[rt], mainMap.getOrDefault(chars[rt], 0) + 1);
            if (mainMap.equals(equalsMap))
                answer++;
            mainMap.put(chars[lt], mainMap.get(chars[lt]) - 1);
            if (mainMap.get(chars[lt]) == 0)
                mainMap.remove(chars[lt]);
        }
        return answer;
    }
}
