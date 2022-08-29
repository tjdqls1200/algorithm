package com.example.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Queue2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        System.out.println(solution(s1, s2));
    }

    private static String solution(String s1, String s2) {
        Queue<Character> queue = new LinkedList<>();
        int i = 0;
        for (char c : s1.toCharArray()) {
            queue.add(c);
        }
        char[] chars = s2.toCharArray();
        while (queue.size() > 0) {
            char tmp = queue.peek();
            for (; i < chars.length; i++) {
                if (tmp == chars[i]) {
                    i++;
                    queue.poll();
                    break;
                }
            }
            if (i == chars.length) {
                break;
            }
        }
        if (queue.size() > 0) {
            return "NO";
        }
        return "YES";
    }
}
