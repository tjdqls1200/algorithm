package com.programmers.level2;

public class 나라의_숫자 {
    public static String solution(int n) {
        int[] numbers = {4, 1, 2};
        int check;
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            check = n % 3;
            sb.append(numbers[check]);
            // 3으로 나누어 떨어질 경우, 몫이 1 올라감
            // n = 6일 경우, 6 나누기 2는 몫이 2가 되어 앞에 자릿수 바뀜 (14 -> 24)
            if (check == 0)
                n = (n - 1) / 3;
            else
                n = n / 3;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
    }
}
