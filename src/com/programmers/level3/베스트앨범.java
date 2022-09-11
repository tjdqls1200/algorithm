package com.programmers.level3;

import java.util.*;

public class 베스트앨범 {
    static ArrayList<Integer> answer = new ArrayList<>();

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playSum = new HashMap<>();
        HashMap<String, ArrayList<Music>> playIndex = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            playSum.put(genres[i], playSum.getOrDefault(genres[i], 0) + plays[i]);
            if (!playIndex.containsKey(genres[i]))
                playIndex.put(genres[i], new ArrayList<>());
            playIndex.get(genres[i]).add(new Music(i, plays[i]));
        }
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(playSum.entrySet());
        entries.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

        for (Map.Entry<String, Integer> entry : entries) {
            String kind = entry.getKey();
            ArrayList<Music> list = playIndex.get(kind);
            list.sort((o1, o2) -> {
                if (o2.num == o1.num)
                    return o2.idx - o1.idx;
                return o2.num - o1.num;
            });
            pickMusic(answer, list);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static void pickMusic(ArrayList<Integer> answer, ArrayList<Music> list) {
        int cnt = 0;
        for (Music music : list) {
            answer.add(music.idx);
            cnt++;
            if (cnt == 2)
                break;
        }
    }

    private static class Music {
        int idx;
        int num;

        public Music(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
}
