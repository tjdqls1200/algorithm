package com.programmers.level3;

import java.util.LinkedList;
import java.util.Queue;


public class 단어변환 {
    static int len;
    static boolean[] check;

    public int solution(String begin, String target, String[] words) {
        len = begin.length();
        check = new boolean[words.length];

        return BFS(begin.toCharArray(), target, words);
    }

    private int BFS(char[] begin, String target, String[] words) {
        int L = 1;
        Queue<char[]> queue = new LinkedList<>();
        queue.offer(begin);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] temp = queue.poll();
                for (int j = 0; j < words.length; j++) {
                    if (check[j])
                        continue;
                    char[] word = words[j].toCharArray();
                    if (wordCheck(temp, word)) {
                        check[j] = true;
                        if (words[j].equals(target))
                            return L;
                        queue.offer(word);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    private boolean wordCheck(char[] temp, char[] word) {
        boolean result = false;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (temp[i] != word[i])
                cnt++;
            if (cnt > 1)
                break;
        }
        if (cnt == 1)
            result = true;
        return result;
    }
}
