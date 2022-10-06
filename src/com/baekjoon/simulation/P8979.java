package com.baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Country> countries = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Country country = new Country(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
            countries.add(country);
        }
        countries.sort(Collections.reverseOrder());
        int rank = 1;
        int cnt = 1;
        for (int i = 0; i < n - 1; i++) {
            Country c1 = countries.get(i);
            Country c2 = countries.get(i + 1);
            c1.rank = rank;
            if (c1.compareTo(c2) == 0) {
                cnt++;
            } else if (c1.compareTo(c2) != 0) {
                rank += cnt;
                cnt = 1;
            }
            if (c1.k == k) {
                System.out.println(c1.rank);
                break;
            }
            if (i == n - 2 && c2.k == k) {
                c2.rank = rank;
                System.out.println(rank);
            }
        }
    }

    private static class Country implements Comparable<Country> {
        final int k;
        int rank;
        final int gold;
        final int silver;
        final int bronze;

        public Country(int k, int gold, int silver, int bronze) {
            this.k = k;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return this.bronze - o.bronze;
                }
                return this.silver - o.silver;
            }
            return this.gold - o.gold;
        }
    }
}
