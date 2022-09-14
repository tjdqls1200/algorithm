package com.programmers.level2;

public class 피로도 {
    static boolean[] ch;
    static int m;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
            m = dungeons.length;
            ch = new boolean[m];
            DFS(0, k, 0, dungeons);

            return answer;
        }

    private void DFS(int L, int k, int clear, int[][] d) {
        if (L == m) {
            answer = Math.max(answer, clear);
        } else {
            for (int i = 0; i < m; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    if (k - d[i][1] >= 0 && k >= d[i][0]) {
                        DFS(L + 1, k - d[i][1], clear + 1, d);
                    }
                    DFS(L + 1, k, clear, d);
                    ch[i] = false;
                }
            }
        }
    }
}
