package com.programmers.level2;

import java.util.Scanner;

class 하노이탑 {
    static int[][] answer;
    static int stack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] answer = solution(sc.nextInt());
        for (int[] prints : answer) {
            for (int print : prints) {
                System.out.print(print + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int n) {
        int max = (int)Math.pow(2, n) - 1;
        answer = new int[max][2];
        stack = 0;

        hanoi(n, 1, 2, 3);
        return answer;
    }

    /**
     * 재귀는 선언적 방식으로 생각
     * 하노이 규칙
     *  1. 마지막 n번째 원반을 목적지 기둥(to)으로 옮기기 위해 n-1개를 이웃한 기둥(other)으로 이동
     *  2. n번째 원반을 출발지 기둥(from)에서 목적지 기둥(to)로 이동
     *  3. n-1개의 원반을 이웃한 기둥(other)에서 목적지 기둥(to)으로 이동
     */
    public static void hanoi(int n, int from, int other, int to) {
        if (n == 1) {
            // 가장 작은 단위로 쪼개서 제일 위에 원반 이동
            move(from, other, to);
            return;
        }

        // N-1개를 from에서 Other로 이동 (짝수, 홀수에 따라 재귀 호출 되면서 other, to 위치 계속 바뀜)
        hanoi(n - 1, from, to, other);
        // N번째 원반을 from에서 to로 이동
        move(from, other, to);
        // N-1개를 다시 other에서 to로 이동
        hanoi(n - 1, other, from, to);
    }

    private static void move(int from, int other, int to) {
        answer[stack++] = new int[]{from, to};
    }
}