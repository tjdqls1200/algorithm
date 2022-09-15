package com.inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 씨름_선수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] height = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            height[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution2(n, height, weight));
    }

    private static Object solution2(int n, int[] height, int[] weight) {
        ArrayList<Body> arr = new ArrayList<>();
        int cnt = 1;
        for (int i = 0; i < n; i++){
            arr.add(new Body(height[i], weight[i]));
        }
        arr.sort((a,b) -> b.heigth - a.heigth);

        int max = arr.get(0).weight;
        for (int i = 1; i < n; i++) {
            if (max < arr.get(i).weight) {
                max = arr.get(i).weight;
                cnt++;
            }
        }
        return cnt;
    }

    //
    private static int solution1(int n, int[] height, int[] weight) {
        int answer = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < n; j++) {
                if (height[i] < height[j] && weight[i] < weight[j]) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }

    private static class Body {
        int heigth;
        int weight;

        public Body(int heigth, int weight) {
            this.heigth = heigth;
            this.weight = weight;
        }
    }
}
