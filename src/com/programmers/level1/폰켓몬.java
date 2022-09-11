package com.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class 폰켓몬 {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int getPocket = nums.length / 2;
        for (int pocket : nums) {
            map.put(pocket, map.getOrDefault(pocket, 0) + 1);
        }
        int pockets = map.size();
        return Math.min(getPocket, pockets);
    }

//        return Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.collectingAndThen(Collectors.toSet(),
//                        p -> Integer.min(p.size(), getPocket)));
}
