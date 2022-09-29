package com.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2490 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] answer = new char[3];
        int cnt;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cnt = 0;
            while (st.hasMoreTokens()) {
                // 배(0), 등(1)
                // 도(A) 3, 개(B) 2, 걸(C) 1, 윳(D) 0, 모(E) 4
                if ("1".equals(st.nextToken())) {
                    cnt += 1;
                }
            }
            if (cnt == 4)
                cnt = -1;
            answer[i] = (char)('D' - cnt);
        }
        for (char c : answer) {
            System.out.println(c);
        }
    }
}
