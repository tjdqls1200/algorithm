package com.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {
    public static void main(String[] args) {
        for (int i : solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})) {
            System.out.println(i);
        }
    }
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        Set<String> set = new HashSet<>();

        int end = 0;
        String prev = words[0];
        set.add(prev);
        for (int i = 1; i < words.length; i++) {
            String pos = words[i];
            if (prev.charAt(prev.length() - 1) != pos.charAt(0)) {
                end = i + 1;
                break;
            }
            if (!set.add(words[i])) {
                end = set.size() + 1;
                break;
            }
            prev = pos;
        }
        if (end != 0) {
            int a = end / n;
            int b = end % n;
            answer[0] = (b == 0) ? n : b;
            answer[1] = (b == 0) ? a : a + 1;
        }
        return answer;
    }
}
