package com.programmers.test.dev;

public class Problem1 {
    public static void main(String[] args) {

    }
    public String solution(String src) {
        StringBuilder sb = new StringBuilder();
        char[] chars = src.toCharArray();
        sb.append(chars[0]);
        int ch = chars[0];
        int cnt = 0;


        for (int i = 0; i < chars.length; i++) {
            if (ch == chars[i]) {
                cnt++;
            } else {
                ch = chars[i];
                sb.append((char)(64 + cnt));
                cnt = 1;
            }
            if (i == chars.length - 1) {
                sb.append((char)(64 + cnt));
            }
        }

        return sb.toString();
    }
}
