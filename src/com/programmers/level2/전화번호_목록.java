package com.programmers.level2;

import java.util.Arrays;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for (int j = 0; j < phone_book.length - 1; j++) {
            if (phone_book[j + 1].startsWith(phone_book[j])) {
                return false;
            }
        }
        return answer;
    }
}
