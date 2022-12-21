package com.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputUtil {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static BufferedReader inputReader() {
        return br;
    }

    public static String readLine() throws IOException {
        return br.readLine();
    }

    public static int[] readLineInts() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = st.countTokens();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        return result;
    }

    public static char[][] readCharMap(int y, int x) throws IOException {
        char[][] map = new char[y][x];

        for (int i = 0; i < y; i++) {
            map[i] = br.readLine().toCharArray();
        }

        return map;
    }

    public static int[][] readIntMap(int y, int x) throws IOException {
        int[][] map = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return map;
    }
}
