package com.programmers.level2;

public class 타겟_넘버 {
    static int answer = 0;
    static int n, m;
    static int[] ch;

    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(solution(numbers, target));
    }
    public static int solution(int[] numbers, int target) {
        n = numbers.length;
        m = target;
        ch = new int[n];
        DFS(0, 0, numbers);
        return answer;
    }

    private static void DFS(int L, int sum, int[] numbers) {
        if (L == n) {
            if (sum == m) {
                answer++;
            }
            return;
        } else {
            DFS(L + 1, sum + numbers[L], numbers);
            DFS(L + 1, sum - numbers[L], numbers);
        }
    }
}
