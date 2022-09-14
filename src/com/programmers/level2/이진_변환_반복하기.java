package com.programmers.level2;

public class 이진_변환_반복하기 {

    public static void main(String[] args) {
        for (int i : solution("110010101001")) {
            System.out.println(i);
        }
    }
    public static int[] solution(String s) {
        int[] answer = new int[]{0,0};
        int binaryStrLen, bitCnt;

        while (s.length() > 1) {

            binaryStrLen = s.length();

            bitCnt = 0;
            // 1. s.replaceAll("0", "") -> 깔끔해보이지만 속도가 느림
            // 2. BigInteger(a, 2).bitCount() -> bitCount() 쓸 때, String -> Binary Int 변환시 범위 벗어나는거 조심
            // 3. (int)s.chars().filter(c -> c == '1').count() -> 좋은 방법
            bitCnt = (int)s.chars().filter(c -> c == '1').count();
            answer[0] += 1;
            answer[1] += (binaryStrLen - bitCnt);
            s = Integer.toBinaryString(bitCnt);
        }
        return answer;
    }
}
