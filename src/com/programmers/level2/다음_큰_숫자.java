package com.programmers.level2;

// Integer.bitCount(n) -> bitCount() 몰랐음
public class 다음_큰_숫자 {
    public int solution(int n) {
        int answer = 0;

        String in = Integer.toBinaryString(n);
        int cnt = getCnt(in);

        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            if (cnt == getCnt(Integer.toBinaryString(i))) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    private int getCnt(String in) {
        int cnt = 0;
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}
