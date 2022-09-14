package com.programmers.level2;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

//public void permutation(String prefix, String str, HashSet<Integer> set) {
//        int n = str.length();
//        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
//        for (int i = 0; i < n; i++)
//        permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
//        i번쨰 숫자 붙이고, i번째 숫자 제외한 나머지로 str 재생성 재귀
// 123
// 1  -> 12, 13 -> 123, 132 | 1, 12, 13, 123, 132
// 2  -> 21, 23 -> 213, 231 | 2, 21, 23, 213, 231
// 3  -> 31, 32 -> 312, 321 | 3, 31, 32, 312, 321

public class 소수찾기 {
    static int m;
    static char[] chars;
    static boolean[] ch;
    static boolean[] prime;
    static Set<Integer> set;

    public int solution(String numbers) {
        set = new TreeSet<>();

        m = numbers.length();
        chars = numbers.toCharArray();
        ch = new boolean[m];

        int max = 10000000;
        prime = new boolean[max];
        prime[0] = prime[1] = true;
        for (int i = 2; i < Math.sqrt(max); i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
        DFS(0, 0);
        return set.size();
    }

    private void DFS(int L, int sum) {
        if (L == m) {
            if (!prime[sum])
                set.add(sum);
            return;
        } else {
            for (int i = 0; i < m; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    DFS(L + 1, sum * 10 + (chars[i] - '0'));
                    DFS(L + 1, sum);
                    ch[i] = false;
                }
            }
        }
    }
}
