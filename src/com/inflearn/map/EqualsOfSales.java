package com.inflearn.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EqualsOfSales {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] s = br.readLine().split(" ");
        for (int i : solution(n, k, s)) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static ArrayList<Integer> solution(int n, int k, String[] s) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>(k);
        ArrayList<Integer> result = new ArrayList<>();
        int lt = 0, rt;
        for (rt =  0; rt < k; rt++)
            map.put(s[rt], map.getOrDefault(s[rt], 0) + 1);
        result.add(map.size());
        for (rt = k; rt < n; rt++, lt++) {
            if (map.get(s[lt]) == 1)
                map.remove(s[lt]);
            else
                map.put(s[lt], map.get(s[lt]) - 1);
            map.put(s[rt], map.getOrDefault(s[rt], 0) + 1);
            result.add(map.size());
        }
        return result;
    }
}
