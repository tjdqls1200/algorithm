package com.programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 가장_먼_노드_리스트 {

    public static void main(String[] args) {
        int[][] arr =new int[][]{{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};

        System.out.println(solution(6, arr));
    }

    public static int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        int[] ch = new int[n + 1];
        int move = 0;
        int cnt = 0;
        boolean flag;

        for (int i = 0; i <= n; i++)
            list.add(i, new ArrayList<>());
        for (int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }

        ch[1] = 1;
        q.offer(1);
        while(!q.isEmpty()) {
            int len = q.size();
            for (int l = 0; l < len; l++) {
                int p = q.poll();
                flag = true;
                ArrayList<Integer> temp = list.get(p);
                for (int c : temp) {
                    if (ch[c] == 0) {
                        flag = false;
                        ch[c] = 1;
                        q.offer(c);
                    }
                }
                if (flag)
                    hashMap.put(move, hashMap.getOrDefault(move, 0) + 1);
            }
            move++;
        }
        for (Integer value : hashMap.values())
            cnt = value;
        return cnt;
    }
}
