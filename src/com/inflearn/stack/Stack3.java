package com.inflearn.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine().trim());
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, arr, m, moves));
    }

    private static int solution(int n, int[][] arr, int m, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int p : moves) {
            int i = 0;
            while (arr[i][p - 1] == 0 && i < n - 1)
                i++;
            int temp = arr[i][p - 1];
            if (temp != 0) {
                arr[i][p - 1] = 0;
                if (!stack.empty() && stack.peek() == temp) {
                    stack.pop();
                    answer += 2;
                } else
                    stack.push(temp);
            }
        }
        return answer;
    }
}
