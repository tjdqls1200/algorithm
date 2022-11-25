package com.programmers.level3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 다단계_칫솔 {
    static Map<String, Crew> crews = new HashMap<>();
    static Map<String, String> relations = new HashMap<>();
    public static void main(String[] args) {

    }

    public int[] solution(String[] enroll, String[] referral,
                          String[] seller, int[] amount) {
        List<Integer> answer = new ArrayList<>();

        for (String name : enroll) {
            crews.put(name, new Crew(name));
        }

        for (int i = 0; i < referral.length; i++) {
            relations.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < amount.length; i++) {
            int money = amount[i];
            String recommended = seller[i];
            String recommender = relations.get(recommended);
            while (money != 0) {
                money = distribute(recommended, recommender, money);
            }
        }

        for (Crew crew : crews.values()) {
            if ("-".equals(crew.name)) {
                continue;
            }
            System.out.println(crew.money);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int distribute(String recommended, String recommender, int money) {
        if ("-".equals(recommender) || money / 10 == 0) {
            crews.get(recommended).money += money;
            return 0;
        }
        crews.get(recommended).money += (money - (money / 10));
        
        return money / 10;
    }

    private class Crew {
        String name;
        int money;

        public Crew(String name) {
            this.name = name;
        }
    }
}
