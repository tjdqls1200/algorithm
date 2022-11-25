package com.programmers.level1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 로또 {
    public static void main(String[] args) {

    }


    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer;
        int winCount = 0;
        int deleteCount = 0;
        List<Integer> winNumbers = IntStream.of(win_nums)
                .boxed()
                .collect(Collectors.toList());

        for (int lotto : lottos) {
            if (lotto == 0) {
                deleteCount++;
            }
            if (winNumbers.contains(lotto)) {
                winCount++;
            }
        }

        int maxRank = decideRank(deleteCount + winCount);
        int minRank = decideRank(winCount);
        answer = new int[]{maxRank, minRank};

        return answer;
    }

    private int decideRank(int count) {
        int rank = 7 - count;
        if (rank == 7) {
            rank--;
        }
        return rank;
    }
}
