package com.inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 결혼식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Room> arr = new ArrayList<>();
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Room(Integer.parseInt(st.nextToken()), 's'));
            arr.add(new Room(Integer.parseInt(st.nextToken()), 'e'));
        }
        System.out.println(solution(n, arr));
    }

    private static int solution(int n, ArrayList<Room> arr) {
        arr.sort((o1, o2) -> {
            if (o1.time == o2.time)
                return o1.state - o2.state;
            else
                return o1.time - o2.time;
        });
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (Room pos : arr) {
            if (pos.state == 's')
                cnt++;
            else
                cnt--;
            max = Math.max(max, cnt);
        }
        return max;
    }

    private static class Room {
        int time;
        char state;

        public Room(int time, char state) {
            this.time = time;
            this.state = state;
        }
    }
}
