package com.programmers.test.kakao;

import java.util.*;

public class p1 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Character, Integer> termList = new HashMap<>();

        int[] todayArr = Arrays.stream(today.split("\\."))
                .mapToInt(Integer::parseInt).toArray();

        for (String term : terms) {
            String[] s = term.split(" ");
            termList.put(s[0].charAt(0), Integer.parseInt(s[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] pri = privacies[i].split(" ");
            char term = pri[1].charAt(0);
            int termMonth = termList.get(term);
            int[] pos = Arrays.stream(pri[0].split("\\."))
                    .mapToInt(Integer::parseInt).toArray();
            expiredDayCheck(termMonth, pos);
            for (int j = 0; j < 3; j++) {
                if (todayArr[j] > pos[j]) {
                    answer.add(i + 1);
                    break;
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void expiredDayCheck(int termMonth, int[] pos) {
        pos[1] += termMonth;
        pos[2] -= 1;
        if (pos[2] == 0) {
            pos[1] -= 1;
            pos[2] = 28;
        }
        if (pos[1] > 12) {
            //13 1
            pos[0] += ((pos[1] - 1) / 12);
            pos[1] = ((pos[1]) % 12);
        }
    }
}
