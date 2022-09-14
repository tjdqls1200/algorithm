package com.programmers.level2;

public class JadenCase {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        char[] chars = s.toLowerCase().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append(chars[i]);
                continue;
            }
            sb.append(Character.toUpperCase(chars[i++]));
            while (i < chars.length && chars[i] != ' ') {
                sb.append(chars[i++]);
            }
            i--;
        }
        return sb.substring(0, sb.length() - 1);
    }
}
