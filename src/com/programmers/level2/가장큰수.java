package com.programmers.level2;

import java.util.*;

// 풀이 참고
// (o1 + o2).compareTo(o2 + o1);
public class 가장큰수 {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        for (String s : list) {
            sb.append(s);
        }
        String answer = sb.toString();
        if (answer.startsWith("0"))
            answer = "0";
        return answer;
    }
}
