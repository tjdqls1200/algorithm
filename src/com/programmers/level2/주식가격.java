package com.programmers.level2;

import java.util.Stack;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Price> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            Price now = new Price(i, prices[i]);
            while (!stack.isEmpty() && stack.peek().value > now.value) {
                Price pop = stack.pop();
                answer[pop.idx] = i - pop.idx;
            }
            stack.push(now);
        }
        while (!stack.isEmpty()) {
            Price pop = stack.pop();
            answer[pop.idx] = prices.length - pop.idx - 1;
        }
        return answer;
    }

    private class Price {
        int idx;
        int value;

        public Price(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
