package com.example.cp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        int answer = 0;
        int temp = 0;
        int lt = 1;
        for (int rt = 1; rt <= (n/2+1); rt++) {
            temp += rt;
            if (temp == n)
                answer++;
            while (temp >= n) {
                temp -= lt;
                lt++;
                if (temp == n)
                    answer++;
            }
        }
        return answer;
    }
}
