package com.example.cp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex6 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, k, arr));
    }

    private static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int sum1 = 0, sum2 = 0;
        int m = 0;
        int lt = 0, rt = 0;

        for (rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                m++;
            }
            while (m > k) {
                if (arr[lt] == 0) m--;
                lt++;
            }
            sum2 = rt - lt - 1;
            sum1 = Math.max(sum1, sum2);
        }

        return answer;
    }
}
